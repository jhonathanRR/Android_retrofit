package com.example.jhonathan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class DetalleEvento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_evento);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Bundle b = getIntent().getExtras();
        String nombreEvento = b.getString("nombreEvento");
        String nombreOrganizador = b.getString("nombreOrganizador");
        String fechaInicio = b.getString("fechaInicio");
        String fechaFin = b.getString("fechaFin");
        String descripcion = b.getString("descripcion");

        TextView nEvento = findViewById(R.id.nombreEvento);
        TextView nOrganizador = findViewById(R.id.nombreOrganizador);
        TextView fInicio = findViewById(R.id.fechaInicio);
        TextView fFin = findViewById(R.id.fechaFin);
        TextView desc = findViewById(R.id.descripcion);

        nEvento.setText(nombreEvento);
        nOrganizador.setText(nombreOrganizador);
        fInicio.setText(fechaInicio);
        fFin.setText(fechaFin);
        desc.setText(descripcion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
