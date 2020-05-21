package com.karenreal.approomkr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karenreal.approomkr.Models.Comentarios;
import com.karenreal.approomkr.R;
import java.util.ArrayList;
public class Adapter_Comentarios extends RecyclerView.Adapter<Adapter_Comentarios.Holder> {

    private Context context;
    private ArrayList<Comentarios> listacoemntarios;



    public Adapter_Comentarios( Context context,ArrayList<Comentarios> listasc){
        this.context= context;
        this.listacoemntarios= listasc;

    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_comentarios, null);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.temacom.setText(listacoemntarios.get(position).getTemacoment());
        holder.comentario.setText(listacoemntarios.get(position).getComentario());
        holder.ratingcomen.setRating(listacoemntarios.get(position).getRatingBar());

    }

    @Override
    public int getItemCount() {
        return listacoemntarios.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView temacom;
        private TextView comentario;
        private RatingBar ratingcomen;

        public View view;

        public Holder(View view){
            super(view);
            temacom= view.findViewById(R.id.idtema);
            comentario= view.findViewById(R.id.idcomenta);
            ratingcomen= view.findViewById(R.id.ratingcoment);
        }
    }

}