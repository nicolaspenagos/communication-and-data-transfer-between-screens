/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.communication_and_data_transfer_between_screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    private Button blueButton;
    private Button whiteButton;
    private Button blackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_color);

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
}