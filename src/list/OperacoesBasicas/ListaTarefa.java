package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private List<Tarefa> tarefas;

    public ListaTarefa() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
        System.out.println("✅ Tarefa adicionada: " + descricao);
    }

    public void removerTarefa(String descricao) {
        boolean removido = tarefas.removeIf(t -> t.getDescricao().equalsIgnoreCase(descricao));
        if (removido) {
            System.out.println("🗑️ Tarefa removida: " + descricao);
        } else {
            System.out.println("⚠️ Tarefa não encontrada: " + descricao);
        }
    }

    public int obterNumeroTotalTarefas() {
        return tarefas.size();
    }

    public void listarTarefas() {
        System.out.println("\n📋 Lista de Tarefas:");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        ListaTarefa lista = new ListaTarefa();

        lista.adicionarTarefa("Estudar Java");
        lista.adicionarTarefa("Fazer exercícios de programação");
        lista.adicionarTarefa("Aulas DIO");
        lista.adicionarTarefa("Assistir Aulas QAzando");

        lista.listarTarefas();
        System.out.println("\n📌 Total de tarefas: " + lista.obterNumeroTotalTarefas());

        lista.removerTarefa("Estudar Java");

        lista.listarTarefas();
        System.out.println("\n📌 Total de tarefas atual: " + lista.obterNumeroTotalTarefas());
    }
}

