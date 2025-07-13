package set.Ordenacao;

import java.util.*;

class Produto implements Comparable<Produto> {
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
        return String.format("Produto{id=%d, nome='%s', preço=R$ %.2f, quantidade=%d}",
                id, nome, preco, quantidade);
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

class ComparatorPorPreco implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}

public class CadastroProdutos {

    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long id, String nome, double preco, int quantidade) {
        Produto novoProduto = new Produto(nome, preco, id, quantidade);
        if (produtoSet.contains(novoProduto)) {
            System.out.println("⚠ Produto com ID " + id + " já existe. Ignorando.");
        } else {
            produtoSet.add(novoProduto);
            System.out.println("✅ Produto adicionado: " + novoProduto);
        }
    }

    public Set<Produto> exibirProdutosPorNome() {
        return new TreeSet<>(produtoSet);
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> ordenadoPorPreco = new TreeSet<>(new ComparatorPorPreco());
        ordenadoPorPreco.addAll(produtoSet);
        return ordenadoPorPreco;
    }

    public void removerProdutoPorId(long id) {
        Produto paraRemover = null;
        for (Produto p : produtoSet) {
            if (p.getId() == id) {
                paraRemover = p;
                break;
            }
        }
        if (paraRemover != null) {
            produtoSet.remove(paraRemover);
            System.out.println("🗑 Produto removido: " + paraRemover);
        } else {
            System.out.println("❌ Produto com ID " + id + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastro = new CadastroProdutos();

        // Adicionando produtos
        cadastro.adicionarProduto(1, "Notebook", 4500.00, 5);
        cadastro.adicionarProduto(2, "Mouse", 80.00, 20);
        cadastro.adicionarProduto(3, "Teclado", 150.00, 10);
        cadastro.adicionarProduto(4, "Monitor", 899.99, 7);
        cadastro.adicionarProduto(1, "Notebook Duplicado", 4500.00, 5); // Teste duplicidade

        // Exibir por nome
        System.out.println("\n📋 Produtos ordenados por NOME:");
        cadastro.exibirProdutosPorNome().forEach(System.out::println);

        // Exibir por preço
        System.out.println("\n💰 Produtos ordenados por PREÇO:");
        cadastro.exibirProdutosPorPreco().forEach(System.out::println);

        // Remover produto
        System.out.println("\n🔄 Removendo produto com ID 2:");
        cadastro.removerProdutoPorId(2);

        // Mostrar produtos atualizados
        System.out.println("\n📋 Lista atualizada:");
        cadastro.exibirProdutosPorNome().forEach(System.out::println);
    }
}

