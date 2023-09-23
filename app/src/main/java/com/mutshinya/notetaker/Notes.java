package com.mutshinya.notetaker;

import java.util.ArrayList;

// Notes.java
import java.util.ArrayList;

public class Notes {
    public static ArrayList<String> notes = new ArrayList<>();
    public static ArrayList<String> title = new ArrayList<>();
    public static ArrayList<String> time = new ArrayList<>();

    public static void addNote(String note) {
        notes.add(note);
    }

    public static void addTitle(String noteTitle) {
        title.add(noteTitle);
    }

    public static void addTime(String noteTime) {
        time.add(noteTime);
    }


    public static String getNoteTitle(int index) {
        if (index >= 0 && index < title.size()) {
            return title.get(index);
        }
        return "";
    }

    public static String getNoteText(int index) {
        if (index >= 0 && index < notes.size()) {
            return notes.get(index);
        }
        return "";
    }

    public static String getNoteTime(int index) {
        if (index >= 0 && index < time.size()) {
            return time.get(index);
        }
        return "";
    }

    public static void remove(int index){
        if (index >= 0 && index < title.size()) {
            notes.remove(index);
            time.remove(index);
            title.remove(index);
        }
    }

    public static void putNote(int index,String element){
        notes.remove(index);
        notes.add(index,element);
    }
    public static void putTitle(int index,String element){
        title.remove(index);
        title.add(index,element);
    }
    public static void putTime(int index,String element){
        time.remove(index);
        time.add(index,element);
    }
}



