package com.karenreal.approomkr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.karenreal.approomkr.Models.Comentarios;
import com.karenreal.approomkr.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Comentarios extends ArrayAdapter<Comentarios> {


    private ArrayList<Comentarios> lista;
    private Context context;
    private int resource;

    public Adapter_Comentarios(@NonNull Context context, int resource, @NonNull List<Comentarios> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource= resource;
        this.lista=(ArrayList<Comentarios>) objects;
    }

    public  View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View fila = layoutInflater.inflate(resource, null);
        TextView txttema = fila.findViewById(R.id.idtema);
        TextView txtcomentario = fila.findViewById(R.id.idcomenta);
        RatingBar ratingBar= fila.findViewById(R.id.ratingcoment);

        Comentarios comentarios= lista.get(position);
        txttema.setText(comentarios.getTemacoment());
        txtcomentario.setText(comentarios.getComentario());
        ratingBar.setRating(comentarios.getRatingBar());

        return fila;

    }
}