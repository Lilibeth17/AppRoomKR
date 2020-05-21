package com.karenreal.approomkr.Adapters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.karenreal.approomkr.ActivityScroolScape;
import com.karenreal.approomkr.Models.Escape;
import com.karenreal.approomkr.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_buscar extends RecyclerView.Adapter<Adapter_buscar.Holder> {

    private Context context;
    private ArrayList<Escape> listaadapter;

    public Adapter_buscar(Context context, ArrayList<Escape> listaadapter){
        this.context= context;
        this.listaadapter= listaadapter;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_scape, null);
        return new Holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.nombre.setText(listaadapter.get(position).getNombre());
        holder.tipoid.setText(listaadapter.get(position).getTipoid());
        holder.lugarid.setText(listaadapter.get(position).getLugarid());

        Picasso.get().load(listaadapter.get(position).getImagenid()).into(holder.imagen);

        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, ActivityScroolScape.class);
                Bundle bundle= new Bundle();
                bundle.putInt("ID", position);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return listaadapter.size();
    }

    public  class Holder extends RecyclerView.ViewHolder{
        CircleImageView imagen;
        TextView nombre, tipoid, lugarid;
        public Holder(View itemview){
            super(itemview);
            imagen= itemview.findViewById(R.id.imageid);
            nombre= itemview.findViewById(R.id.nombre);
            tipoid= itemview.findViewById(R.id.publicoid);
            lugarid= itemview.findViewById(R.id.lugarid);
        }
    }
}
