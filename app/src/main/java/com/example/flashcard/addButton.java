package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addButton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button);

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

 findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         EditText Etext = (EditText) findViewById(R.id.editTextField);
         EditText AQuestion = (EditText) findViewById(R.id.QuestionTextField);
         ((EditText) findViewById(R.id.QuestionTextField)).getText().toString();
         Intent data = new Intent();
         data.putExtra("string1",AQuestion.getText().toString()); // puts one string into the Intent, with the key as 'string1'
         data.putExtra("string2",Etext.getText().toString()); // puts another string into the Intent, with the key as 'string2
         setResult(RESULT_OK, data); // set result code and bundle data for response

         finish(); // closes this activity and pass data to the original activity that launched this
     }
 });

    }


}