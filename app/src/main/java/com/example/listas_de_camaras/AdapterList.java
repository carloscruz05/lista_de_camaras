package com.listas_de_camaras;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listas_de_camaras.R;

public class AdapterList extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nombres;
    private final String[] precios;
    private final Integer[] idimage;

    public AdapterList(Activity context, String[] nombres, String[] precios, Integer[] idimage) {
        super(context, R.layout.item, nombres);
        this.context = context;
        this.nombres = nombres;
        this.precios = precios;
        this.idimage = idimage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item, null);

        TextView _nombre = rowView.findViewById(R.id.nombre);
        TextView _precio = rowView.findViewById(R.id.precio);
        ImageView _imagen = rowView.findViewById(R.id.logo);

        _nombre.setText(nombres[position]);
        _precio.setText(precios[position]);
        _imagen.setImageResource(idimage[position]);

        return rowView;
    }
}

