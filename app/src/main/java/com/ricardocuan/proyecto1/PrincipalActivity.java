package com.ricardocuan.proyecto1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}