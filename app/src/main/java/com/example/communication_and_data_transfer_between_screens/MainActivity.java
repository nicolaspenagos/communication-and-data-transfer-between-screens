/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @author Nicolás Penagos Montoya
 * nicolas.penagosm98@gmail.com
 **~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package com.example.communication_and_data_transfer_between_screens;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // -------------------------------------
    // XML references
    // -------------------------------------
    private ConstraintLayout mainLayout;
    private Button settingsButton;
    private TextView nameTextView;
    private EditText nameEditText;
    private Button nextButton;

    // -------------------------------------
    // Gui methods
    // -------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        settingsButton = findViewById(R.id.settingsButton);
        nameTextView = findViewById(R.id.nameTextView);
        nameEditText = findViewById(R.id.nameEditText);
        nextButton = findViewById(R.id.nextButton);

        settingsButton.setOnClickListener(

                (view)->{

                    Intent i = new Intent(this, ColorSettings.class);
                    startActivityForResult(i, 101);

                }
        );

        nextButton.setOnClickListener(

                (view)->{

                    SharedPreferences preferences = getSharedPreferences("myLocker", MODE_PRIVATE);
                    preferences.edit().putString("username", String.valueOf(nameEditText.getText())).apply();

                    Intent i = new Intent(this, GradeCalculation.class);
                    startActivity(i);

                }

        );

        darkMode(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101 && resultCode == RESULT_OK){

            char color = data.getExtras().getChar("color");

            SharedPreferences preferences = getSharedPreferences("myLocker", MODE_PRIVATE);
            preferences.edit().putString("username", String.valueOf(nameEditText.getText())).apply();

            switch (color) {

                case ColorSettings.BLUE:

                    mainLayout.setBackgroundColor(Color.rgb(142, 211, 233));
                    preferences.edit().putString("colorValue", "142 211 233").apply();
                    darkMode(false);
                    break;

                case ColorSettings.WHITE:

                    mainLayout.setBackgroundColor(Color.rgb(255, 255, 255));
                    preferences.edit().putString("colorValue", "255 255 255").apply();
                    darkMode(false);
                    break;

                case ColorSettings.BLACK:

                    mainLayout.setBackgroundColor(Color.rgb(38, 38, 38));
                    preferences.edit().putString("colorValue", "38 38 38").apply();
                    darkMode(true);
                    break;
            }

        }

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

            nameTextView.setTextColor(Color.rgb(255,255,255));
            nameEditText.setTextColor(Color.rgb(255,255,255));
            nameEditText.setHintTextColor(Color.rgb(180,180,180));

        }else{

            nameTextView.setTextColor(Color.rgb(0,0,0));
            nameEditText.setTextColor(Color.rgb(0,0,0));
            nameEditText.setHintTextColor(Color.rgb(120,120,120));

        }

    }

}