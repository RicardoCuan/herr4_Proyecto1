package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PresentationActivity extends AppCompatActivity {

    private Button presentation_button;
    private ImageView presentation_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        // Inicializar las variables
        presentation_button = findViewById(R.id.presentation_button);
        presentation_back = findViewById(R.id.presentation_arrow);

        // On Click
        presentation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity = new Intent(PresentationActivity.this, MainActivity.class);
                startActivity(main_activity);

            }
        });

        presentation_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity = new Intent(PresentationActivity.this, MainActivity.class);
                startActivity(main_activity);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
