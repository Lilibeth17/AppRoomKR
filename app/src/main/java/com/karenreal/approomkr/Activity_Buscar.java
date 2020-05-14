package com.karenreal.approomkr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.karenreal.approomkr.Adapters.Adapter_buscar;
import com.karenreal.approomkr.Models.Escape;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_Buscar extends AppCompatActivity {

  private   RecyclerView recyclerView;
  private DatabaseReference reference;
    private StorageReference storageReference;

    private ArrayList<Escape> lista;
    private Context context= Activity_Buscar.this;
    private Adapter_buscar adapter_buscar;
    private GridLayoutManager layoutManager;
    private Button regalo;
    private CircleImageView imagen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__buscar);

        recyclerView= findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager= new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        reference= FirebaseDatabase.getInstance().getReference("Escapes");
        storageReference= FirebaseStorage.getInstance().getReference();
        regalo= findViewById(R.id.boton_regalo);

        imagen= findViewById(R.id.imageid);

        lista= new ArrayList<>();
        adapter_buscar= new Adapter_buscar(this,lista);
        recyclerView.setAdapter(adapter_buscar);
        init();

    }





    private void init() {
        Query query= reference;
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<Escape>>genericTypeIndicator= new GenericTypeIndicator<ArrayList<Escape>>() {};
                lista.clear();
                lista.addAll(dataSnapshot.getValue(genericTypeIndicator));
                adapter_buscar.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
