package com.mutshinya.notetaker;
// AddNoteActivity.java
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AddNoteActivity extends AppCompatActivity {

    private ImageButton saveNotes;
    public EditText title;
    public EditText note;
    String time = "13:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        // get extra from main activity
        int index = getIntent().getIntExtra("index", -1);
        saveNotes = findViewById(R.id.doneButton);
        title = findViewById(R.id.noteHeading);
        note = findViewById(R.id.notewritten);

        //edit note if index >= 0
        if(index>=0){
            title.setText(Notes.getNoteTitle(index));
            note.setText(Notes.getNoteText(index));
        }

        saveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String head = title.getText().toString().trim();
                String notes = note.getText().toString().trim();
                if(index==-1) {
                    setNotes(head, notes, time);

                }
                else {
                    updateNote(head, notes, time, index);

                }
                Intent intent = new Intent(AddNoteActivity.this,MainActivity.class);
                intent.putExtra("flag",2);
                startActivity(intent);
            }
        });
    }

    /*
     * set notes
     */
    public void setNotes(String head, String notes, String time) {
        Notes.addNote(notes);
        Notes.addTitle(head);
        Notes.addTime(time);
    }

    /*
     * update notes
     */
    public void updateNote(String title, String notes, String time, int index){
        Notes.putNote(index,notes);
        Notes.putTitle(index,title);
        Notes.putTime(index,time);
    }

}
