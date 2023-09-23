package com.mutshinya.notetaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public ImageButton addNote;
    public int flag;
    public ImageButton menuButton;
    private GridLayout cardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the Extra from AddNoteActivity
        flag = getIntent().getIntExtra("flag", -1);
        //add UI components
        addNote = findViewById(R.id.addButton);
        cardLayout = findViewById(R.id.cardLayout);
        menuButton = findViewById(R.id.Menu);

        //get size of notes arraylist
        int notesCount = Notes.notes.size();
        Toast.makeText(this, String.valueOf(notesCount), Toast.LENGTH_SHORT).show();


        //On click note adding button
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });

        //create card views according to the arraylist size
        for (int i = 0; i < notesCount; i++) {
            createCardView(i);
        }
    }
    /*
     *  Method to create card view with necessary elements
     */
    private CardView createCardView(int index) {
        CardView cardView = (CardView) LayoutInflater.from(this).inflate(R.layout.cardview_layout, cardLayout, false);

        TextView noteHeading = cardView.findViewById(R.id.Notehead0);
        TextView noteText = cardView.findViewById(R.id.Note0);
        TextView noteTime = cardView.findViewById(R.id.Notetime0);
        ImageButton deleteButton = cardView.findViewById(R.id.Notedelete0);

        // Set data for the card here (e.g., note title, time, etc.)
        noteHeading.setText(Notes.getNoteTitle(index));
        noteText.setText(Notes.getNoteText(index));
        noteTime.setText(Notes.getNoteTime(index));
        // Set up delete button click listener
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform delete operation for this card
                cardLayout.removeView(cardView);
                Notes.remove(index);
            }
        });
        //  Edit card view notes by clicking the card view
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,AddNoteActivity.class);
                intent.putExtra("index",index);
                startActivity(intent);
            }
        });

        cardLayout.addView(cardView, 0);
        return cardView;
    }

}


