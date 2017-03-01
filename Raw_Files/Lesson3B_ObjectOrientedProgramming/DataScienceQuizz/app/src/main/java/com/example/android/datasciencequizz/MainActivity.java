package com.example.android.datasciencequizz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // The alternative roles in data science considered in this quizz are 3.
    // Each of these variables represents a different role and it will contain
    // a score calculated according to the answers given by the user.
    private int dataScientist;
    private int dataEngineer;
    private int statistician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Question: What tools do you use frequently?
    private void calculateAnswer2(){

        CheckBox checkbox;

        // R -- if checked, add to statistician and dataScientist
        checkbox = (CheckBox) findViewById(R.id.question2_answer1);
        if(checkbox.isChecked()){ statistician++; dataScientist++; }

        // Python -- if checked, add to dataEngineer and dataScientist
        checkbox = (CheckBox) findViewById(R.id.question2_answer2);
        if(checkbox.isChecked()){ dataEngineer++; dataScientist++; }

        // Matlab -- if checked, add to statistician
        checkbox = (CheckBox) findViewById(R.id.question2_answer3);
        if(checkbox.isChecked()){ statistician++; }

        // Spark -- if checked, add to dataEngineer and dataScientist
        checkbox = (CheckBox) findViewById(R.id.question2_answer4);
        if(checkbox.isChecked()){ dataEngineer++; dataScientist++; }

        // SQL -- if checked, add to dataEngineer
        checkbox = (CheckBox) findViewById(R.id.question2_answer5);
        if(checkbox.isChecked()){ dataEngineer++; }

        // JS -- if checked, add to dataEngineer
        checkbox = (CheckBox) findViewById(R.id.question2_answer6);
        if(checkbox.isChecked()){ dataEngineer++; }
    }

    // Question: What are your strongest skills?
    private void calculateAnswer3(){

        CheckBox checkbox;

        // Maths and Stats -- if checked, add to statistician and dataScientist
        checkbox = (CheckBox) findViewById(R.id.question3_answer1);
        if(checkbox.isChecked()){ statistician++; dataScientist++; }

        // Programming -- if checked, add to dataEngineer and dataScientist
        checkbox = (CheckBox) findViewById(R.id.question3_answer2);
        if(checkbox.isChecked()){ dataEngineer++; dataScientist++; }

        // Machine Learning -- if checked, add to dataScientist
        checkbox = (CheckBox) findViewById(R.id.question3_answer3);
        if(checkbox.isChecked()){ dataScientist++; }
    }

    // Question: How do you use Excel?
    private void calculateAnswer4(){

        RadioButton radiobutton;

        // Only to extract data -- if checked, add to dataScientist and dataEngineer
        radiobutton = (RadioButton) findViewById(R.id.question4_answer1);
        if(radiobutton.isChecked()) { dataEngineer++; dataScientist++; }

        // To input data and for analyzing data -- if checked, add to statistician
        radiobutton = (RadioButton) findViewById(R.id.question4_answer2);
        if(radiobutton.isChecked()) {statistician++; }

    }

    // Question: Can you code without looking at the keyboard?
    private void calculateAnswer5(){

        RadioButton radiobutton;

        // If can code without looking, add to dataEngineer
        radiobutton = (RadioButton) findViewById(R.id.question5_answer1);
        if(radiobutton.isChecked()) { dataEngineer++; }

        // If cannot code without looking, add to statistician
        radiobutton = (RadioButton) findViewById(R.id.question5_answer2);
        if(radiobutton.isChecked()) {statistician++; }
    }

    public void calculateRole(View view){

        // The name of the person answering the quizz
        EditText NameText = (EditText) findViewById(R.id.question1);
        String userName = NameText.getText().toString();
        String message = "Hi, " + userName + "! ";

        // Calculate scores:
        // 1) reset scores for each data science role.
        // 2) update scores according the each answer.
        dataScientist = 0;
        dataEngineer = 0;
        statistician = 0;

        calculateAnswer2();
        calculateAnswer3();
        calculateAnswer4();
        calculateAnswer5();

        // Check highest score:
        int maxScore = Math.max(dataEngineer, Math.max(dataScientist,statistician));

        // If dataEngineer is the most voted:
        if(dataEngineer == maxScore){
            Toast.makeText(this, message + getString(R.string.resultDataEngineer), Toast.LENGTH_SHORT).show();
        }
        // If dataScientist is the most voted:
        else if(dataScientist == maxScore){
            Toast.makeText(this, message + getString(R.string.resultDataScientist), Toast.LENGTH_SHORT).show();
        }
        // If statistician is the most voted:
        else if(statistician == maxScore){
            Toast.makeText(this, message + getString(R.string.resultStatistician), Toast.LENGTH_SHORT).show();
        }
    }

    // Reset username
    private void resetName(View view){
        EditText NameText = (EditText) findViewById(R.id.question1);
        NameText.setText(" ");
    }

    // Reset answers to question 2
    private void resetQuestion2(View view){

        CheckBox checkbox;
        checkbox = (CheckBox) findViewById(R.id.question2_answer1); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question2_answer2); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question2_answer3); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question2_answer4); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question2_answer5); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question2_answer6); checkbox.setChecked(false);
    }

    // Reset answers to question 3
    private void resetQuestion3(View view){

        CheckBox checkbox;
        checkbox = (CheckBox) findViewById(R.id.question3_answer1); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question3_answer2); checkbox.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.question3_answer3); checkbox.setChecked(false);
    }

    // Reset answers to question 4
    private void resetQuestion4(View view){

        RadioGroup radiogroup;
        radiogroup = (RadioGroup) findViewById(R.id.question4_radioGroup);
        radiogroup.clearCheck();
    }

    // Reset answers to question 5
    private void resetQuestion5(View view){

        RadioGroup radiogroup;
        radiogroup = (RadioGroup) findViewById(R.id.question5_radioGroup);
        radiogroup.clearCheck();
    }

    // Resets user name and questions
    public void reset(View view){

        resetName(view);
        resetQuestion2(view);
        resetQuestion3(view);
        resetQuestion4(view);
        resetQuestion5(view);
    }
}
