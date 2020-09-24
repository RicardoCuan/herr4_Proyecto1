package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ResultActivity extends AppCompatActivity {

    // Declaración de variables globales
    private Button result_button;
    private ImageView result_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Inicializar las variables
        result_button = findViewById(R.id.result_button);
        result_back = findViewById(R.id.result_arrow);

        // On Click
        result_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent principal_activity = new Intent(ResultActivity.this, PrincipalActivity.class);
                startActivity(principal_activity);

            }
        });

        result_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity = new Intent(ResultActivity.this, PrincipalActivity.class);
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
