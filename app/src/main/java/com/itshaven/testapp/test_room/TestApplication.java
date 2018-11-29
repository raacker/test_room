package com.itshaven.testapp.test_room;

import android.app.Application;

import com.itshaven.testapp.test_room.di.component.ApplicationComponent;
import com.itshaven.testapp.test_room.di.component.DaggerApplicationComponent;
import com.itshaven.testapp.test_room.di.module.ApplicationModule;
import com.itshaven.testapp.test_room.di.module.DatabaseModule;

public class TestApplication extends Application {
    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .databaseModule(new DatabaseModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
