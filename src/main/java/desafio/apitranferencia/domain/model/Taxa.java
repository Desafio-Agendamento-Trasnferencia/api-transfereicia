package desafio.apitranferencia.domain.model;

public enum Taxa {

    DIA_0(0, 0, 3.00, 0.025),
    DIA_1_A_10(1, 10, 12.00, 0.0),
    DIA_11_A_20(11, 20, 0.00, 0.082),
    DIA_21_A_30(21, 30, 0.00, 0.069),
    DIA_31_A_40(31, 40, 0.00, 0.047),
    DIA_41_A_50(41, 50, 0.00, 0.017);

    private final int diaInicio;
    private final int diaFim;
    private final double valorFixo;
    private final double taxaPercentual;

    Taxa(int diaInicio, int diaFim, double valorFixo, double taxaPercentual) {
        this.diaInicio = diaInicio;
        this.diaFim = diaFim;
        this.valorFixo = valorFixo;
        this.taxaPercentual = taxaPercentual;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public int getDiaFim() {
        return diaFim;
    }

    public double getValorFixo() {
        return valorFixo;
    }

    public double getTaxaPercentual() {
        return taxaPercentual;
    }

    public static Taxa getByDias(int dias) {
        for (Taxa taxa : values()) {
            if (dias >= taxa.getDiaInicio() && dias <= taxa.getDiaFim()) {
                return taxa;
            }
        }
        throw new IllegalArgumentException("Nenhuma taxa configurada para " + dias + " dias");
    }
}
