package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ricardocuan.proyecto1.result.ResultData;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PrincipalActivity extends AppCompatActivity {

    // Declaración de variables globales
    private ConstraintLayout principal_button;
    private ImageView principal_back;
    private ViewGroup combo_layout;
    private ViewGroup individual_layout;
    private LinearLayout button_plus;
    private double total = 0;
    private TextView tvTotal;
    private String[] data_cantidad = new String[50];
    private String[] data_title = new String[50];
    private String[] data_cost = new String[50];

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

        for (int i = 0; i < 30; i++) {
            data_cantidad[i] = "";
            data_title[i] = "";
            data_cost[i] = "";
        }

        // On Click
        principal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent principal_activity = new Intent(PrincipalActivity.this, ResultActivity.class);
                principal_activity.putExtra("data_cantidad", data_cantidad);
                principal_activity.putExtra("data_title", data_title);
                principal_activity.putExtra("data_cost", data_cost);
                principal_activity.putExtra("data_total", total);
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
        addCombo(1, "Arroz, arveja salchicha y ensalada básica", R.drawable.combo_1, 0.85, 3);
        addCombo(2, "Arroz, lenteja, pollo asado y ensalada de pepino", 5, 1.25, 3);
        addCombo(3, "Arroz poroto, pollo guisado", 5, 1.45, 3);

        // ARROZ LIST
        addTitle(1, "Arroz 🍚");
        addIndividual(1, "Arroz Blanco",0.10, 4);
        addIndividual(2, "Arroz Naranja",0.20, 3);
        addIndividual(3, "Arroz con lenteja",0.20, 3);
        addIndividual(4, "Arroz con colón",0.10, 1);
        addIndividual(5, "Arroz con pollo",0.70, 5);

        // MINESTRA LIST
        addTitle(1, "Minestra 🍛");
        addIndividual(6, "Lenteja",0.25, 4);
        addIndividual(7, "Poroto",0.25, 3);
        addIndividual(8, "Frijoles",0.25, 3);
        addIndividual(9, "Arvejas",0.25, 2);

        // PASTA LIST
        addTitle(1, "Pasta 🍜");
        addIndividual(10, "Spaguetti",0.70, 4);
        addIndividual(11, "Spaguetti con salsa",0.70, 5);

        // EMBUTIDO LIST
        addTitle(1, "Embutidos 🥓");
        addIndividual(12, "Salchicha guisada",0.25, 2);
        addIndividual(13, "Milanesa",0.30, 1);
        addIndividual(14, "Nuggets",0.70, 2);
        addIndividual(15, "Jamonilla frita",0.25, 1);
        addIndividual(16, "Jamonilla guisada",0.70, 2);

        // POLLOS LIST
        addTitle(1, "Pollos 🍗");
        addIndividual(17, "Pollo Frito",0.80, 4);
        addIndividual(18, "Pollo Asado",0.80, 5);
        addIndividual(19, "Pollo Guisado",0.80, 4);
        
        // ENSALADA LIST
        addTitle(1, "Ensalada 🥗");
        addIndividual(20, "Ensalada básica",0.20, 2);
        addIndividual(21, "Coditos con tuna",0.70, 5);
        addIndividual(22, "Ensalada de Lechuga y tomate",0.30, 3);
        addIndividual(23, "Ensalada de papa",0.40, 4);
        addIndividual(24, "Ensalada de pepino",0.40, 3);
        addIndividual(25, "Ensalada papa roja",0.60, 4);

        // BEBIDAS LIST
        addTitle(1, "Bebidas 🥤");
        addIndividual(26, "Chicha de Fruta",0.25, 2);
        addIndividual(27, "Chicha de Piña",0.25, 2);
        addIndividual(28, "Chicha de Naranja",0.25, 2);

        // POSTRES LIST
        addTitle(1, "Postres 🍦");
        addIndividual(29, "Gelatina",0.70, 4);
        addIndividual(30, "Flan",0.70, 4);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

    private void addTitle(int id, String title){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_title;

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(id_layout, null, false);

        TextView tvTitle = (TextView)linearLayout.findViewById(R.id.title_title);
        tvTitle.setText(title);

        individual_layout.addView(linearLayout);
    }

    private void addCombo(final int id, final String title, final int image, final double cost, final int stars) {
        // Inflar el item_combo en el ScrollView
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_combo;

        LinearLayout constraintLayout = (LinearLayout) inflater.inflate(id_layout, null, false);

        // Declaración e inicialización de variables
        RatingBar star      = (RatingBar)constraintLayout.findViewById(R.id.individual_stars);
        TextView tvcost     = (TextView)constraintLayout.findViewById(R.id.combo_cost);
        TextView tvtitle    = (TextView)constraintLayout.findViewById(R.id.combo_title);
        ImageView tvimage   = (ImageView)constraintLayout.findViewById(R.id.combo_image);
        final TextView tvquantity       = (TextView)constraintLayout.findViewById(R.id.combo_quantity);
        final LinearLayout plus_button  = (LinearLayout)constraintLayout.findViewById(R.id.combo_container);
        final LinearLayout minus_button = (LinearLayout)constraintLayout.findViewById(R.id.combo_minus);
        final int[] cantidad = {0};

        // Asignación
        tvcost.setText("B/. " + cost);
        tvquantity.setText("");
        tvtitle.setText(title);
        tvimage.setImageResource(R.drawable.combo_1);
        star.setRating(stars);

        // Estilos por default
        plus_button.setBackgroundResource(R.color.colorLight);
        minus_button.setVisibility(View.GONE);
        tvquantity.setVisibility(View.GONE);

        // OnClick - PLUS
        plus_button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantidad[0] == 0) {
                    // Estilo cuando está seleccionado
                    plus_button.setBackgroundResource(R.drawable.rounded_button_small);
                    minus_button.setVisibility(View.VISIBLE);
                    tvquantity.setVisibility(View.VISIBLE);
                }
                total = total - cantidad[0] * cost;
                System.out.println("cantidad: " + cantidad[0]);
                cantidad[0]++;
                total = total + cantidad[0] * cost;
                tvTotal.setText("B/. " + roundTwoDecimals(total));

                tvquantity.setText("x" + cantidad[0]);

                data_cantidad[id] = cantidad[0]+"";
                data_title[id] = title;
                data_cost[id] = cost+"";
            }
        }));

        // OnClick - MINUS
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
                tvTotal.setText("B/. " + roundTwoDecimals(total));

                data_cantidad[id] = cantidad[0]+"";
                data_title[id] = title;
                data_cost[id] = cost+"";
            }
        }));

        combo_layout.addView(constraintLayout);
    }

    private void addIndividual(final int id, final String title, final double cost, int stars) {

        // Inflar el scrollview con el item_individual.xml
        LayoutInflater inflater = LayoutInflater.from(this);
        int id_layout = R.layout.item_individual;

        final LinearLayout linearLayout = (LinearLayout) inflater.inflate(id_layout, null, false);

        TextView tvcost     = (TextView)linearLayout.findViewById(R.id.individual_cost);
        TextView tvtitle    = (TextView)linearLayout.findViewById(R.id.individual_title);
        RatingBar star = (RatingBar)linearLayout.findViewById(R.id.individual_stars);
        final TextView tvquantity       = (TextView)linearLayout.findViewById(R.id.individual_quantity);
        final LinearLayout minus_button = (LinearLayout)linearLayout.findViewById(R.id.individual_minus);
        final LinearLayout plus_button  = (LinearLayout)linearLayout.findViewById(R.id.individual_layout_border);


        tvcost.setText("B/. " + cost);
        tvquantity.setText("");
        tvtitle.setText(title);
        star.setRating(stars);

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
                tvTotal.setText("B/. " + roundTwoDecimals(total));

                tvquantity.setText("x" + cantidad[0]);

                data_cantidad[id] = cantidad[0]+"";
                data_title[id] = title;
                data_cost[id] = cost+"";
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
                tvTotal.setText("B/. " + roundTwoDecimals(total));

                data_cantidad[id] = cantidad[0]+"";
                data_title[id] = title;
                data_cost[id] = cost+"";
            }
        }));

        individual_layout.addView(linearLayout);
    }
}
