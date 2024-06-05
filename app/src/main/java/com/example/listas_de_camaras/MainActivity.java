package com.example.listas_de_camaras;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listas_de_camaras.R;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.List);

        String[] nombres = {"Canon EOS Rebel T7", "Nikon D3500", "Sony Alpha A6000", "Fujifilm X-T30", "Olympus OM-D E-M10 Mark IV"};
        String[] precios = {"500", "400", "600", "800", "700"};
        Integer[] idimage = {R.drawable.canon, R.drawable.nikon, R.drawable.sony, R.drawable.fujifilm, R.drawable.olympus};

        com.listas_de_camaras.AdapterList adapter = new com.listas_de_camaras.AdapterList(this, nombres, precios, idimage);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int precio = Integer.parseInt(precios[position]);
                total += precio;
                Toast.makeText(getApplicationContext(), "Seleccionaste la cámara: " + nombres[position] + ". Total: $" + total, Toast.LENGTH_LONG).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int precio = Integer.parseInt(precios[position]);
                total -= precio;
                Toast.makeText(getApplicationContext(), "Removiste la cámara: " + nombres[position] + ". Total: $" + total, Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
