package com.karenreal.approomkr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.karenreal.approomkr.Models.Comentarios;

public class ComentarioAdd extends AppCompatActivity {

    private Button bntAdd;
    private TextView tema, coment;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bntAdd= findViewById(R.id.btnaddcoment);
        tema= findViewById(R.id.idtema);
        coment= findViewById(R.id.idcomenta);
        ratingBar= findViewById(R.id.ratingcoment);


        bntAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!tema.getText().toString().isEmpty()&&
                        !coment.getText().toString().isEmpty()){
                    Comentarios comentarios= new Comentarios(tema.getText().toString(),
                            coment.getText().toString(), ratingBar.getRating());

                    Intent intent= new Intent();
                    Bundle bundle= new Bundle();
                    bundle.putParcelable("comentarios", (Parcelable) comentarios);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
