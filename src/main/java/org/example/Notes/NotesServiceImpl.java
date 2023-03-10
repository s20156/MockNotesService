package org.example.Notes;

import java.util.Collection;
import java.util.regex.Pattern;

public class NotesServiceImpl implements NotesService {
    public static NotesServiceImpl createWith(final NotesStorage storageService) {
        return new NotesServiceImpl(storageService);
    }

    @Override
    public void add(Note note) {
        storageService.add(note);
    }

    @Override
    public float averageOf(String name) {
        float sum = 0.0f;
        final Collection<Note> notes = storageService.getAllNotesOf(name);
        for (final Note note: notes) {
            sum += note.getNote();
        }
        return sum / notes.size();
    }

    @Override
    public void clear() {
        storageService.clear();
    }

    public int countNotes() {
        return this.storageService.getAllNotesOf("").size();
    }

    NotesServiceImpl(final NotesStorage storageService) {
        this.storageService = storageService;
    }
    private final NotesStorage storageService;
}
