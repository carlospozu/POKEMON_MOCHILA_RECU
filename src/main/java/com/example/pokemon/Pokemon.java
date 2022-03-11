package com.example.pokemon;

import java.io.File;

public class Pokemon {
    String nombre;
    Integer nivel;
    float vida;
    float vidaRestante;
    File foto;
    File sexo;
    Boolean seleccionado;

    public Pokemon(String Nombre, Integer Nivel, Integer Vida, Integer VidaRestante, File foto, File sexo, Boolean seleccionado) {
        this.nombre = Nombre;
        this.nivel = Nivel;
        this.vida = Vida;
        this.vidaRestante = VidaRestante;
        this.foto = foto;
        this.sexo = sexo;
        this.seleccionado=seleccionado;
    }
}
