package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoLivros {
    private List<Livro> livros;

    public CatalogoLivros() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        validarString(autor, "autor");
        return livros.stream()
                     .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                     .collect(Collectors.toList());
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        validarString(titulo, "título");
        return livros.stream()
                     .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                     .collect(Collectors.toList());
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicio, int anoFim) {
        if (anoInicio > anoFim) {
            throw new IllegalArgumentException("Ano inicial não pode ser maior que o ano final.");
        }
        return livros.stream()
                     .filter(livro -> livro.getAnoPublicacao() >= anoInicio && livro.getAnoPublicacao() <= anoFim)
                     .collect(Collectors.toList());
    }

    private void validarString(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo " + campo + " não pode ser nulo ou vazio.");
        }
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();
        catalogo.adicionarLivro("Dom Casmurro", "Machado de Assis", 1899);
        catalogo.adicionarLivro("O Guarani", "José de Alencar", 1857);
        catalogo.adicionarLivro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881);

        exibirResultado("Pesquisa por autor 'Machado de Assis'", catalogo.pesquisarPorAutor("Machado de Assis"));
        exibirResultado("Pesquisa por título 'O Guarani'", catalogo.pesquisarPorTitulo("O Guarani"));
        exibirResultado("Pesquisa por intervalo de anos (1800-1900)", catalogo.pesquisarPorIntervaloAnos(1800, 1900));
    }

    private static void exibirResultado(String descricao, List<Livro> resultados) {
        System.out.println("\n" + descricao + ":");
        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            resultados.forEach(System.out::println);
        }
    }
}
