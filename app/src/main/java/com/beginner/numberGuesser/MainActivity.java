package com.beginner.numberGuesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int generateRandomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(20)+1;
        return randomNumber;
    }

    int numberToGuessInt = generateRandomNumber();
    int numberOfGuessesInt = 0;

    public void onSubmit(View view) {
        EditText guessedNumber = findViewById(R.id.guessedNumber);
        TextView message = findViewById(R.id.message);
        TextView numberOfGuesses = findViewById(R.id.numberOfGuesses);
        Button submitButton = findViewById(R.id.submit);

        String numberGuessed;
        numberGuessed = guessedNumber.getText().toString();

        guessedNumber.setText("");

        while(numberGuessed != null) {
            numberOfGuessesInt++;
            int numberGuessedInt = Integer.parseInt(numberGuessed);
            if (numberGuessedInt > numberToGuessInt) {
                message.setText("Enter Lower Number");
                break;
            } else if (numberGuessedInt < numberToGuessInt) {
                message.setText("Enter Higher Number");
                break;
            } else if (numberGuessedInt == numberToGuessInt) {
                message.setText("Correct! Great Work\n" + "Click Retry To Play This Again");
                submitButton.setEnabled(false);
                break;
            }
        }
        String numberOfGuessesString = Integer.toString(numberOfGuessesInt);
        numberOfGuesses.setText("Guesses:" + numberOfGuessesString);
    }

    public void retry(View view){
        finish();
        startActivity(new Intent(this,MainActivity.class));
        overridePendingTransition(0,0);
    }
}
