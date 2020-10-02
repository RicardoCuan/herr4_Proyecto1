package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Declaración de variables globales
    private Button login_button;
    private ImageView login_back;
    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            username = findViewById(R.id.login_user);
            password = findViewById(R.id.login_password);
            login_button = findViewById(R.id.login_button);
            login_back = findViewById(R.id.login_arrow);
            username.addTextChangedListener(loginTextWatcher);
            password.addTextChangedListener(loginTextWatcher);

        // Inicializar las variables


        // Button ON CLICK
        // Principal Button

            login_button.setOnClickListener(new View.OnClickListener() {


                public void onClick(View view) {
                    Intent principal_activity = new Intent(LoginActivity.this, PrincipalActivity.class);
                    startActivity(principal_activity);
                    checkUsername();

                }
            });

            // Back Button
            login_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent main_activity = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main_activity);

                }
            });

    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = username.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();
            login_button.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    protected void checkUsername() {
        boolean isValid = true;

        if(isEmpty(username)){
            username.setError("Ingresa un nombre de usuario");
            isValid = false;
        }
        if (isEmpty(password)){
            password.setError("Contrasena incorrecta");
            isValid = false;
        }else {
            if(password.getText().toString().length() < 4){
                password.setError("Contrasena muy larga, maximo 4 caracteres");
                isValid = false;
            }
        }

        if (isValid){
            String usernameValue = username.getText().toString();
            String passwordValue = username.getText().toString();
            if (usernameValue.equals("a") && passwordValue.equals("")){
                Intent i = new Intent(LoginActivity.this, PrincipalActivity.class);
                startActivity(i);
                this.finish();

            }else {
                Toast t = Toast.makeText(this,  "Usuario o contrasena incorrectos", Toast.LENGTH_SHORT);
                t.show();
            }

        }


    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}
