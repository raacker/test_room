package com.itshaven.testapp.test_room.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.itshaven.testapp.test_room.data.db.entity.Project;

import java.util.List;

@Dao
public interface ProjectDao extends BaseDao<Project> {
    @Query("SELECT * FROM TB_PROJECT")
    List<Project> getAll();

    @Query("SELECT * FROM TB_PROJECT WHERE person_id LIKE :person_id")
    List<Project> findProjectsByName(int person_id);
}
