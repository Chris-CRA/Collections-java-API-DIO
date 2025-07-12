package OperacoesComSet.PesquisaComSet;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        Contato novoContato = new Contato(nome, numero);
        if (contatoSet.contains(novoContato)) {
            System.out.println("Contato com nome '" + nome + "' já existe. Use atualização.");
        } else {
            contatoSet.add(novoContato);
            System.out.println("Contato adicionado: " + novoContato);
        }
    }

    public void exibirContatos() {
        if (contatoSet.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            System.out.println("📒 Contatos na agenda:");
            contatoSet.forEach(System.out::println);
        }
    }

    public Set<Contato> pesquisaPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet) {
            if (c.getNome().toLowerCase().startsWith(nome.toLowerCase())) {
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        for (Contato c : contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(novoNumero);
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Alice", 123456789);
        agenda.adicionarContato("Bob", 987654321);
        agenda.adicionarContato("Charlie", 555555555);
        agenda.adicionarContato("alice", 111222333); // teste duplicidade (case insensitive)

        System.out.println("\n--- Exibindo contatos:");
        agenda.exibirContatos();

        System.out.println("\n--- Pesquisa por nome 'Al':");
        Set<Contato> resultado = agenda.pesquisaPorNome("Al");
        resultado.forEach(System.out::println);

        System.out.println("\n--- Atualizando número de 'Alice':");
        Contato contatoAtualizado = agenda.atualizarNumeroContato("Alice", 111111111);
        if (contatoAtualizado != null) {
            System.out.println("Contato atualizado com sucesso: " + contatoAtualizado);
        } else {
            System.out.println("Contato não encontrado.");
        }

        System.out.println("\n--- Contatos após atualização:");
        agenda.exibirContatos();
    }
}



