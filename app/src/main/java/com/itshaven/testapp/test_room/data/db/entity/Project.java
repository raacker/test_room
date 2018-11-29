package com.itshaven.testapp.test_room.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(
        tableName = "TB_PROJECT",
        indices = {@Index(name = "person_idx", value = {"person_id"})},
        foreignKeys = {@ForeignKey(entity = Person.class,
                parentColumns = {"person_id"},
                childColumns = {"person_id"},
                onDelete = ForeignKey.CASCADE)
        }
)
public class Project {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "project_id")
    public int project_id;

    @ColumnInfo(name = "person_id")
    public int person_id;

    @ColumnInfo(name = "project_name")
    public String project_name;
}
