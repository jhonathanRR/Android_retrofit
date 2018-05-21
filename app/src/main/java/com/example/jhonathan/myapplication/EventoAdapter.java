package com.example.jhonathan.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {

    private List<Evento> items;

    public static class EventoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombreEvento;
        public TextView nombreOrganizador;
        public TextView fechaInicio;
        public TextView fechaFin;

        public EventoViewHolder(View v) {
            super(v);
            nombreEvento = (TextView) v.findViewById(R.id.nombreEvento);
            nombreOrganizador = (TextView) v.findViewById(R.id.nombreOrganizador);
            fechaInicio = (TextView) v.findViewById(R.id.fechaInicio);
            fechaFin = (TextView) v.findViewById(R.id.fechaFin);
        }
    }

    public EventoAdapter(List<Evento> items) {
        this.items = items;
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
