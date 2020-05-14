package com.karenreal.approomkr.Models;
public class Escape {
    private String nombre;
    private String imagenid;
    private String tipoid;
    private String lugarid;


    public Escape() {
    }

    public Escape(String nombre, String imagenid, String tipoid, String lugarid) {
        this.nombre = nombre;
        this.imagenid = imagenid;
        this.tipoid = tipoid;
        this.lugarid= lugarid;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenid() {
        return imagenid;
    }

    public void setImagenid(String imagenid) {
        this.imagenid = imagenid;
    }

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public String getLugarid() {
        return lugarid;
    }

    public void setLugarid(String lugarid) {
        this.lugarid = lugarid;
    }
}
