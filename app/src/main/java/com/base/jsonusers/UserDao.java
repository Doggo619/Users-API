package com.base.jsonusers;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(List<UserEntity> userEntities);

    @Query("SELECT * FROM users")
    LiveData<List<UserEntity>> getAllUsers();
}
