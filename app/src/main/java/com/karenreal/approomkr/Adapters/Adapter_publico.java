package com.karenreal.approomkr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karenreal.approomkr.Models.Publico;
import com.karenreal.approomkr.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_publico extends RecyclerView.Adapter<Adapter_publico.Holder> {

    private Context context;
    private ArrayList<Publico> listadapterpublic;

    public Adapter_publico(Context context, ArrayList<Publico> listadapterpublic) {
        this.context = context;
        this.listadapterpublic = listadapterpublic;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.filapublico, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_publico.Holder holder, int position) {

        holder.tipo.setText(listadapterpublic.get(position).getPublicoid());
        Picasso.get().load(listadapterpublic.get(position).getPublicoimg()).into(holder.pubimg);
    }

    @Override
    public int getItemCount() {
        return listadapterpublic.size();
    }


    public class Holder extends RecyclerView.ViewHolder{
        private TextView tipo;
        private ImageView pubimg;

        public Holder(View itemView) {
            super(itemView);
            tipo=itemView.findViewById(R.id.publicoid);
            pubimg= itemView.findViewById(R.id.publicoimg);

        }
    }

}
