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
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private ConstraintLayout mainLayout;
    private TextView titleTextView;
    private TextView msgTextView;
    private TextView finalGradeTextView;
    private TextView finalGardeTextView;
    private Button calulateAgainButton;

    // -------------------------------------
    // Gui methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        titleTextView = findViewById(R.id.titleTextView);
        finalGardeTextView = findViewById(R.id.finalGardeTextView);
        mainLayout = findViewById(R.id.mainLayout);
        msgTextView = findViewById(R.id.msgTextView);
        finalGradeTextView = findViewById(R.id.finalGardeTextView);
        calulateAgainButton = findViewById(R.id.calculateAgainButton);

        calulateAgainButton.setOnClickListener(

                (v) -> {

                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);

                }
        );

    }



    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("myLocker", MODE_PRIVATE);
        String[] color =  preferences.getString("colorValue", "NO_COLOR").split(" ");
        String msg = "Hi, " + preferences.getString("username", "No username")+ ". Your final grade is:";

        msgTextView.setText(msg);
        mainLayout.setBackgroundColor(Color.rgb(Integer.parseInt(color[0]),Integer.parseInt(color[2]), Integer.parseInt(color[2])));
        finalGradeTextView.setText(""+preferences.getFloat("averageGrade", 0));
        if(color[0].equals("38"))
            darkMode(true);
        else
            darkMode(false);

    }

    public void darkMode(boolean darkMode){

        if(darkMode){

            msgTextView.setTextColor(Color.rgb(255,255,255));
            titleTextView.setTextColor(Color.rgb(255,255,255));
            finalGardeTextView.setTextColor(Color.rgb(255,255,255));

        }else{

            msgTextView.setTextColor(Color.rgb(0,0,0));
            titleTextView.setTextColor(Color.rgb(0,0,0));
            finalGardeTextView.setTextColor(Color.rgb(0,0,0));

        }

    }

}