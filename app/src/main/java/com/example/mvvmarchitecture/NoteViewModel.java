package com.example.mvvmarchitecture;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel{

    private NoteRepository repo;
    private LiveData<List<Note>> allNotes;
    public NoteViewModel(Application application) {
        super(application);
        repo = new NoteRepository(application);
        allNotes = repo.getAllNotes();
    }

    public void insert(Note note) {
        repo.insert(note);
    }

    public void update(Note note) {
        repo.update(note);

    }
    public void delete(Note note) {
        repo.delete(note);
    }
    public void deleteAllNotes() {
        repo.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
