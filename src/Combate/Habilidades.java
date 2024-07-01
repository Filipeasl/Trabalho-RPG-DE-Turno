package Combate;

public class Habilidades {
    private String nomeH;
    private int DanoHabilidade;

    public Habilidades(String nomeH, int danoHabilidade) {
        this.nomeH = nomeH;
        DanoHabilidade = danoHabilidade;
    }

    public String getNomeH() {
        return nomeH;
    }

    public void setNomeH(String nomeH) {
        this.nomeH = nomeH;
    }

    public int getDanoHabilidade() {
        return DanoHabilidade;
    }

    public void setDanoHabilidade(int danoHabilidade) {
        DanoHabilidade = danoHabilidade;
    }
}
