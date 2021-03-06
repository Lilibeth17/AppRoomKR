package com.karenreal.approomkr.Models;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class EscapeRellenar {
    private String imageView;
    private String lugarid, idinfo;
     private String idpersonas;
    private String       idtiempo;
    private String       idprecio;
    private String       idtipo;
    private String       iddificultad;
    private String       idedad;
    private String       txtlugar;
    private String       txttelefo;
    private String      txtcorreo;
    private String idtitulo;



    private ArrayList<Comentarios> listac;
    private ArrayList<Salas> listaSalas;


    public ArrayList<Comentarios> getListac() {
        return listac;
    }

    public void setListac(ArrayList<Comentarios> listac) {
        this.listac = listac;
    }

    public EscapeRellenar() {
        listac = new ArrayList<>();
        listaSalas = new ArrayList<>();
    }

    public EscapeRellenar(String imageView, String lugarid, String idpersonas, String idtiempo, String idprecio, String idtipo, String iddificultad, String idedad, String txtlugar, String txttelefo, String txtcorreo,String idinfo, String idtitulo) {
        this.imageView = imageView;
        this.lugarid = lugarid;
        this.idpersonas = idpersonas;
        this.idtiempo = idtiempo;
        this.idprecio = idprecio;
        this.idtipo = idtipo;
        this.iddificultad = iddificultad;
        this.idedad = idedad;
        this.txtlugar = txtlugar;
        this.txttelefo = txttelefo;
        this.txtcorreo = txtcorreo;
        this.idtitulo = idtitulo;
        this.idinfo= idinfo;
    }

    public String getIdinfo() {
        return idinfo;
    }

    public void setIdinfo(String idinfo) {
        this.idinfo = idinfo;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public String getLugarid() {
        return lugarid;
    }

    public void setLugarid(String lugarid) {
        this.lugarid = lugarid;
    }

    public String getIdpersonas() {
        return idpersonas;
    }

    public void setIdpersonas(String idpersonas) {
        this.idpersonas = idpersonas;
    }

    public String getIdtiempo() {
        return idtiempo;
    }

    public void setIdtiempo(String idtiempo) {
        this.idtiempo = idtiempo;
    }

    public String getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(String idprecio) {
        this.idprecio = idprecio;
    }

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }

    public String getIddificultad() {
        return iddificultad;
    }

    public void setIddificultad(String iddificultad) {
        this.iddificultad = iddificultad;
    }

    public String getIdedad() {
        return idedad;
    }

    public void setIdedad(String idedad) {
        this.idedad = idedad;
    }

    public String getTxtlugar() {
        return txtlugar;
    }

    public void setTxtlugar(String txtlugar) {
        this.txtlugar = txtlugar;
    }

    public String getTxttelefo() {
        return txttelefo;
    }

    public void setTxttelefo(String txttelefo) {
        this.txttelefo = txttelefo;
    }

    public String getTxtcorreo() {
        return txtcorreo;
    }

    public void setTxtcorreo(String txtcorreo) {
        this.txtcorreo = txtcorreo;
    }


    public String getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(String idtitulo) {
        this.idtitulo = idtitulo;
    }

    public ArrayList<Salas> getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(ArrayList<Salas> listaSalas) {
        this.listaSalas = listaSalas;
    }
}

