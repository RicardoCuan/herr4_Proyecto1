package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PrincipalActivity extends AppCompatActivity {

    // Declaración de variables globales
    private ConstraintLayout principal_button;
    private ImageView principal_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Inicializar las variables
        principal_button = findViewById(R.id.principal_button_container);
        principal_back = findViewById(R.id.principal_arrow);

        // On Click
        principal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent principal_activity = new Intent(PrincipalActivity.this, ResultActivity.class);
                startActivity(principal_activity);

            }
        });

        principal_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity = new Intent(PrincipalActivity.this, LoginActivity.class);
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
