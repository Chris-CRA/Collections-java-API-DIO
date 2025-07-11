package Ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> pessoas;

    public OrdenacaoPessoa() {
        this.pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> ordenadas = new ArrayList<>(pessoas);
        ordenadas.sort(Comparator.naturalOrder());
        return ordenadas;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> ordenadas = new ArrayList<>(pessoas);
        ordenadas.sort(Comparator.comparing(Pessoa::getAltura));
        return ordenadas;
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacao = new OrdenacaoPessoa();

        ordenacao.adicionarPessoa("Alice", 30, 1.65);
        ordenacao.adicionarPessoa("Bob", 25, 1.80);
        ordenacao.adicionarPessoa("Charlie", 35, 1.75);
        ordenacao.adicionarPessoa("Diana", 28, 1.60);

        System.out.println("📌 Pessoas ordenadas por idade:");
        ordenacao.ordenarPorIdade().forEach(System.out::println);

        System.out.println("\n📏 Pessoas ordenadas por altura:");
        ordenacao.ordenarPorAltura().forEach(System.out::println);
    }
}

