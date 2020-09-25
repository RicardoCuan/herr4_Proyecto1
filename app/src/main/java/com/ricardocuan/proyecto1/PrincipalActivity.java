package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PrincipalActivity extends AppCompatActivity {

    // Declaración de variables globales
    private ConstraintLayout principal_button;
    private ImageView principal_back;
    private ViewGroup combo_layout;
    private ViewGroup individual_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Inicializar las variables
        principal_button = findViewById(R.id.principal_button_container);
        principal_back = findViewById(R.id.principal_arrow);
        combo_layout = (ViewGroup) findViewById(R.id.combo_list);
        individual_layout = (ViewGroup) findViewById(R.id.individual_list);

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


        // COMBO LIST
        addCombo(1, "Arroz Con Pollo", 5, 2,2.50, 3);
        addCombo(2, "Arroz Con Pollo", 5, 1,3.25, 3);
        addCombo(3, "Arroz Con Pollo", 5, 3,4.25, 3);
        addCombo(4, "Arroz Con Pollo", 5, 1,1.75, 3);

        // INDIVIDUAL LIST
        addIndividual(1, "Arroz Con Pollo", 5, 2,2.50, 3);
        addIndividual(2, "Arroz Con Pollo", 5, 1,3.25, 3);
        addIndividual(3, "Arroz Con Pollo", 5, 3,4.25, 3);
        addIndividual(4, "Arroz Con Pollo", 5, 1,1.75, 3);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void addCombo(int id, String title, int image, int count, double cost, int stars) {
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_combo;

        ConstraintLayout constraintLayout = (ConstraintLayout) inflater.inflate(id_layout, null, false);

        TextView tvcost     = (TextView)constraintLayout.findViewById(R.id.combo_cost);
        TextView tvtitle    = (TextView)constraintLayout.findViewById(R.id.combo_title);
//        ImageView tvimage = (ImageView)constraintLayout.findViewById(R.id.combo_image);
        TextView tvquantity = (TextView)constraintLayout.findViewById(R.id.combo_quantity_text);

        tvcost.setText("B/. " + cost);
        tvquantity.setText("" + count);
        tvtitle.setText(title);

        combo_layout.addView(constraintLayout);
    }

    private void addIndividual(int id, String title, int image, int count, double cost, int stars) {
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_individual;

        ConstraintLayout constraintLayout = (ConstraintLayout) inflater.inflate(id_layout, null, false);

        TextView tvcost     = (TextView)constraintLayout.findViewById(R.id.individual_cost);
        TextView tvtitle    = (TextView)constraintLayout.findViewById(R.id.individual_title);
//        ImageView tvimage = (ImageView)constraintLayout.findViewById(R.id.individual_image);
        TextView tvquantity = (TextView)constraintLayout.findViewById(R.id.individual_quantity_text);

        tvcost.setText("B/. " + cost);
        tvquantity.setText("" + count);
        tvtitle.setText(title);

        individual_layout.addView(constraintLayout);
    }
}
