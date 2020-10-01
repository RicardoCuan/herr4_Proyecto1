package com.ricardocuan.proyecto1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IndividualFragment extends AppCompatActivity {

    private LinearLayout button_plus;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_individual);

        button_plus = findViewById(R.id.individual_layout_border);

        button_plus.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_plus.setBackgroundResource(R.drawable.rounded_button_small);
            }
        }));
    }

    public void onclick_individual_plus(View v) {
        button_plus.setBackgroundResource(R.drawable.rounded_button_small);
    }


}
