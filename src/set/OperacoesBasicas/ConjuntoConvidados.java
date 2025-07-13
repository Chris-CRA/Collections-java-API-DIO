package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidados;

    public ConjuntoConvidados() {
        this.convidados = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        boolean adicionado = convidados.add(new Convidado(nome, codigoConvite));
        if (adicionado) {
            System.out.println("Convidado adicionado: " + nome + " (Código: " + codigoConvite + ")");
        } else {
            System.out.println("Convidado com código " + codigoConvite + " já está na lista.");
        }
    }

    public void removerConvidadoPorCodigo(int codigoConvite) {
        boolean removido = convidados.removeIf(c -> c.getCodigoConvite() == codigoConvite);
        if (removido) {
            System.out.println("Convidado com código " + codigoConvite + " removido.");
        } else {
            System.out.println("Nenhum convidado encontrado com código " + codigoConvite + ".");
        }
    }

    public int contarConvidados() {
        return convidados.size();
    }

    public void listarConvidados() {
        if (convidados.isEmpty()) {
            System.out.println("Nenhum convidado na lista.");
            return;
        }
        System.out.println("Convidados na lista:");
        for (Convidado c : convidados) {
            System.out.println("- " + c);
        }
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjunto = new ConjuntoConvidados();

        conjunto.adicionarConvidado("Alice", 101);
        conjunto.adicionarConvidado("Bob", 102);
        conjunto.adicionarConvidado("Charlie", 103);
        conjunto.adicionarConvidado("Alice", 101); // teste de duplicata

        System.out.println();
        conjunto.listarConvidados();
        System.out.println("Total de convidados: " + conjunto.contarConvidados());

        System.out.println();
        conjunto.removerConvidadoPorCodigo(102);

        System.out.println();
        conjunto.listarConvidados();
        System.out.println("Total de convidados: " + conjunto.contarConvidados());
    }
}

