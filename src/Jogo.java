import Combate.Batalha;
import Combate.Habilidades;
import Personagem.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Jogo {
    private HashMap<String, Personagem> PalcoJogadorInimigo;
    public Batalha batalha;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    Jogo() {
        Scanner sc = new Scanner(System.in);
        String nome;
        String classeJogador;
        String classeInimigo;
        String jogadorOpcao;
        this.PalcoJogadorInimigo = new HashMap<String, Personagem>();
        batalha = new Batalha();

        // Escolher nome do jogador
        System.out.println(BLUE + "Digite seu nome:" + ANSI_RESET);
        nome = sc.nextLine();

        // Escolher classeJogador do jogador
        do {
            System.out.println(BLUE + "Você prefere ser um " + PURPLE + "Guerreiro" + BLUE + ", um " + PURPLE + "Mago" + BLUE + " ou um " + PURPLE + "Arqueiro?" + ANSI_RESET);
            classeJogador = sc.nextLine();
        } while(!classeJogador.equals("Guerreiro") && !classeJogador.equals("Mago") && !classeJogador.equals("Arqueiro"));

        // Escolher classeInimigo
        do{
            classeInimigo = "";
            System.out.println(BLUE + "Deseja escolher seu inimigo? " + PURPLE + "Sim" + BLUE + " ou " + PURPLE + "Não" + BLUE + "?" + ANSI_RESET);
            jogadorOpcao = sc.nextLine();

            switch(jogadorOpcao){
                case "Sim":
                    do {
                        System.out.println(BLUE + "Você prefere lutar contra um " + PURPLE + "Monstro" + BLUE + ", um " + PURPLE + "Chefe" + BLUE + " ou um " + PURPLE + "Ogro?" + ANSI_RESET);
                        classeInimigo = sc.nextLine();
                    } while(!classeInimigo.equals("Monstro") && !classeInimigo.equals("Chefe") && !classeInimigo.equals("Ogro"));
                    break;
                case "Não":
                    int randomNum = (int)(Math.random() * (3));
                    switch (randomNum){
                        case 0: classeInimigo = "Chefe";
                            break;
                        case 1: classeInimigo = "Ogro";
                            break;
                        case 2: classeInimigo = "Monstro";
                    }
            }
        } while (!jogadorOpcao.equals("Sim") && !jogadorOpcao.equals("Não"));

        //Configurar novo jogo
        Personagem jogador = new Personagem();
        switch(classeJogador){
            case "Guerreiro":
                jogador = new Guerreiro(
                        nome,
                        100,
                        90,
                        90,
                        null,
                        true,
                        new ArrayList<String>(Arrays.asList("Espada", "Machado")),
                        0,
                        20
                );
                break;
            case "Mago":
                jogador = new Mago(
                        nome,
                        100,
                        90,
                        30,
                        null,
                        true,
                        new ArrayList<String>(Arrays.asList("Explosão", "Fogo")),
                        0,
                        60
                );
                break;
            case "Arqueiro":
                jogador = new Arqueiro(
                        nome,
                        100,
                        50,
                        80,
                        null,
                        true,
                        new ArrayList<String>(Arrays.asList("Flecha envenenada", "Flecha flamejante")),
                        0,
                        60
                );
                break;
        }

        Personagem inimigo = new Personagem();
        switch(classeInimigo){
            case "Chefe":
                inimigo = new Inimigo(
                        "Chefao",
                        100,
                        50,
                        40,
                        null,
                        false,
                        "Chefe",
                        500
                );
                break;
            case "Ogro":
                inimigo = new Inimigo(
                        "Ogro verde",
                        100,
                        30,
                        10,
                        null,
                        false,
                        "Ogro",
                        300
                );
                break;
            case "Monstro":
                inimigo = new Inimigo(
                        "Monstrengo",
                        100,
                        10,
                        5,
                        null,
                        false,
                        "Monstro",
                        100
                );
                break;
        }

        this.PalcoJogadorInimigo.put("Jogador", jogador);
        this.PalcoJogadorInimigo.put("Inimigo", inimigo);
    }

    public Personagem GetPersonagensMortos()
    {
        for (Personagem p : this.PalcoJogadorInimigo.values()) {
            if (p.getPontosVida() <= 0)
                return p;
        }
        return null;
    }

    public HashMap<String, Personagem> PalcoJogadorEInimigo() {
        return PalcoJogadorInimigo;
    }
}
