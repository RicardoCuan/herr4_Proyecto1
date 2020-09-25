package com.ricardocuan.proyecto1.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ricardocuan.proyecto1.R;

import java.util.List;

public class ResultAdapter extends BaseAdapter {

    // DECLARACIÓN DE VARIABLES
    Context context;
    List<ResultData> ListObject;

    // CONSTRUCTOR
    public ResultAdapter(Context context, List<ResultData> listObject) {
        this.context = context;
        ListObject = listObject;
    }

    public int getCount() {
        return ListObject.size();
    }

    @Override
    public Object getItem(int position) {
        return ListObject.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(context);
        vista= inflate.inflate(R.layout.item_result, null);

        TextView quantity = (TextView)vista.findViewById(R.id.item_result_quantity);
        TextView titulo   = (TextView)vista.findViewById(R.id.item_result_title);
        TextView cost     = (TextView)vista.findViewById(R.id.item_result_cost);

        quantity.setText("x"+ListObject.get(position).getQuantity());
        titulo.setText(ListObject.get(position).getTitle().toString());
        cost.setText(ListObject.get(position).getCost().toString());

        return vista;
    }
}
