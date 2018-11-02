package com.example.mark.roomexample.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

// For more information on how to use DAOs with Room, see https://developer.android.com/training/data-storage/room/accessing-data

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    //If conflicts are possible, you can use @Insert(onConflict = OnConflictStrategy.REPLACE)

    @Delete
    void delete(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}
