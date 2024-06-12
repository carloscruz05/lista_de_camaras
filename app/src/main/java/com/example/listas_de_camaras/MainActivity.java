package com.example.listas_de_camaras;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.List);

        String[] nombres = getResources().getStringArray(R.array.camera_names);
        String[] precios = getResources().getStringArray(R.array.camera_prices);
        Integer[] idimage = {R.drawable.canon, R.drawable.nikon, R.drawable.sony, R.drawable.fujifilm, R.drawable.olympus};

        com.listas_de_camaras.AdapterList adapter = new com.listas_de_camaras.AdapterList(this, nombres, precios, idimage);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int precio = Integer.parseInt(precios[position]);
                total += precio;
                String message = getString(R.string.camera_selected, nombres[position], total);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int precio = Integer.parseInt(precios[position]);
                total -= precio;
                String message = getString(R.string.camera_removed, nombres[position], total);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
