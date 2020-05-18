package com.karenreal.approomkr.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.karenreal.approomkr.R;

import java.util.ArrayList;

public class Fragment_principal extends Fragment {

    private RecyclerView recyclerView;
    private DatabaseReference reference;
    private StorageReference storageReference;
    private ArrayList<Escape> list;
    private Context context= Fragment_principal.this.getContext();
    private GridLayoutManager layoutManager;
    private Adapter_buscar adapter_buscarprin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_principal, container, false);

        recyclerView = view.findViewById(R.id.recyclerprincipal);
        recyclerView.setHasFixedSize(true);
        layoutManager= new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);

        list= new ArrayList<>();
        reference= FirebaseDatabase.getInstance().getReference("Escapes");
        storageReference= FirebaseStorage.getInstance().getReference();
        adapter_buscarprin= new Adapter_buscar(getContext(),list);
        recyclerView.setAdapter(adapter_buscarprin);
        init();

        return view;

    }

    private void init() {
        Query query= reference;
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<Escape>> genericTypeIndicator= new GenericTypeIndicator<ArrayList<Escape>>() {};
                list.clear();
                list.addAll(dataSnapshot.getValue(genericTypeIndicator));
                adapter_buscarprin.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
