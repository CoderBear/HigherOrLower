package com.hilow.sbsapps.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand;
    int randomNumber;

    public void generateRandomNumber() {
        rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void guess(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);

        Log.i("info", Integer.toString(randomNumber));

        int guessedNumber = Integer.parseInt(editText.getText().toString());

        String message;

        if (guessedNumber > randomNumber) {
            message = "Lower";
        }
        else if (guessedNumber < randomNumber) {
            message = "Higher";
        } else {
            message = "You got it!";
            
            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}
