import Combate.Batalha;
import Personagem.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    public static void main(String[] args)
    {
        Jogo jogoCFG = new Jogo();
        Batalha batalhaCFG = new Batalha();
        Scanner sc = new Scanner(System.in);
        
        // Iniciar rodada
        String opcaoJogador;
        Personagem atacanteDoTurno = new Personagem();
        ArrayList<Personagem> PalcoArray = new ArrayList<>();
        PalcoArray.add(jogoCFG.PalcoJogadorEInimigo().get("Jogador"));
        PalcoArray.add(jogoCFG.PalcoJogadorEInimigo().get("Inimigo"));

        atacanteDoTurno = batalhaCFG.ProximoTurno(PalcoArray);

        System.out.println("Iniciando Rodada");
        while(jogoCFG.GetPersonagensMortos() == null)
        {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Nome: " + PalcoArray.get(0).getNome() + "\t\t\t\t\tVida: " + PalcoArray.get(0).getPontosVida());
            System.out.println("Defesa: " + PalcoArray.get(0).getDefesa() + "\t\t\t\t\t\tForça: " + PalcoArray.get(0).getForca());
            System.out.println("Classe: " + PalcoArray.get(0).getClass().toString().replaceAll("^[^.]*\\.", ""));
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Nome: " + PalcoArray.get(1).getNome() + "\t\t\t\t\tVida: " + PalcoArray.get(1).getPontosVida());
            System.out.println("Defesa: " + PalcoArray.get(1).getDefesa() + "\t\t\t\t\t\t\tForça: " + PalcoArray.get(1).getForca());
            System.out.println("Classe: " + PalcoArray.get(1).getClass().toString().replaceAll("^[^.]*\\.", ""));
            System.out.println("--------------------------------------------------------------------");


            System.out.println("Vez do " + atacanteDoTurno.getNome() + " atacando");

            // Jogador ataca
            if (atacanteDoTurno.isPlayer()){
                do {
                    System.out.println(BLUE + "Você prefere " + PURPLE + "atacar" + BLUE + ", " + PURPLE + "fugir" + BLUE + " ou usar uma " + PURPLE + "habilidade?" + ANSI_RESET);
                    opcaoJogador = sc.nextLine();
                } while (!opcaoJogador.equals("atacar") && !opcaoJogador.equals("fugir") && !opcaoJogador.equals("habilidade"));
                
                switch (opcaoJogador) {
                    case "atacar":
                        System.out.println("Você ataca!");
                        atacanteDoTurno.atacar(jogoCFG.PalcoJogadorEInimigo().get("Inimigo"));
                        break;
                    case "fugir":
                        System.out.println("Você tenta fugir!");
                        if (atacanteDoTurno.fugir())
                        {
                            System.out.println("Você fugiu!");
                            return;
                        }else{
                            System.out.printf("Você não conseguiu fugir!");
                        }
                        break;
                    case "habilidade":
                        System.out.println("Ainda não implementei habilidades!");
                        break;
                }
            }
            
            // Inimigo ataca
            if (!atacanteDoTurno.isPlayer()) {
                Random rand = new Random();

                switch (rand.nextInt(2))
                {
                    // Atacar
                    case 0 :
                        System.out.println("Inimigo ataca!");
                        atacanteDoTurno.atacar(jogoCFG.PalcoJogadorEInimigo().get("Jogador"));
                        break;
                    // Fugir
                    case 1 :
                        System.out.println("Inimigo tenta fugir!");
                        if (atacanteDoTurno.fugir())
                        {
                            System.out.println("Inimigo fugiu!");
                            return;
                        }else{
                            System.out.printf("Inimigo tentou, mas não conseguiu fugir!");
                        }
                        break;
                    // Habilidade
                    case 2 :

                        break;
                }
            }
            atacanteDoTurno = batalhaCFG.ProximoTurno(atacanteDoTurno, PalcoArray);

            sc.nextLine();
        }

        System.out.println("Fim de Jogo!");
        System.out.println(jogoCFG.GetPersonagensMortos().getNome() + " perdeu o jogo!");
    }
}