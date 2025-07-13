package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {

    private Map<String, Integer> contatos;

    public AgendaContatos() {
        this.contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        if (nome == null || telefone == null) {
            throw new IllegalArgumentException("Nome e telefone não podem ser nulos.");
        }

        boolean substituido = contatos.containsKey(nome);
        contatos.put(nome, telefone);
        
        if (substituido) {
            System.out.println("🔄 Contato atualizado: " + nome);
        } else {
            System.out.println("✅ Contato adicionado: " + nome);
        }
    }

    public void removerContato(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }

        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            System.out.println("🗑 Contato removido: " + nome);
        } else {
            System.out.println("⚠ Contato não encontrado: " + nome);
        }
    }

    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("📭 Agenda de contatos está vazia.");
        } else {
            System.out.println("📒 Lista de contatos:");
            contatos.forEach((nome, telefone) ->
                System.out.println("👤 Nome: " + nome + " | 📞 Telefone: " + telefone)
            );
        }
    }

    public Integer pesquisarPorNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }

        return contatos.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agenda = new AgendaContatos();

        agenda.adicionarContato("Alice", 123456789);
        agenda.adicionarContato("Bob", 987654321);
        agenda.adicionarContato("Carol", 555555555);

       
        System.out.println("\n📋 Contatos na agenda:");
        agenda.exibirContatos();

        
        System.out.println("\n🔍 Pesquisa por nome:");
        String nomeBuscado = "Alice";
        Integer telefone = agenda.pesquisarPorNome(nomeBuscado);
        if (telefone != null) {
            System.out.println("📲 Telefone de " + nomeBuscado + ": " + telefone);
        } else {
            System.out.println("❌ Contato não encontrado: " + nomeBuscado);
        }

        
        System.out.println("\n🧹 Removendo contato:");
        agenda.removerContato("Bob");

        
        System.out.println("\n📋 Contatos atualizados:");
        agenda.exibirContatos();
    }
}

