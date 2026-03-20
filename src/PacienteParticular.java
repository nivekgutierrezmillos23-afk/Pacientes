public class PacienteParticular extends Paciente {

    public PacienteParticular(String nombre, String documento, double costo) {
        super(nombre, documento, costo);
    }

    public double calcularCostoFinal() {

        double total = costoConsulta;

        if (costoConsulta >= 400000) {
            total = aplicarDescuento(0.15);
        }
        else if (costoConsulta >= 200000) {
            total = aplicarDescuento(0.10);
        }
        else if (costoConsulta < 50000) {
            total = aplicarRecargo(0.05);
        }

        return total;
    }
}