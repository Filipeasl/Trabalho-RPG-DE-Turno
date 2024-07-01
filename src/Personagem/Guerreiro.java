package Personagem;

import Combate.Habilidades;

import java.util.ArrayList;

public class Guerreiro extends Personagem{
    private ArrayList<String> Armas = new ArrayList<String>();
    private int pontosExperiencia;
    private int Rage;

    public ArrayList<String> getArmas() {
        return Armas;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public int getRage() {
        return Rage;
    }

    public Guerreiro(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidades> habilidades, boolean isPlayer, ArrayList<String> armas, int pontosExperiencia, int rage) {
        super(nome, pontosVida, forca, defesa, habilidades, isPlayer);
        Armas = armas;
        this.pontosExperiencia = pontosExperiencia;
        Rage = rage;
    }
}
