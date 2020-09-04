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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ColorSettings extends AppCompatActivity implements View.OnClickListener{

    // -------------------------------------
    // Color Constants
    // -------------------------------------
    public final static char BLUE = 'B';
    public final static char WHITE = 'W';
    public final static char BLACK ='K';

    // -------------------------------------
    // XML references
    // -------------------------------------
    private ConstraintLayout mainLayout;
    private TextView titleTextView;
    private TextView infoTextView;
    private Button blueButton;
    private Button whiteButton;
    private Button blackButton;

    // -------------------------------------
    // Gui methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_color);

        mainLayout = findViewById(R.id.mainLayout);
        titleTextView = findViewById(R.id.titleTextView);
        infoTextView = findViewById(R.id.infoTextView);
        blueButton = findViewById(R.id.blueButton);
        whiteButton = findViewById(R.id.whiteButton);
        blackButton = findViewById(R.id.blackButton);

        blueButton.setOnClickListener(this);
        whiteButton.setOnClickListener(this);
        blackButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent();

        switch (view.getId()){

            case R.id.blueButton:

                i.putExtra("color", BLUE);
                setResult(RESULT_OK, i);

                break;

            case R.id.whiteButton:

                i.putExtra("color", WHITE);
                setResult(RESULT_OK, i);

                break;

            case R.id.blackButton:

                i.putExtra("color", BLACK);
                setResult(RESULT_OK, i);
                break;

        }
        finish();
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

    public void darkMode(boolean darkMode){

        if(darkMode){

            titleTextView.setTextColor(Color.rgb(255,255,255));
            infoTextView.setTextColor(Color.rgb(255,255,255));

        }else{

            titleTextView.setTextColor(Color.rgb(0,0,0));
            infoTextView.setTextColor(Color.rgb(0,0,0));

        }

    }

}