public class Paciente {

    protected String nombre;
    protected String documento;
    protected double costoConsulta;

    public Paciente(String nombre, String documento, double costoConsulta) {
        this.nombre = nombre;
        this.documento = documento;
        this.costoConsulta = costoConsulta;
    }

    public String getDocumento() {
        return documento;
    }

    public double calcularCostoFinal() {
        return costoConsulta;
    }

    public double aplicarDescuento(double porcentaje) {
        double descuento = costoConsulta * porcentaje;
        return costoConsulta - descuento;
    }

    public double aplicarRecargo(double porcentaje) {
        double recargo = costoConsulta * porcentaje;
        return costoConsulta + recargo;
    }

    public boolean esConsultaCostosa() {
        return costoConsulta > 300000;
    }

    public void mostrarDatos(double costoFinal) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Costo base: " + costoConsulta);
        System.out.println("Costo final: " + costoFinal);
    }
}
