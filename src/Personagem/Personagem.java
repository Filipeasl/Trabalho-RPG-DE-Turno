package Personagem;

import Combate.Habilidades;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Personagem {
    protected String nome;
    protected int PontosVida;
    protected int Forca;
    protected int Defesa;
    protected ArrayList<Habilidades> habilidades;
    protected boolean isPlayer;

    public Personagem(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidades> habilidades, boolean isPlayer) {
        this.nome = nome;
        this.PontosVida = pontosVida;
        this.Forca = forca;
        this.Defesa = defesa;
        this.habilidades = habilidades;
        this.isPlayer = isPlayer;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public Personagem(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return PontosVida;
    }

    public void setPontosVida(int pontosVida) {
        PontosVida = pontosVida;
    }

    public int getForca() {
        return Forca;
    }

    public void setForca(int forca) {
        Forca = forca;
    }

    public int getDefesa() {
        return Defesa;
    }

    public void setDefesa(int defesa) {
        Defesa = defesa;
    }

    public void atacar(Personagem p){
        p.defender(this);
    }

    public void defender(Personagem p){
        this.PontosVida -= Math.abs(p.getForca() - this.getDefesa());
    }

    public boolean fugir(){
        int randomNum = (int)(Math.random() * (10));

        if (randomNum == 1)
            return true;
        return false;
    }

    //???w
    public int calcularDano(Habilidades h) {
        return h.getDanoHabilidade();
    }
}
