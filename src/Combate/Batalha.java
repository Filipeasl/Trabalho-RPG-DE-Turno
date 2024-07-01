package Combate;

import Personagem.Personagem;

import java.util.ArrayList;

public class Batalha {
    public Batalha() {}

    public Personagem ProximoTurno(Personagem PersonagemTurnoAtual, ArrayList<Personagem> Personagens)
    {
        int randomNum;

        do {
            randomNum = (int)(Math.random() * (Personagens.size()));
            if (!Personagens.get(randomNum).equals(PersonagemTurnoAtual))
                return Personagens.get(randomNum);
        } while (Personagens.get(randomNum).equals(PersonagemTurnoAtual));

        return null;
    }

    public Personagem ProximoTurno(ArrayList<Personagem> Personagens)
    {
        int randomNum;
        randomNum = (int)(Math.random() * (Personagens.size()));
        return Personagens.get(randomNum);
    }
}
