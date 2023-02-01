package com.prashant.dependecyinjection.app

import android.content.Context
import com.prashant.dependecyinjection.apicallings.ApiService
import com.prashant.dependecyinjection.repo.Repo
import com.prashant.dependecyinjection.roomdb.NoteDao
import com.prashant.dependecyinjection.roomdb.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiObject {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/apis/")
            .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepo(@ApplicationContext context: Context): Repo =
        Repo(NoteDatabase.getInstance(context).noteDao())

}