package com.itshaven.testapp.test_room.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

@Dao
public interface BaseDao<T>  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(T t);

    @Update
    void update(T t);

    @Delete
    void delete(T t);
}
