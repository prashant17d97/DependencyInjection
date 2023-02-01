package com.prashant.dependecyinjection

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prashant.dependecyinjection.apicallings.ApiService
import com.prashant.dependecyinjection.repo.Repo
import com.prashant.dependecyinjection.roomdb.Note
import com.prashant.dependecyinjection.roomdb.NoteDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val apiService: ApiService,
    private val repo: Repo
) : ViewModel() {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val getAllNotes = repo.getAllNotes()
    lateinit var note: Note

    fun add(note: Note) {
        repo.insert(note)
    }

    fun getById(id: Int) = repo.findUserById(id)

    fun deleteAllNotes() = repo.deleteAllNotes()
}