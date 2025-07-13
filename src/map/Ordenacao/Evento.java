package map.Ordenacao;

public class Evento {

    private final String nome;
    private final String atracao;

    public Evento(String nome, String atracao) {
        this.nome = nome;
        this.atracao = atracao;
    }

    public String getNome() {
        return nome;
    }

    public String getAtracao() {
        return atracao;
    }

    @Override
    public String toString() {
        return String.format("Evento: %s | Atração: %s", nome, atracao);
    }
}

