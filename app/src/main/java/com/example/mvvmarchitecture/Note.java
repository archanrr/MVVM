package com.example.mvvmarchitecture;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    @ColumnInfo(name = "priority_col")
    private String priority;

    public Note(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }
}