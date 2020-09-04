/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.communication_and_data_transfer_between_screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GradeCalculation extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private ConstraintLayout mainLayout;
    private TextView titleTextView;
    private EditText project1EditText;
    private EditText project2EditText;
    private EditText quizzesEditText;
    private EditText exam1EditText;
    private EditText exam2EditText;
    private EditText semEEditText;
    private Button calculateButton;

    private double currentGrade;

    // -------------------------------------
    // Gui methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calculation);

        mainLayout = findViewById(R.id.mainLayout);
        titleTextView = findViewById(R.id.titleTextView);
        project1EditText = findViewById(R.id.project1EditText);
        project2EditText = findViewById(R.id.project2EditText);
        quizzesEditText = findViewById(R.id.quizzesEditText);
        exam1EditText = findViewById(R.id.exam1EditText);
        exam2EditText = findViewById(R.id.exam2EditText);
        semEEditText = findViewById(R.id.semEEditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(
                (view) -> {

                    if(validateGrades()){

                        SharedPreferences preferences = getSharedPreferences("myLocker", MODE_PRIVATE);
                        preferences.edit().putFloat("averageGrade", (float)currentGrade).apply();

                        Intent i = new Intent(this, ResultActivity.class);
                        startActivity(i);
                        finish();
                    }

                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("myLocker", MODE_PRIVATE);
        String[] color =  preferences.getString("colorValue", "NO_COLOR").split(" ");
        mainLayout.setBackgroundColor(Color.rgb(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])));
        if(color[0].equals("38"))
            darkMode(true);
        else
            darkMode(false);

    }

    // -------------------------------------
    // Gui methods
    // -------------------------------------
    public boolean validateGrades(){

        try {

            double p1 = Double.parseDouble(project1EditText.getText().toString());
            double p2 = Double.parseDouble(project2EditText.getText().toString());
            double q = Double.parseDouble(quizzesEditText.getText().toString());
            double e1 = Double.parseDouble(exam1EditText.getText().toString());
            double e2 = Double.parseDouble(exam2EditText.getText().toString());
            double se = Double.parseDouble(semEEditText.getText().toString());

            currentGrade = calculateGrade(p1, p2, q, se, e1, e2);

        } catch (NumberFormatException e){

            Toast.makeText(this, "All fields must be numbers. Use '.' for the decimal part", Toast.LENGTH_SHORT).show();
            project1EditText.setText("");
            project2EditText.setText("");
            quizzesEditText.setText("");
            exam1EditText.setText("");
            exam2EditText.setText("");
            semEEditText.setText("");

            return false;
        }

        return true;

    }

    public void darkMode(boolean darkMode){

        if(darkMode) {

            project1EditText.setTextColor(Color.rgb(255,255,255));
            project2EditText.setTextColor(Color.rgb(255,255,255));
            quizzesEditText.setTextColor(Color.rgb(255,255,255));
            exam2EditText.setTextColor(Color.rgb(255,255,255));
            exam1EditText.setTextColor(Color.rgb(255,255,255));
            semEEditText.setTextColor(Color.rgb(255,255,255));
            titleTextView.setTextColor(Color.rgb(255,255,255));

            project1EditText.setHintTextColor(Color.rgb(180,180,180));
            project2EditText.setHintTextColor(Color.rgb(180,180,180));
            quizzesEditText.setHintTextColor(Color.rgb(180,180,180));
            exam2EditText.setHintTextColor(Color.rgb(180,180,180));
            exam1EditText.setHintTextColor(Color.rgb(180,180,180));
            semEEditText.setHintTextColor(Color.rgb(180,180,180));

        }else{

            project1EditText.setTextColor(Color.rgb(0,0,0));
            project2EditText.setTextColor(Color.rgb(0,0,0));
            quizzesEditText.setTextColor(Color.rgb(0,0,0));
            exam2EditText.setTextColor(Color.rgb(0,0,0));
            exam1EditText.setTextColor(Color.rgb(0,0,0));
            semEEditText.setTextColor(Color.rgb(0,0,0));
            titleTextView.setTextColor(Color.rgb(0,0,0));

            project1EditText.setHintTextColor(Color.rgb(120,120,120));
            project2EditText.setHintTextColor(Color.rgb(120,120,120));
            quizzesEditText.setHintTextColor(Color.rgb(120,120,120));
            exam2EditText.setHintTextColor(Color.rgb(120,120,120));
            exam1EditText.setHintTextColor(Color.rgb(120,120,120));
            semEEditText.setHintTextColor(Color.rgb(120,120,120));

        }

    }

    // -------------------------------------
    // Logic methods
    // -------------------------------------
    public double calculateGrade(double p1, double p2, double q, double se,double e1, double e2) {
         return (p1*0.25 + p2*0.25 + q*0.15 + se*0.05 + e1*0.15 + e2*0.15);
    }

}