package com.prashant.dependecyinjection.repo

import androidx.lifecycle.LiveData
import com.prashant.dependecyinjection.roomdb.Note
import com.prashant.dependecyinjection.roomdb.NoteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class Repo @Inject constructor(
    private val userDao: NoteDao
) {
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insert(note: Note) {
        coroutineScope.launch {
            userDao.insert(note)
        }
    }

    fun update(note: Note) {
        coroutineScope.launch { userDao.update(note) }
    }

    fun delete(note: Note) {
        coroutineScope.launch { userDao.delete(note) }
    }

    fun deleteAllNotes() {
        coroutineScope.launch { userDao.deleteAllNotes() }
    }

    fun findUserById(id: Int): Note= runBlocking {
        userDao.findUserById(id)
    }

    fun getAllNotes(): LiveData<List<Note>> = userDao.getAllNotes()
}