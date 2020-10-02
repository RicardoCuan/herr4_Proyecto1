package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import org.w3c.dom.Text;

public class PrincipalActivity extends AppCompatActivity {

    // Declaración de variables globales
    private ConstraintLayout principal_button;
    private ImageView principal_back;
    private ViewGroup combo_layout;
    private ViewGroup individual_layout;
    private LinearLayout button_plus;
    private double total = 0;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Inicializar las variables
        principal_button = findViewById(R.id.principal_button_container);
        principal_back = findViewById(R.id.principal_arrow);
        combo_layout = (ViewGroup) findViewById(R.id.combo_list);
        individual_layout = (ViewGroup) findViewById(R.id.individual_list);
        button_plus = findViewById(R.id.individual_layout_border);
        tvTotal = findViewById(R.id.principal_result);


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
        addCombo(1, "Arroz, arveja salchicha y ensalada básica", 5, 0.85, 3);
        addCombo(2, "Arroz, lenteja, pollo asado y ensalada de pepino", 5, 1.25, 3);
        addCombo(3, "Arroz poroto, pollo guisado", 5, 1.45, 3);


        // ARROZ LIST
        addTitle(1, "Arroz 🍚");
        addIndividual(1, "Arroz Blanco",2.50, 3);
        addIndividual(2, "Arroz Naranja",3.25, 3);
        addIndividual(3, "Arroz con lenteja",4.25, 3);
        addIndividual(4, "Arroz con colón",1.75, 3);
        addIndividual(5, "Arroz con pollo",1.75, 3);

        // MINESTRA LIST
        addTitle(1, "Minestra 🍛");
        addIndividual(1, "Lenteja",2.50, 3);
        addIndividual(2, "Poroto",3.25, 3);
        addIndividual(3, "Frijoles",4.25, 3);
        addIndividual(4, "Arvejas",1.75, 3);

        // PASTA LIST
        addTitle(1, "Pasta 🍜");
        addIndividual(1, "Spaguetti",2.50, 3);
        addIndividual(2, "Spaguetti con salsa",3.25, 3);

        // EMBUTIDO LIST
        addTitle(1, "Embutidos 🥓");
        addIndividual(1, "Salchicha guisada",2.50, 3);
        addIndividual(2, "Milanesa",3.25, 3);
        addIndividual(3, "Nuggets",4.25, 3);
        addIndividual(4, "Jamonilla frita",1.75, 3);
        addIndividual(5, "Jamonilla guisada",1.75, 3);

        // POLLOS LIST
        addTitle(1, "Pollos 🍗");
        addIndividual(1, "Pollo Frito",2.50, 3);
        addIndividual(2, "Pollo Asado",3.25, 3);
        addIndividual(3, "Pollo Guisado",4.25, 3);
        
        // ENSALADA LIST
        addTitle(1, "Ensalada 🥗");
        addIndividual(1, "Ensalada básica",2.50, 3);
        addIndividual(2, "Coditos con tuna",3.25, 3);
        addIndividual(3, "Ensalada de Lechuga y tomate",4.25, 3);
        addIndividual(4, "Ensalada de papa",1.75, 3);
        addIndividual(5, "Ensalada de pepino",1.75, 3);
        addIndividual(6, "Ensalada papa roja",1.75, 3);

        // BEBIDAS LIST
        addTitle(1, "Bebidas 🥤");
        addIndividual(1, "Chicha de Fruta",2.50, 3);
        addIndividual(2, "Chicha de Piña",3.25, 3);
        addIndividual(3, "Chicha de Naranja",4.25, 3);

        // POSTRES LIST
        addTitle(1, "Postres 🍦");
        addIndividual(1, "Gelatina",2.50, 3);
        addIndividual(2, "Flan",3.25, 3);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void addTitle(int id, String title){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_title;

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(id_layout, null, false);

        TextView tvTitle = (TextView)linearLayout.findViewById(R.id.title_title);
        tvTitle.setText(title);

        individual_layout.addView(linearLayout);
    }

