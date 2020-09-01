/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.communication_and_data_transfer_between_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class GradeCalculation extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
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

        project1EditText = findViewById(R.id.project1EditText);
        project2EditText = findViewById(R.id.project2EditText);
        quizzesEditText = findViewById(R.id.quizzesEditText);
        exam1EditText = findViewById(R.id.exam1EditText);
        exam2EditText = findViewById(R.id.exam2EditText);
        calculateButton = findViewById(R.id.calculateButton);

    }
}