package org.example.Notes;

import java.util.*;
import java.util.stream.Collectors;

public class MockNotesStorage implements NotesStorage {
    private List<Note> notes = new ArrayList<Note>();
    public MockNotesStorage() {
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


    @Override
    public void add(Note note) {
        List<Note> notes = getNotes();
        notes.add(note);
        setNotes(notes);
    }

    @Override
    public List<Note> getAllNotesOf(String name) {
        if (name.length() > 0) {
            return getNotes().stream().filter(item -> item.getName() == name).collect(Collectors.toList());
        } else {
            return getNotes().stream().collect(Collectors.toList());
        }
    }

    @Override
    public void clear() {
        setNotes(new ArrayList<>());
    }
}
