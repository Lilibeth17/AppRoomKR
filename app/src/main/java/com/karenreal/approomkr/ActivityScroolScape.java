package com.karenreal.approomkr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.karenreal.approomkr.Adapters.Adapter_Comentarios;
import com.karenreal.approomkr.Models.Comentarios;
import com.karenreal.approomkr.Models.EscapeRellenar;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ActivityScroolScape extends AppCompatActivity {


    private Button bntAdd;
    private EditText temac, coment;
    private RatingBar ratingBarc;
    private TextView idtitulo, idlugar, idinfo, idpersonas,
            iddificultad, idedad,idprecio,idtiempo, idtipo,txtcorreo,txtlugar, txttelefono;
    private DatabaseReference reference;
    private Adapter_Comentarios adapter_comentarios;
    private RecyclerView recyclerView;
    private ArrayList<Comentarios> listacomentarios = new ArrayList<>();
    private ImageView imagenesca;
    private int position;

    private GridLayoutManager layoutManager;

    private EscapeRellenar escapeRellenar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrool_scape);

        position = getIntent().getExtras().getInt("ID");

        imagenesca= findViewById(R.id.imgescape);
        idlugar= findViewById(R.id.idlugar);
        idtitulo = findViewById(R.id.idtitulo);
        idinfo= findViewById(R.id.idinformacion);
        idpersonas= findViewById(R.id.idpersonas);
        iddificultad= findViewById(R.id.iddificultad);
        idedad= findViewById(R.id.idedad);
        idprecio= findViewById(R.id.idprecio);
        idtiempo= findViewById(R.id.idtiempo);
        idtipo= findViewById(R.id.idtipoes);
        txtcorreo= findViewById(R.id.txtcorreoes);
        txtlugar= findViewById(R.id.txtlugares);
        txttelefono= findViewById(R.id.txttelefonoes);



        bntAdd = findViewById(R.id.btnaddcoment);
        temac = findViewById(R.id.txttemacoment);
        coment = findViewById(R.id.txtcomentario);
        ratingBarc = findViewById(R.id.ratingBarcoment);
        reference = FirebaseDatabase.getInstance().getReference();
        recyclerView = findViewById(R.id.recyclercomentario);
        recyclerView.setHasFixedSize(true);
        layoutManager= new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        adapter_comentarios = new Adapter_Comentarios(this,listacomentarios );

        recyclerView.setAdapter(adapter_comentarios);


        getcomentarios();

        bntAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temaco = temac.getText().toString();
                String comentario = coment.getText().toString();
                Float valoracion= ratingBarc.getRating();

                Comentarios comentarios = new Comentarios(temaco, comentario, valoracion);

                escapeRellenar.getListac().add(comentarios);
                DatabaseReference refSave =  FirebaseDatabase.getInstance().getReference();
                refSave.child("ListaEscape").child(String.valueOf(position)).setValue(escapeRellenar);

//                reference.child("Comentarios").push().child("temacoment").setValue(temaco);
//                reference.child("Comentarios").push().child("comentario").setValue(comentario);
//                reference.child("Comentarios").push().child("ratingBar").setValue((valoracion));
            }
        });

    }

    private void getcomentarios() {
//        reference.child("ListaEscape").child(String.valueOf(position)).child("Comentarios").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if ((dataSnapshot.exists())) {
//
//                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                        String temac = ds.child("temacoment").getValue().toString();
//                        String comentario = ds.child("comentario").getValue().toString();
//                        Float value = Float.parseFloat(ds.child("ratingBar").getValue().toString());
//                        listacomentarios.add(new Comentarios(temac, comentario, Float.valueOf(value)));
//
//                    }
//                }
                int id = getIntent().getExtras().getInt("ID");
                reference = FirebaseDatabase.getInstance().getReference("ListaEscape").child(String.valueOf(id));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        GenericTypeIndicator<EscapeRellenar> gti = new GenericTypeIndicator<EscapeRellenar>() {
                        };
                        escapeRellenar = dataSnapshot.getValue(gti);
                        if (escapeRellenar != null) {
                            idtitulo.setText(escapeRellenar.getIdtitulo());
                            idlugar.setText(escapeRellenar.getLugarid());
                            idinfo.setText(escapeRellenar.getIdinfo());
                            idpersonas.setText(escapeRellenar.getIdpersonas());
                            iddificultad.setText(escapeRellenar.getIddificultad());
                            idprecio.setText(escapeRellenar.getIdprecio());
                            idedad.setText(escapeRellenar.getIdedad());
                            idtiempo.setText(escapeRellenar.getIdtiempo());
                            idtipo.setText(escapeRellenar.getIdtipo());
                            Picasso.get().load(escapeRellenar.getImageView()).into(imagenesca);

                            txtcorreo.setText(escapeRellenar.getTxtcorreo());
                            txtlugar.setText(escapeRellenar.getLugarid());
                            txttelefono.setText(escapeRellenar.getTxttelefo());
                            listacomentarios.clear();
                            listacomentarios.addAll(escapeRellenar.getListac());
                            adapter_comentarios.notifyDataSetChanged();
                            // Repetir para Salas
                        } else {
                            Log.e("null", "es null");
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
}
