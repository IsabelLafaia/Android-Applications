package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreSpeakerA = 0; // Total score for speaker A
    int CriteriaASpeakerA = 0;
    int CriteriaBSpeakerA = 0;
    int CriteriaCSpeakerA = 0;
    int CriteriaDSpeakerA = 0;

    int scoreSpeakerB = 0; // Total score for speaker B
    int CriteriaASpeakerB = 0;
    int CriteriaBSpeakerB = 0;
    int CriteriaCSpeakerB = 0;
    int CriteriaDSpeakerB = 0;


    int maxScore = 5; // The score for each criteria has to be a number from 0 to 5.
    int minScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If onCreate is called during the execution of the app,
        // reload the values of the parameters, which will otherwise
        // be lost. This is useful to avoid reseting when changing
        // the orientation of the screen between landscape and portrait.
        if (savedInstanceState != null) {
            String message = savedInstanceState.getString("message");
            scoreSpeakerA = savedInstanceState.getInt("scoreSpeakerA"); displaySpeakerA(scoreSpeakerA);
            CriteriaASpeakerA = savedInstanceState.getInt("CriteriaASpeakerA"); displayCriteriaASpeakerA(CriteriaASpeakerA);
            CriteriaBSpeakerA = savedInstanceState.getInt("CriteriaBSpeakerA"); displayCriteriaBSpeakerA(CriteriaBSpeakerA);
            CriteriaCSpeakerA = savedInstanceState.getInt("CriteriaCSpeakerA"); displayCriteriaCSpeakerA(CriteriaCSpeakerA);
            CriteriaDSpeakerA = savedInstanceState.getInt("CriteriaDSpeakerA"); displayCriteriaDSpeakerA(CriteriaDSpeakerA);

            scoreSpeakerB = savedInstanceState.getInt("scoreSpeakerB"); // Total score for speaker B
            CriteriaASpeakerB = savedInstanceState.getInt("CriteriaASpeakerB");
            CriteriaBSpeakerB = savedInstanceState.getInt("CriteriaBSpeakerB");
            CriteriaCSpeakerB = savedInstanceState.getInt("CriteriaCSpeakerB");
            CriteriaDSpeakerB = savedInstanceState.getInt("CriteriaDSpeakerB");
        }
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Need to save values in case of changing the screen orientation
        // to avoid reseting of all parameters.
        outState.putInt("scoreSpeakerA", scoreSpeakerA);
        outState.putInt("CriteriaASpeakerA", CriteriaASpeakerA);
        outState.putInt("CriteriaBSpeakerA", CriteriaBSpeakerA);
        outState.putInt("CriteriaCSpeakerA", CriteriaCSpeakerA);
        outState.putInt("CriteriaDSpeakerA", CriteriaDSpeakerA);
        outState.putInt("scoreSpeakerB", scoreSpeakerB);
        outState.putInt("CriteriaASpeakerB", CriteriaASpeakerB);
        outState.putInt("CriteriaBSpeakerB", CriteriaBSpeakerB);
        outState.putInt("CriteriaCSpeakerB", CriteriaCSpeakerB);
        outState.putInt("CriteriaDSpeakerB", CriteriaDSpeakerB);
    }

    // Functions for criteria A, speaker A
    private void resetCriteriaASpeakerA(View view){

        CriteriaASpeakerA = 0;
        displayCriteriaASpeakerA(CriteriaASpeakerA);
    }
    public void incrementCriteriaASpeakerA(View view){

        if (CriteriaASpeakerA < maxScore) { // Increment only if under the limit.
            CriteriaASpeakerA = CriteriaASpeakerA + 1;
            displayCriteriaASpeakerA(CriteriaASpeakerA);
            scoreSpeakerA = scoreSpeakerA + 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    public void decrementCriteriaASpeakerA(View view){

        if (CriteriaASpeakerA > minScore) { // Decrement only if above the limit.
            CriteriaASpeakerA = CriteriaASpeakerA - 1;
            displayCriteriaASpeakerA(CriteriaASpeakerA);
            scoreSpeakerA = scoreSpeakerA - 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    private void displayCriteriaASpeakerA(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerA_criteria1);
        scoreView.setText(String.valueOf(score));
    }




    // Functions for criteria B, speaker A
    public void resetCriteriaBSpeakerA(View view){

        CriteriaBSpeakerA = 0;
        displayCriteriaBSpeakerA(CriteriaBSpeakerA);
    }
    public void incrementCriteriaBSpeakerA(View view){

        if (CriteriaBSpeakerA < maxScore) { // Increment only if under the limit.
            CriteriaBSpeakerA = CriteriaBSpeakerA + 1;
            displayCriteriaBSpeakerA(CriteriaBSpeakerA);
            scoreSpeakerA = scoreSpeakerA + 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    public void decrementCriteriaBSpeakerA(View view){

        if (CriteriaBSpeakerA > minScore) { // Decrement only if above the limit.
            CriteriaBSpeakerA = CriteriaBSpeakerA - 1;
            displayCriteriaBSpeakerA(CriteriaBSpeakerA);
            scoreSpeakerA = scoreSpeakerA - 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    private void displayCriteriaBSpeakerA(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerA_criteria2);
        scoreView.setText(String.valueOf(score));
    }



    // Functions for criteria C, speaker A
    public void resetCriteriaCSpeakerA(View view){

        CriteriaCSpeakerA = 0;
        displayCriteriaCSpeakerA(CriteriaCSpeakerA);
    }
    public void incrementCriteriaCSpeakerA(View view){

        if (CriteriaCSpeakerA < maxScore) { // Increment only if under the limit.
            CriteriaCSpeakerA = CriteriaCSpeakerA + 1;
            displayCriteriaCSpeakerA(CriteriaCSpeakerA);
            scoreSpeakerA = scoreSpeakerA + 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    public void decrementCriteriaCSpeakerA(View view){

        if (CriteriaCSpeakerA > minScore) { // Decrement only if above the limit.
            CriteriaCSpeakerA = CriteriaCSpeakerA - 1;
            displayCriteriaCSpeakerA(CriteriaCSpeakerA);
            scoreSpeakerA = scoreSpeakerA - 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    private void displayCriteriaCSpeakerA(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerA_criteria3);
        scoreView.setText(String.valueOf(score));
    }



    // Functions for criteria D, speaker A
    public void resetCriteriaDSpeakerA(View view){

        CriteriaDSpeakerA = 0;
        displayCriteriaDSpeakerA(CriteriaDSpeakerA);
    }
    public void incrementCriteriaDSpeakerA(View view){

        if (CriteriaDSpeakerA < maxScore) { // Increment only if under the limit.
            CriteriaDSpeakerA = CriteriaDSpeakerA + 1;
            displayCriteriaDSpeakerA(CriteriaDSpeakerA);
            scoreSpeakerA = scoreSpeakerA + 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    public void decrementCriteriaDSpeakerA(View view){

        if (CriteriaDSpeakerA > minScore) { // Decrement only if above the limit.
            CriteriaDSpeakerA = CriteriaDSpeakerA - 1;
            displayCriteriaDSpeakerA(CriteriaDSpeakerA);
            scoreSpeakerA = scoreSpeakerA - 1;
            displaySpeakerA(scoreSpeakerA);
        }
    }
    private void displayCriteriaDSpeakerA(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerA_criteria4);
        scoreView.setText(String.valueOf(score));
    }


    // Functions for global score of speaker 1
    public void resetSpeakerA(View view){

        scoreSpeakerA = 0; displaySpeakerA(scoreSpeakerA);
        CriteriaASpeakerA = 0; displayCriteriaASpeakerA(CriteriaASpeakerA);
        CriteriaBSpeakerA = 0; displayCriteriaBSpeakerA(CriteriaBSpeakerA);
        CriteriaCSpeakerA = 0; displayCriteriaCSpeakerA(CriteriaCSpeakerA);
        CriteriaDSpeakerA = 0; displayCriteriaDSpeakerA(CriteriaDSpeakerA);
    }

    private void displaySpeakerA(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerA_score);
        scoreView.setText(String.valueOf(score));
    }



    ///////////////////////////////////////////////////////////////

    // Functions for criteria A, speaker A
    public void resetCriteriaASpeakerB(View view){

        CriteriaASpeakerB = 0;
        displayCriteriaASpeakerB(CriteriaASpeakerB);
    }
    public void incrementCriteriaASpeakerB(View view){

        if (CriteriaASpeakerB < maxScore) { // Increment only if under the limit.
            CriteriaASpeakerB = CriteriaASpeakerB + 1;
            displayCriteriaASpeakerB(CriteriaASpeakerB);
            scoreSpeakerB = scoreSpeakerB + 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    public void decrementCriteriaASpeakerB(View view){

        if (CriteriaASpeakerB > minScore) { // Decrement only if above the limit.
            CriteriaASpeakerB = CriteriaASpeakerB - 1;
            displayCriteriaASpeakerB(CriteriaASpeakerB);
            scoreSpeakerB = scoreSpeakerB - 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    private void displayCriteriaASpeakerB(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerB_criteria1);
        scoreView.setText(String.valueOf(score));
    }




    // Functions for criteria B, speaker A
    public void resetCriteriaBSpeakerB(View view){

        CriteriaBSpeakerB = 0;
        displayCriteriaBSpeakerB(CriteriaBSpeakerB);
    }
    public void incrementCriteriaBSpeakerB(View view){

        if (CriteriaBSpeakerB < maxScore) { // Increment only if under the limit.
            CriteriaBSpeakerB = CriteriaBSpeakerB + 1;
            displayCriteriaBSpeakerB(CriteriaBSpeakerB);
            scoreSpeakerB = scoreSpeakerB + 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    public void decrementCriteriaBSpeakerB(View view){

        if (CriteriaBSpeakerB > minScore) { // Decrement only if above the limit.
            CriteriaBSpeakerB = CriteriaBSpeakerB - 1;
            displayCriteriaBSpeakerB(CriteriaBSpeakerB);
            scoreSpeakerB = scoreSpeakerB - 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    private void displayCriteriaBSpeakerB(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerB_criteria2);
        scoreView.setText(String.valueOf(score));
    }



    // Functions for criteria C, speaker A
    public void resetCriteriaCSpeakerB(View view){

        CriteriaCSpeakerB = 0;
        displayCriteriaCSpeakerB(CriteriaCSpeakerB);
    }
    public void incrementCriteriaCSpeakerB(View view){

        if (CriteriaCSpeakerB < maxScore) { // Increment only if under the limit.
            CriteriaCSpeakerB = CriteriaCSpeakerB + 1;
            displayCriteriaCSpeakerB(CriteriaCSpeakerB);
            scoreSpeakerB = scoreSpeakerB + 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    public void decrementCriteriaCSpeakerB(View view){

        if (CriteriaCSpeakerB > minScore) { // Decrement only if above the limit.
            CriteriaCSpeakerB = CriteriaCSpeakerB - 1;
            displayCriteriaCSpeakerB(CriteriaCSpeakerB);
            scoreSpeakerB = scoreSpeakerB - 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    private void displayCriteriaCSpeakerB(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerB_criteria3);
        scoreView.setText(String.valueOf(score));
    }



    // Functions for criteria D, speaker A
    public void resetCriteriaDSpeakerB(View view){

        CriteriaDSpeakerB = 0;
        displayCriteriaDSpeakerB(CriteriaDSpeakerB);
    }
    public void incrementCriteriaDSpeakerB(View view){

        if (CriteriaDSpeakerB < maxScore) { // Increment only if under the limit.
            CriteriaDSpeakerB = CriteriaDSpeakerB + 1;
            displayCriteriaDSpeakerB(CriteriaDSpeakerB);
            scoreSpeakerB = scoreSpeakerB + 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    public void decrementCriteriaDSpeakerB(View view){

        if (CriteriaDSpeakerB > minScore) { // Decrement only if above the limit.
            CriteriaDSpeakerB = CriteriaDSpeakerB - 1;
            displayCriteriaDSpeakerB(CriteriaDSpeakerB);
            scoreSpeakerB = scoreSpeakerB - 1;
            displaySpeakerB(scoreSpeakerB);
        }
    }
    private void displayCriteriaDSpeakerB(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerB_criteria4);
        scoreView.setText(String.valueOf(score));
    }


    // Functions for global score of speaker 1
    public void resetSpeakerB(View view){

        scoreSpeakerB = 0; displaySpeakerB(scoreSpeakerB);
        CriteriaASpeakerB = 0; displayCriteriaASpeakerB(CriteriaASpeakerB);
        CriteriaBSpeakerB = 0; displayCriteriaBSpeakerB(CriteriaBSpeakerB);
        CriteriaCSpeakerB = 0; displayCriteriaCSpeakerB(CriteriaCSpeakerB);
        CriteriaDSpeakerB = 0; displayCriteriaDSpeakerB(CriteriaDSpeakerB);
    }

    private void displaySpeakerB(int score){

        TextView scoreView = (TextView) findViewById(R.id.speakerB_score);
        scoreView.setText(String.valueOf(score));
    }


    ///////////////////////
    // Reset of both speakers
    public void resetAll(View view){
        resetSpeakerA(view);
        resetSpeakerB(view);
    }

}
