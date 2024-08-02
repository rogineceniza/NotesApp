package com.example.notescraft;


import com.google.firebase.Timestamp;

public class Note {

    //declares variables for UI elements
    String title;
    String content;
    Timestamp timestamp;


    // The constructor public Note() initializes a new Note object.
    public Note() {
    }



    //These are getter and setter methods for a Note class.
    // They allow access to and modification of the title,
    // content, and timestamp properties of a Note object.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}