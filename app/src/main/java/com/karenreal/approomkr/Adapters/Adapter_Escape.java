package com.karenreal.approomkr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karenreal.approomkr.Models.EscapeRellenar;
import com.karenreal.approomkr.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Escape extends RecyclerView.Adapter<Adapter_Escape.Holder> {

    private Context context;
    private ArrayList<EscapeRellenar>listaadapterescape;

    public Adapter_Escape(Context context, ArrayList<EscapeRellenar> listaadapterescape) {
        this.context = context;
        this.listaadapterescape = listaadapterescape;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_scrool_scape, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.lugarid.setText(listaadapterescape.get(position).getLugarid());
        holder.idpersonas.setText(listaadapterescape.get(position).getIdpersonas());
        holder.idtiempo.setText(listaadapterescape.get(position).getIdtiempo());
        holder.idprecio.setText(listaadapterescape.get(position).getIdprecio());
        holder.idtipo.setText(listaadapterescape.get(position).getIdtipo());
        holder.iddificultad.setText(listaadapterescape.get(position).getIddificultad());
        holder.idedad.setText(listaadapterescape.get(position).getIdedad());
        holder.txtlugar.setText(listaadapterescape.get(position).getTxtlugar());
        holder.txttelefo.setText(listaadapterescape.get(position).getTxttelefo());
        holder.txtcorreo.setText(listaadapterescape.get(position).getTxtcorreo());
        holder.idtitulo.setText(listaadapterescape.get(position).getIdtitulo());

        Picasso.get().load(listaadapterescape.get(position).getImageView()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listaadapterescape.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView lugarid, idpersonas, idtiempo, idprecio, idtipo,
                iddificultad, idedad, txtlugar,txttelefo, txtcorreo, idtitulo;
    public Holder (View itemview){
        super(itemview);

        imageView= itemview.findViewById(R.id.imgescape);
        lugarid= itemview.findViewById(R.id.idlugar);
        idpersonas= itemview.findViewById(R.id.idpersonas);
        idtiempo= itemview.findViewById(R.id.idtiempo);
        idprecio= itemview.findViewById(R.id.idprecio);
        idtipo= itemview.findViewById(R.id.idtipoes);
        iddificultad= itemview.findViewById(R.id.iddificultad);
        idedad= itemview.findViewById(R.id.idedad);
        txtlugar= itemview.findViewById(R.id.idlugar);
        txttelefo= itemview.findViewById(R.id.txttelefonoes);
        txtcorreo= itemview.findViewById(R.id.txtcorreoes);
        idtitulo= itemview.findViewById(R.id.idtitulo);

    }
 }
}