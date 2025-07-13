package set.Ordenacao;

import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;
    private long id;
    private int quantidade;

    public Produto(String nome, double preco, long id, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Produto p) {
        return this.nome.compareToIgnoreCase(p.getNome());
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return String.format("Produto{id=%d, nome='%s', preço=R$ %.2f, quantidade=%d}", id, nome, preco, quantidade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

