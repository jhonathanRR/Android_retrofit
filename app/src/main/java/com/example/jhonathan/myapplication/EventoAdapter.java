package com.example.jhonathan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {

    private static List<Evento> items;
    static Context context;

    public static class EventoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Campos respectivos de un item
        public TextView nombreEvento;
        public TextView nombreOrganizador;
        public TextView fechaInicio;
        public TextView fechaFin;


        public EventoViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            nombreEvento = (TextView) v.findViewById(R.id.nombreEvento);
            nombreOrganizador = (TextView) v.findViewById(R.id.nombreOrganizador);
            fechaInicio = (TextView) v.findViewById(R.id.fechaInicio);
            fechaFin = (TextView) v.findViewById(R.id.fechaFin);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, DetalleEvento.class);
            Bundle b = new Bundle();
            b.putString("nombreEvento", items.get(position).getName());
            b.putString("nombreOrganizador", items.get(position).getOrganizator());
            b.putString("fechaInicio", items.get(position).getDateInit());
            b.putString("fechaFin", items.get(position).getDateEnd());
            b.putString("descripcion", items.get(position).getDescription());
            intent.putExtras(b);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public EventoAdapter(List<Evento> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.evento_card, viewGroup, false);
        return new EventoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EventoViewHolder viewHolder, int i) {
        viewHolder.nombreEvento.setText(items.get(i).getName());
        viewHolder.nombreOrganizador.setText(items.get(i).getOrganizator());
        viewHolder.fechaInicio.setText(items.get(i).getDateInit());
        viewHolder.fechaFin.setText(items.get(i).getDateEnd());
    }

}
