public class PacienteVIP extends Paciente {

    private int añosFidelidad;

    public PacienteVIP(String nombre, String documento, double costo, int anios) {
        super(nombre, documento, costo);
        this.añosFidelidad = anios;
    }

    public double calcularCostoFinal() {

        double total = costoConsulta;

        if (añosFidelidad >= 10) {
            total = aplicarDescuento(0.40);
        }
        else if (añosFidelidad >= 5) {
            total = aplicarDescuento(0.30);
        }
        else {
            total = aplicarDescuento(0.20);
        }

        if (total > 300000) {
            total = 300000;
        }

        return total;
    }
}
