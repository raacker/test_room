package com.itshaven.testapp.test_room.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.itshaven.testapp.test_room.data.db.dao.PersonDao;
import com.itshaven.testapp.test_room.data.db.dao.ProjectDao;
import com.itshaven.testapp.test_room.data.db.entity.Person;
import com.itshaven.testapp.test_room.data.db.entity.Project;

@Database(entities = {Person.class, Project.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
    public abstract ProjectDao projectDao();
}
