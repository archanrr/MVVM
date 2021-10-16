package com.example.mvvmarchitecture;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository{
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes= noteDao.getAllNotes();
        Toast.makeText(application, ""+allNotes, Toast.LENGTH_SHORT).show();
    }

    public void insert(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(()->{
            noteDao.insert(note);
        });
    }


    public void update(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(()->{
            noteDao.update(note);
        });
    }


    public void delete(Note note) {
        NoteDatabase.databaseWriteExecutor.execute(()->{
            noteDao.delete(note);
        });
    }


    public void deleteAllNotes() {
        NoteDatabase.databaseWriteExecutor.execute(()->{
            noteDao.deleteAllNotes();
        });
    }


    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
