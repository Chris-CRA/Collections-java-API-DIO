package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private final Map<Long, Produto> produtos;

    public EstoqueProdutos() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Long id, String nome, double preco, int quantidade) {
        produtos.put(id, new Produto(nome, preco, quantidade));
        System.out.printf("✅ Produto adicionado: ID %d | %s%n", id, nome);
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("📦 Estoque vazio.");
            return;
        }

        System.out.println("📋 Produtos em estoque:");
        produtos.forEach((id, produto) ->
                System.out.printf("ID: %d | %s%n", id, produto));
    }

    public double calcularValorTotalEstoque() {
        return produtos.values().stream()
                .mapToDouble(p -> p.getPreco() * p.getQuantidade())
                .sum();
    }

    public Produto obterProdutoMaisCaro() {
        return produtos.values().stream()
                .max((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                .orElse(null);
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();

        
        estoque.adicionarProduto(1L, "Notebook", 3500.00, 4);
        estoque.adicionarProduto(2L, "Mouse", 80.00, 10);
        estoque.adicionarProduto(3L, "Monitor", 1200.00, 3);

        
        System.out.println("\n📦 Estoque atual:");
        estoque.exibirProdutos();

        
        double totalEstoque = estoque.calcularValorTotalEstoque();
        System.out.printf("%n💰 Valor total do estoque: R$ %.2f%n", totalEstoque);

       
        Produto maisCaro = estoque.obterProdutoMaisCaro();
        System.out.printf("🔝 Produto mais caro: %s%n", maisCaro != null ? maisCaro : "Nenhum produto encontrado.");
    }
}
