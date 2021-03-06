package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ricardocuan.proyecto1.result.ResultAdapter;
import com.ricardocuan.proyecto1.result.ResultData;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.random;

public class ResultActivity extends AppCompatActivity {

    // Declaración de variables globales
    private Button result_button;
    private ImageView result_back;
    private TextView result_date;
    private TextView result_time;
    private TextView tvTotal;
    private TextView result_code;
    private ListView List_view;
    private String[] data_cantidad = new String[30];
    private String[] data_title = new String[30];
    private String[] data_cost = new String[30];
    private double data_total = 0;
    String date = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
    String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
    int code = (int) ((random()*100000000));
    ArrayList<ResultData> List_item = new ArrayList<ResultData>(30);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        // Inicializar las variables
        result_button = findViewById(R.id.result_button);
        result_back   = findViewById(R.id.result_arrow);
        result_code   = findViewById(R.id.result_code_text);
        result_date   = findViewById(R.id.result_date_text);
        result_time   = findViewById(R.id.result_time_text);
        tvTotal = findViewById(R.id.result_total_text);
        List_view = (ListView)findViewById(R.id.result_list);
        List_item = new ArrayList<ResultData>();


        // Recibir datos de un Intent
        data_cantidad = getIntent().getExtras().getStringArray("data_cantidad");
        data_title = getIntent().getExtras().getStringArray("data_title");
        data_cost = getIntent().getExtras().getStringArray("data_cost");
        data_total = getIntent().getExtras().getDouble("data_total");


        // Total
        tvTotal.setText("B/. " + roundTwoDecimals(data_total));
        result_code.setText(code + "");
        result_date.setText(date + "");
        result_time.setText(time + "");


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

        // LIST
        for (int i = 0; i < 30; i++) {
            if (!data_cantidad[i].equals("") && !data_cantidad[i].equals("0")){
                System.out.println("data title = " + data_title[i]);
                List_item.add(new ResultData(i, Integer.parseInt(data_cantidad[i]), data_title[i], data_cost[i]));
            }
        }

        ResultAdapter miadaptador = new ResultAdapter(getApplicationContext(), List_item);
        List_view.setAdapter(miadaptador);
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
}
