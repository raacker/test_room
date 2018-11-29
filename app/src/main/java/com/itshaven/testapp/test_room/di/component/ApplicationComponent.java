package com.itshaven.testapp.test_room.di.component;

import android.app.Application;
import android.content.Context;

import com.itshaven.testapp.test_room.TestApplication;
import com.itshaven.testapp.test_room.di.ApplicationContext;
import com.itshaven.testapp.test_room.di.DatabaseInfo;
import com.itshaven.testapp.test_room.di.module.ApplicationModule;
import com.itshaven.testapp.test_room.di.module.DatabaseModule;
import com.itshaven.testapp.test_room.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DatabaseModule.class,
})
public interface ApplicationComponent {
    void inject (TestApplication testApplication);
    void inject (MainActivity mainActivity);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    @DatabaseInfo
    String getDatabaseName();
}
