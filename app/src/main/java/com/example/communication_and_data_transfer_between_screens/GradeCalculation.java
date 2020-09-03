/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.communication_and_data_transfer_between_screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class GradeCalculation extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private ConstraintLayout mainLayout;
    private EditText project1EditText;
    private EditText project2EditText;
    private EditText quizzesEditText;
    private EditText exam1EditText;
    private EditText exam2EditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calculation);

        mainLayout = findViewById(R.id.mainLayout);
        project1EditText = findViewById(R.id.project1EditText);
        project2EditText = findViewById(R.id.project2EditText);
        quizzesEditText = findViewById(R.id.quizzesEditText);
        exam1EditText = findViewById(R.id.exam1EditText);
        exam2EditText = findViewById(R.id.exam2EditText);
        calculateButton = findViewById(R.id.calculateButton);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("myLocker", MODE_PRIVATE);
        String[] color =  preferences.getString("colorValue", "NO_COLOR").split(" ");
        mainLayout.setBackgroundColor(Color.rgb(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2])));


    }
}