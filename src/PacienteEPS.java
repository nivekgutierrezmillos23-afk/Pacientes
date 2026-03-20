public class PacienteEPS extends Paciente {

    private String nombreEPS;

    public PacienteEPS(String nombre, String documento, double costo, String eps) {
        super(nombre, documento, costo);
        this.nombreEPS = eps;
    }

    public double calcularCostoFinal() {

        double porcentaje;

        if (costoConsulta >= 300000) {
            porcentaje = 0.25;
        }
        else if (costoConsulta >= 80000) {
            porcentaje = 0.20;
        }
        else {
            porcentaje = 0.30;
        }

        double copago = costoConsulta * porcentaje;

        if (esConsultaCostosa()) {
            copago = copago - (copago * 0.05);
        }

        return copago;
    }

    public String toString() {
        return "EPS: " + nombreEPS;
    }
}