package com.karenreal.approomkr.Models;

import android.widget.RatingBar;

public class Comentarios {

    private String temacoment;
    private String comentario;
    private float ratingBar;

    public Comentarios() {
    }

    public Comentarios(String temacoment, String comentario, float ratingBar) {
        this.temacoment = temacoment;
        this.comentario = comentario;
        this.ratingBar = ratingBar;
    }

    public String getTemacoment() {
        return temacoment;
    }

    public void setTemacoment(String temacoment) {
        this.temacoment = temacoment;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }
}
