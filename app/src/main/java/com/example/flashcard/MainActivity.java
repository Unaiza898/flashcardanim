package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        TextView receiver_msg;
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(this);
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.answer)).setText(allFlashcards.get(0).getAnswer());
        }
        setContentView(R.layout.activity_main);
        findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
               findViewById(R.id.question).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer).setVisibility(View.VISIBLE);


            }
        });
        findViewById(R.id.answer).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
             findViewById(R.id.question).setVisibility(View.VISIBLE);
                findViewById(R.id.answer).setVisibility(View.INVISIBLE);


            }
        });

        findViewById(R.id.addbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAddbutton();
            }
        });

        findViewById(R.id.arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (allFlashcards.size() == 0)
                    return;

                currentCardDisplayedIndex++;

                allFlashcards = flashcardDatabase.getAllCards();
                Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);

                ((TextView) findViewById(R.id.question)).setText(flashcard.getAnswer());
                ((TextView) findViewById(R.id.answer)).setText(flashcard.getQuestion());


            }
        });




    }
    public void openAddbutton() {
        Intent intent = new Intent(MainActivity.this, addButton.class);
        startActivityForResult(intent, 100);


    }


    @SuppressLint("MissingSuperCall")

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 100 && resultCode == RESULT_OK) {
                String question = data.getExtras().getString("string1");
                String answer = data.getExtras().getString("string2");

                ((TextView) findViewById(R.id.question)).setText(question);
                ((TextView) findViewById(R.id.answer)).setText(answer);

                flashcardDatabase.insertCard(new Flashcard(question, answer));
                allFlashcards = flashcardDatabase.getAllCards();
            }
        }



}