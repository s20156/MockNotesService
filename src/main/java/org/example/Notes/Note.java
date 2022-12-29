package org.example.Notes;

public class Note {
    private String text;
    private String name;

    public Note(String text, String name) {
        this.text = text;
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNote() {
        return this.getText().length();
    }
}
