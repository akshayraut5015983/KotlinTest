package com.example.mykotlinapp.databse

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NOteDao {
    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("delete from note_table")
    fun deleteAllNotes()

    @Query("select * from note_table order by priority desc")
    fun getAllNotes(): LiveData<List<Note>>
}