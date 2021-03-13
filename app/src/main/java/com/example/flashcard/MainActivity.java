package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        TextView receiver_msg;
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




    }
    public void openAddbutton() {
        Intent intent = new Intent(MainActivity.this, addButton.class);
        startActivityForResult(intent, 100);


    }


    @SuppressLint("MissingSuperCall")

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100) { // this 100 needs to match the 100 we used when we called startActivityForResult!
          String string1 = data.getExtras().getString("string1"); // 'string1' needs to match the key we used when we put the string in the Intent
           String string2 = data.getExtras().getString("string2");
            ((TextView) findViewById(R.id.question)).setText(string1);
          ((TextView) findViewById(R.id.answer)).setText(string2);

        }


    }
}