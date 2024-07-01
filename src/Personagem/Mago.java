package Personagem;

import Combate.Habilidades;

import java.util.ArrayList;

public class Mago extends Personagem{
    private ArrayList<String> Magias = new ArrayList<String>();
    private int pontosExperiencia;
    private int PontosMagia;

    public ArrayList<String> getMagias() {
        return Magias;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public int getPontosMagia() {
        return PontosMagia;
    }

    public Mago(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidades> habilidades, boolean isPlayer, ArrayList<String> magias, int pontosExperiencia, int pontosMagia) {
        super(nome, pontosVida, forca, defesa, habilidades, isPlayer);
        Magias = magias;
        this.pontosExperiencia = pontosExperiencia;
        PontosMagia = pontosMagia;
    }

    public void usarMagia(Personagem p) {
        p.defender(this);
    }
}
