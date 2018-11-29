package com.itshaven.testapp.test_room.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.itshaven.testapp.test_room.data.db.entity.Person;

import java.util.List;

@Dao
public interface PersonDao extends BaseDao<Person> {
    @Query("SELECT * FROM TB_PERSON")
    List<Person> getAll();

    @Query("SELECT * FROM TB_PERSON WHERE name LIKE :name")
    List<Person> findPersonsByName(String name);
}
