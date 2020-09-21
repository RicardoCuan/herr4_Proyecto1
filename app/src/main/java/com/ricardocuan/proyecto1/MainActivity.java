package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Declaración de variables
    private Button main_button;
    private TextView main_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las variables
        main_button = findViewById(R.id.main_button);
        main_about = findViewById(R.id.main_about);

        // On Click
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_activity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login_activity);
            }
        });

        main_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent presentation_activity = new Intent(MainActivity.this, PresentationActivity.class);
                startActivity(presentation_activity);
            }
        });
    }
}
