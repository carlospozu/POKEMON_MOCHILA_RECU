package com.example.pokemon;

import java.io.File;

public class PokemonMalo {
    String nombre;
    Integer nivel;
    Integer vida;
    Integer vidaRestante;
    File foto;


    public PokemonMalo(String Nombre, Integer Nivel, Integer Vida, Integer VidaRestante, File foto) {
        this.nombre = Nombre;
        this.nivel = Nivel;
        this.vida = Vida;
        this.vidaRestante = VidaRestante;
        this.foto = foto;
    }
}
