package Personagem;

import Combate.Habilidades;

import java.util.ArrayList;

public class Arqueiro extends Personagem{
    private ArrayList<String> Flexas = new ArrayList<String>();
    private int pontosExperiencia;
    private int Destreza;

    public ArrayList<String> getFlexas() {
        return Flexas;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public int getDestreza() {
        return Destreza;
    }

    public Arqueiro(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidades> habilidades, boolean isPlayer, ArrayList<String> flexas, int pontosExperiencia, int destreza) {
        super(nome, pontosVida, forca, defesa, habilidades, isPlayer);
        Flexas = flexas;
        this.pontosExperiencia = pontosExperiencia;
        Destreza = destreza;
    }
}
