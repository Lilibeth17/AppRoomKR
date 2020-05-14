package com.karenreal.approomkr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.karenreal.approomkr.Adapters.Adapter_publico;
import com.karenreal.approomkr.Models.Publico;

import java.util.ArrayList;

public class ActivityPublico extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter_publico adapter_publico;
    private ArrayList<Publico> lista;
    private DatabaseReference reference;
    private StorageReference storageReference;
    private Context context= ActivityPublico.this;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publico);

        recyclerView= findViewById(R.id.recyclerpublico);
        recyclerView.setHasFixedSize(true);
        gridLayoutManager= new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        reference= FirebaseDatabase.getInstance().getReference("Tipos");
        storageReference= FirebaseStorage.getInstance().getReference();
        lista= new ArrayList<>();
        adapter_publico= new Adapter_publico(this, lista);
        recyclerView.setAdapter(adapter_publico);



        init();
    }


    private void init() {
        Query query= reference;
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<Publico>> genericTypeIndicator= new GenericTypeIndicator<ArrayList<Publico>>() {};
                lista.clear();
                lista.addAll(dataSnapshot.getValue(genericTypeIndicator));
                adapter_publico.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
