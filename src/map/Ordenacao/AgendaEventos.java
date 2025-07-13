package map.Ordenacao;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private final Map<LocalDate, Evento> eventos;

    public AgendaEventos() {
        this.eventos = new TreeMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        if (data == null || nome == null || atracao == null) {
            throw new IllegalArgumentException("Data, nome e atração não podem ser nulos.");
        }

        Evento evento = new Evento(nome.trim(), atracao.trim());
        eventos.put(data, evento);
        System.out.printf("✅ Evento adicionado: %s (%s)%n", nome, data);
    }

    public void exibirAgenda() {
        if (eventos.isEmpty()) {
            System.out.println("📅 Nenhum evento agendado.");
            return;
        }

        System.out.println("\n📅 Agenda de Eventos:");
        eventos.forEach((data, evento) -> 
            System.out.printf("📌 %s - %s%n", data, evento)
        );
    }

    public void exibirProximoEvento() {
        LocalDate hoje = LocalDate.now();

        for (Map.Entry<LocalDate, Evento> entry : eventos.entrySet()) {
            if (!entry.getKey().isBefore(hoje)) {
                System.out.printf("\n⏭️ Próximo evento: %s em %s%n", entry.getValue(), entry.getKey());
                return;
            }
        }

        System.out.println("\n🚫 Não há próximos eventos a partir de hoje.");
    }

    public static void main(String[] args) {
        AgendaEventos agenda = new AgendaEventos();

        agenda.adicionarEvento(LocalDate.of(2026, 1, 14),
            "Palestra IA - Entendendo como ela pode ser sua aliada no trabalho",
            "Rodrigo Aciolly - Especialista em IA");

        agenda.adicionarEvento(LocalDate.of(2025, 10, 10),
            "Espetáculo Teatral",
            "Peça - O Último Ato");

        agenda.adicionarEvento(LocalDate.of(2025, 12, 25),
            "Show de Natal",
            "Simone");

        agenda.exibirAgenda();
        agenda.exibirProximoEvento();
    }
}

