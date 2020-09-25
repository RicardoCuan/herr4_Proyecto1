package com.ricardocuan.proyecto1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ricardocuan.proyecto1.result.ResultAdapter;
import com.ricardocuan.proyecto1.result.ResultData;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    // Declaración de variables globales
    private Button result_button;
    private ImageView result_back;
    private ListView List_view;
    ArrayList<ResultData> List_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Inicializar las variables
        result_button = findViewById(R.id.result_button);
        result_back = findViewById(R.id.result_arrow);
        List_view = (ListView)findViewById(R.id.result_list);
        List_item = new ArrayList<ResultData>();

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
        List_item.add(new ResultData(1, 2, "Arroz blanco", "B/. 0.10"));
        List_item.add(new ResultData(2, 1, "Ensalada de papas", "B/. 0.50"));
        List_item.add(new ResultData(3, 1, "Pollo guisado", "B/. 0.80"));
        List_item.add(new ResultData(4, 1, "Chicha de naranja", "B/. 0.25"));

        ResultAdapter miadaptador = new ResultAdapter(getApplicationContext(), List_item);
        List_view.setAdapter(miadaptador);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
