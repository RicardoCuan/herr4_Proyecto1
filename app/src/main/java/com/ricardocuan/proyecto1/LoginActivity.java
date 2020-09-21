package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Declaración de variables globales
    private Button login_button;
    private ImageView login_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar las variables
        login_button = findViewById(R.id.login_button);
        login_back = findViewById(R.id.login_arrow);

        // On Click
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent principal_activity = new Intent(LoginActivity.this, PrincipalActivity.class);
                startActivity(principal_activity);

            }
        });

        login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(main_activity);

            }
        });
    }

}
