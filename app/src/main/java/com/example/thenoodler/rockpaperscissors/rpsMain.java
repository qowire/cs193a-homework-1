package com.example.thenoodler.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class rpsMain extends AppCompatActivity {
    private int playerScore = 0;
    private int computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps_main);
    }

    public void rockClicked(View view) {
        userClick("rock", view);
    }

    public void scissorsClicked(View view) {
        userClick("scissors", view);
    }

    public void paperClicked(View view) {
        userClick("paper", view);
    }

    private void userClick(String input, View view) {
        Random rdm = new Random();
        int randomNumber = rdm.nextInt(3);
        int id = view.getId();
        ImageView image = (ImageView) findViewById(R.id.computerImage);
        switch(randomNumber) {
            case 0:
                processInput("rock", input);
                image.setImageResource(R.drawable.pscomputerrock);
                break;
            case 1:
                processInput("paper", input);
                image.setImageResource(R.drawable.pscomputerpaper);
                break;
            case 2:
                processInput("scissors", input);
                image.setImageResource(R.drawable.pscomputerscissors);
                break;
        }
        TextView playerView = (TextView) findViewById(R.id.playerScore);
        TextView computerView = (TextView) findViewById(R.id.computerScore);
        playerView.setText("Player Score: " + playerScore);
        computerView.setText("Computer Score: " + computerScore);
    }

    private void processInput(String generated, String input) {
        Toast toast;
        if (input.equals("rock")) {
            if (generated.equals("scissors")) {
                playerScore++;
                toast = Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_SHORT);
            } else if (generated.equals("paper")) {
                computerScore++;
                toast = Toast.makeText(getApplicationContext(), "You Lose", Toast.LENGTH_SHORT);
            } else {
                toast = Toast.makeText(getApplicationContext(), "You Tie.", Toast.LENGTH_SHORT);
            }
        } else if (input.equals("scissors")) {
            if (generated.equals("paper")) {
                playerScore++;
                toast = Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_SHORT);
            } else if (generated.equals("rock")) {
                computerScore++;
                toast = Toast.makeText(getApplicationContext(), "You Lose", Toast.LENGTH_SHORT);
            } else {
                toast = Toast.makeText(getApplicationContext(), "You Tie.", Toast.LENGTH_SHORT);
            }
        } else if (input.equals("paper")) {
            if (generated.equals("rock")) {
                playerScore++;
                toast = Toast.makeText(getApplicationContext(), "You Win!", Toast.LENGTH_SHORT);
            } else if (generated.equals("scissors")) {
                computerScore++;
                toast = Toast.makeText(getApplicationContext(), "You Lose", Toast.LENGTH_SHORT);
            } else {
                toast = Toast.makeText(getApplicationContext(), "You Tie", Toast.LENGTH_SHORT);
            }
            toast.show();
            System.out.println("toast shown");
        }
    }
}
