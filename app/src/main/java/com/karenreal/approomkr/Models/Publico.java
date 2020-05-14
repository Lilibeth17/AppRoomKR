package com.karenreal.approomkr.Models;

public class Publico {
    private String publicoid;
    private String publicoimg;

    public Publico() {
    }

    public Publico(String publicoid, String publicoimg) {
        this.publicoid = publicoid;
        this.publicoimg = publicoimg;
    }

    public String getPublicoid() {
        return publicoid;
    }

    public void setPublicoid(String publicoid) {
        this.publicoid = publicoid;
    }

    public String getPublicoimg() {
        return publicoimg;
    }

    public void setPublicoimg(String publicoimg) {
        this.publicoimg = publicoimg;
    }
}