    private void addCombo(int id, String title, int image, final double cost, int stars) {
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_combo;

        LinearLayout constraintLayout = (LinearLayout) inflater.inflate(id_layout, null, false);

        TextView tvcost     = (TextView)constraintLayout.findViewById(R.id.combo_cost);
        TextView tvtitle    = (TextView)constraintLayout.findViewById(R.id.combo_title);
//        ImageView tvimage = (ImageView)constraintLayout.findViewById(R.id.combo_image);
        final TextView tvquantity = (TextView)constraintLayout.findViewById(R.id.combo_quantity);
        final LinearLayout minus_button = (LinearLayout)constraintLayout.findViewById(R.id.combo_minus);
        final LinearLayout plus_button  = (LinearLayout)constraintLayout.findViewById(R.id.combo_container);

        tvcost.setText("B/. " + cost);
        tvquantity.setText("");
        tvtitle.setText(title);


        plus_button.setBackgroundResource(R.color.colorLight);
        minus_button.setVisibility(View.GONE);
        tvquantity.setVisibility(View.GONE);

        final int[] cantidad = {0};

        plus_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantidad[0] == 0) {
                    plus_button.setBackgroundResource(R.drawable.rounded_button_small);
                    minus_button.setVisibility(View.VISIBLE);
                    tvquantity.setVisibility(View.VISIBLE);
                }
                total = total - cantidad[0] * cost;
                System.out.println("cantidad: " + cantidad[0]);
                cantidad[0]++;
                total = total + cantidad[0] * cost;
                tvTotal.setText("B/. " + total);

                tvquantity.setText("x" + cantidad[0]);
            }
        }));

        minus_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = total - cantidad[0] * cost;
                cantidad[0]--;
                if (cantidad[0] == 0) {
                    plus_button.setBackgroundResource(R.color.colorLight);
                    minus_button.setVisibility(View.GONE);
                    tvquantity.setVisibility(View.GONE);
                }

                total = total + cantidad[0] * cost;
                tvquantity.setText("x" + cantidad[0]);
                tvTotal.setText("B/. " + total);
            }
        }));

        combo_layout.addView(constraintLayout);
    }

    private void addIndividual(int id, String title, final double cost, int stars) {
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_individual;

        final LinearLayout linearLayout = (LinearLayout) inflater.inflate(id_layout, null, false);

        TextView tvcost     = (TextView)linearLayout.findViewById(R.id.individual_cost);
        TextView tvtitle    = (TextView)linearLayout.findViewById(R.id.individual_title);
        final TextView tvquantity       = (TextView)linearLayout.findViewById(R.id.individual_quantity);
        final LinearLayout minus_button = (LinearLayout)linearLayout.findViewById(R.id.individual_minus);
        final LinearLayout plus_button  = (LinearLayout)linearLayout.findViewById(R.id.individual_layout_border);


        tvcost.setText("B/. " + cost);
        tvquantity.setText("");
        tvtitle.setText(title);


        plus_button.setBackgroundResource(R.color.colorLight);
        minus_button.setVisibility(View.GONE);
        tvquantity.setVisibility(View.GONE);

        final int[] cantidad = {0};

        plus_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantidad[0] == 0) {
                    plus_button.setBackgroundResource(R.drawable.rounded_button_small);
                    minus_button.setVisibility(View.VISIBLE);
                    tvquantity.setVisibility(View.VISIBLE);
                }
                total = total - cantidad[0] * cost;
                System.out.println("cantidad: " + cantidad[0]);
                cantidad[0]++;
                total = total + cantidad[0] * cost;
                tvTotal.setText("B/. " + total);

                tvquantity.setText("x" + cantidad[0]);
            }
        }));

        minus_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total = total - cantidad[0] * cost;
                cantidad[0]--;
                if (cantidad[0] == 0) {
                    plus_button.setBackgroundResource(R.color.colorLight);
                    minus_button.setVisibility(View.GONE);
                    tvquantity.setVisibility(View.GONE);
                }

                total = total + cantidad[0] * cost;
                tvquantity.setText("x" + cantidad[0]);
                tvTotal.setText("B/. " + total);
            }
        }));

        individual_layout.addView(linearLayout);
    }
}
