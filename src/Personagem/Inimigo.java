package Personagem;

import Combate.Habilidades;

import java.util.ArrayList;

public class Inimigo extends Personagem{
    public String tipo;
    private int RecompensaXP;

    public String getTipo() {
        return tipo;
    }

    public int getRecompensaXP() {
        return RecompensaXP;
    }

    public Inimigo(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidades> habilidades, boolean isPlayer, String tipo, int recompensaXP) {
        super(nome, pontosVida, forca, defesa, habilidades, isPlayer);
        this.tipo = tipo;
        RecompensaXP = recompensaXP;
    }
}
