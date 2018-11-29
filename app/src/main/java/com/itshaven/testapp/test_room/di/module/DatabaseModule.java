package com.itshaven.testapp.test_room.di.module;


import android.arch.persistence.room.Room;
import android.content.Context;

import com.itshaven.testapp.test_room.data.db.AppDatabase;
import com.itshaven.testapp.test_room.data.db.dao.PersonDao;
import com.itshaven.testapp.test_room.data.db.dao.ProjectDao;
import com.itshaven.testapp.test_room.di.ApplicationContext;
import com.itshaven.testapp.test_room.di.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @ApplicationContext
    private final Context mContext;

    @DatabaseInfo
    private final String mDBName = "test_database.db";

    public DatabaseModule (@ApplicationContext Context context) {
        mContext = context;
    }

    @Singleton
    @Provides
    AppDatabase provideDatabase () {
        return Room.databaseBuilder(
                mContext,
                AppDatabase.class,
                mDBName
        ).fallbackToDestructiveMigration().build();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() { return mDBName; }

    @Singleton
    @Provides
    PersonDao providePersonDao(AppDatabase db) { return db.personDao(); }

    @Singleton
    @Provides
    ProjectDao provideProjectDao(AppDatabase db) { return db.projectDao(); }
}
