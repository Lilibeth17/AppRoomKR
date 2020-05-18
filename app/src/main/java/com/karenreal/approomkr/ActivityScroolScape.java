package com.karenreal.approomkr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.karenreal.approomkr.Adapters.Adapter_Comentarios;
import com.karenreal.approomkr.Adapters.Adapter_Escape;
import com.karenreal.approomkr.Models.Comentarios;
import com.karenreal.approomkr.Models.Escape;
import com.karenreal.approomkr.Models.EscapeRellenar;

import java.util.ArrayList;

public class ActivityScroolScape extends AppCompatActivity {

    private ScrollView scrollView;
    private Adapter_Escape adapter_escape;
    private ArrayList<EscapeRellenar> escapeRellenars;
    private StorageReference storage;
    private DatabaseReference reference;
    private RecyclerView recyclerViewescape;
    private ListView listViewcoment;
    private Adapter_Comentarios adapter_comentarios;
    private ArrayList<Comentarios> listacomentarios;
    private static int ADDCOMENTARIO =1;

    /**
     * Completar con todos los campos
     */
    TextView idTitulo;

    private EscapeRellenar escapeRellenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrool_scape);

        listViewcoment= findViewById(R.id.listviewcomentarios);
        scrollView= findViewById(R.id.scrollscape);

        /**
         * Completar con todos los campos
         */
        idTitulo= findViewById(R.id.idtitulo);

        int id = getIntent().getExtras().getInt("ID");
        reference= FirebaseDatabase.getInstance().getReference("ListaEscape").child(String.valueOf(id));
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<EscapeRellenar> gt = new GenericTypeIndicator<EscapeRellenar>() {};
                escapeRellenar = dataSnapshot.getValue(gt);
                if (escapeRellenar != null){
                    idTitulo.setText(escapeRellenar.getIdtipo());
                    Log.e("NULL","NO Es null");

                    /**
                     * Completar con todos los campos
                     */
                }
                else
                {
                    Log.e("NULL","Es null");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDCOMENTARIO && resultCode==RESULT_OK) {
            Comentarios comentarios = data.getExtras().getParcelable("comentarios");
            listacomentarios.add(comentarios);
            adapter_comentarios.notifyDataSetChanged();
        }
    }


    private void init() {
        Query query= reference;
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<ArrayList<EscapeRellenar>> genericTypeIndicator= new GenericTypeIndicator<ArrayList<EscapeRellenar>>() {};
                escapeRellenars.clear();
                escapeRellenars.addAll(dataSnapshot.getValue(genericTypeIndicator));
                adapter_escape.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
