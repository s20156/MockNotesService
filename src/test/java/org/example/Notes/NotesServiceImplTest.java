package org.example.Notes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotesServiceImplTest {
    MockNotesStorage notesStorage;
    NotesServiceImpl notesService;

    @BeforeEach
    public void setUp() {
        notesStorage = new MockNotesStorage();
        notesService = new NotesServiceImpl(notesStorage);
    }

    @Test
    public void testAddNote() {
        notesService.add(new Note("Lorem ipsum dolor", "Test"));
        Assertions.assertEquals(1, notesService.countNotes());
    }

    @Test
    public void testClearNotes() {
        notesService.add(new Note("Lorem ipsum dolor", "Test"));
        notesService.clear();
        Assertions.assertEquals(0, notesService.countNotes());
    }

    @Test
    public void testAverageOf() {
        notesService.add(new Note("Lorem", "Test"));
        notesService.add(new Note("A", "Test"));
        Assertions.assertEquals(3.0, notesService.averageOf("Test"));
    }

    @Test
    public void testAverageOfNonExistingUser() {
        notesService.add(new Note("Lorem", "Test"));
        notesService.add(new Note("A", "Test"));
        Assertions.assertNotEquals(3.0, notesService.averageOf("Jim"));
    }
    @AfterEach
    public void tearDown() {
        notesService.clear();
    }
}