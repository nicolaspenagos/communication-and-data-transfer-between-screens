/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.communication_and_data_transfer_between_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private TextView msgTextView;
    private TextView finalGradeTextView;
    private Button calulateAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        msgTextView = findViewById(R.id.msgTextView);
        finalGradeTextView = findViewById(R.id.finalGardeTextView);
        calulateAgainButton = findViewById(R.id.calculateAgainButton);

    }
}