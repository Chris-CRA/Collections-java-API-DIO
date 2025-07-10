package list.OperacoesBasicas;
import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    //atributo

    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        this.tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefaParaRemover = tarefa;
                break;
            }
        }
        if (tarefaParaRemover != null) {
            tarefaList.remove(tarefaParaRemover);
        } else {
            System.out.println("Tarefa não encontrada: " + descricao);
        }
        
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    public void obterDescricoesTarefas() {
        if (tarefaList.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Tarefas cadastradas:");
            for (Tarefa tarefa : tarefaList) {
                System.out.println("- " + tarefa.getDescricao());
            }
        }
    }

    public static void main(String[] args) {
        ListaTarefa lista = new ListaTarefa();
        lista.adicionarTarefa("Estudar Java");
        lista.adicionarTarefa("Fazer exercícios de programação");
        lista.adicionarTarefa("Aulas DIO");
        lista.adicionarTarefa("Assistir Aulas QAzando");
        lista.obterDescricoesTarefas();
        
        System.out.println("Número total de tarefas: " + lista.obterNumeroTotalTarefas());
        
        lista.removerTarefa("Estudar Java");
        lista.obterDescricoesTarefas();
        
        System.out.println("Número total de tarefas: " + lista.obterNumeroTotalTarefas());
    }
}
