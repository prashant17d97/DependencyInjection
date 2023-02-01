package com.prashant.dependecyinjection.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("delete from note_table")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM note_table WHERE id = :id")
    suspend fun findUserById(id: Int): Note

    @Query("SELECT * FROM note_table ORDER BY id ASC")
     fun getAllNotes(): LiveData<List<Note>>
}