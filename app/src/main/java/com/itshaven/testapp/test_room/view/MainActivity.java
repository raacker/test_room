package com.itshaven.testapp.test_room.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.itshaven.testapp.test_room.R;
import com.itshaven.testapp.test_room.TestApplication;
import com.itshaven.testapp.test_room.data.db.AppDatabase;
import com.itshaven.testapp.test_room.data.db.Executor;
import com.itshaven.testapp.test_room.data.db.dao.PersonDao;
import com.itshaven.testapp.test_room.data.db.entity.Person;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    AppDatabase mAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TestApplication)getApplication()).getComponent().inject(this);
        final PersonDao personDao = mAppDatabase.personDao();
        Executor.IOThread(() -> personDao.insert(new Person()));
    }
}
