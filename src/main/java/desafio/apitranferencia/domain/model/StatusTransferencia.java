package desafio.apitranferencia.domain.model;

public enum StatusTransferencia {

    AGENDADO("Agendado"),
    CONCLUIDA("Concluída");

    private final String label;

    StatusTransferencia(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
