package com.karenreal.approomkr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.karenreal.approomkr.Models.Comentarios;

public class Vercomentarios extends AppCompatActivity {

    private TextView tema, comentario;
    private RatingBar ratingver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tema= findViewById(R.id.idtema);
        comentario= findViewById(R.id.idcomenta);
        ratingver= findViewById(R.id.ratingcoment);


        if(getIntent().getExtras() != null){
            Comentarios comentarios= getIntent().getExtras().getParcelable("comentarios");
            tema.setText(comentarios.getTemacoment());
            comentario.setText(comentarios.getComentario());
            ratingver.setRating(comentarios.getRatingBar());
        }
    }
}
