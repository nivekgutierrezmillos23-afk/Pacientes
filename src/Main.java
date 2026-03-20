import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Paciente> lista = new ArrayList<>();

        int opcion;

        do {

            System.out.println("   ⭐ SISTEMA CLINICO ⭐   ");
            System.out.println("1. Registrar paciente particular");
            System.out.println("2. Registrar paciente de eps");
            System.out.println("3. Registrar paciente con vip");
            System.out.println("4. Buscar paciente");
            System.out.println("5. Mostrar todos");
            System.out.println("6. Mostrar por tipo");
            System.out.println("7. Calcular costo");
            System.out.println("8. Consultas costosas");
            System.out.println("9. Paciente que mas pago");
            System.out.println("10. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Nombre:");
                    String n = sc.nextLine();

                    System.out.println("Documento:");
                    String d = sc.nextLine();

                    System.out.println("Costo:");
                    double c = sc.nextDouble();

                    lista.add(new PacienteParticular(n, d, c));
                    break;

                case 2:
                    System.out.println("Nombre:");
                    n = sc.nextLine();

                    System.out.println("Documento:");
                    d = sc.nextLine();

                    System.out.println("Costo:");
                    c = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("EPS:");
                    String eps = sc.nextLine();

                    lista.add(new PacienteEPS(n, d, c, eps));
                    break;

                case 3:
                    System.out.println("Nombre:");
                    n = sc.nextLine();

                    System.out.println("Documento:");
                    d = sc.nextLine();

                    System.out.println("Costo:");
                    c = sc.nextDouble();

                    System.out.println("Años:");
                    int a = sc.nextInt();

                    lista.add(new PacienteVIP(n, d, c, a));
                    break;

                case 4:
                    System.out.println("Documento:");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (Paciente p : lista) {
                        if (p.getDocumento().equals(buscar)) {
                            p.mostrarDatos(p.calcularCostoFinal());
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Paciente no encontrado");
                    }
                    break;

                case 5:
                    for (Paciente p : lista) {
                        p.mostrarDatos(p.calcularCostoFinal());
                    }
                    break;

                case 6:
                    System.out.println("1.Particular 2.EPS 3.VIP");
                    int tipo = sc.nextInt();

                    for (Paciente p : lista) {

                        if (tipo == 1 && p instanceof PacienteParticular) {
                            p.mostrarDatos(p.calcularCostoFinal());
                        }
                        else if (tipo == 2 && p instanceof PacienteEPS) {
                            p.mostrarDatos(p.calcularCostoFinal());
                        }
                        else if (tipo == 3 && p instanceof PacienteVIP) {
                            p.mostrarDatos(p.calcularCostoFinal());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Documento:");
                    buscar = sc.nextLine();

                    for (Paciente p : lista) {
                        if (p.getDocumento().equals(buscar)) {
                            System.out.println("Costo final: " + p.calcularCostoFinal());
                        }
                    }
                    break;

                case 8:
                    for (Paciente p : lista) {
                        if (p.esConsultaCostosa()) {
                            p.mostrarDatos(p.calcularCostoFinal());
                        }
                    }
                    break;

                case 9:

                    double mayor = 0;
                    Paciente mejor = null;

                    for (Paciente p : lista) {
                        double total = p.calcularCostoFinal();

                        if (total > mayor) {
                            mayor = total;
                            mejor = p;
                        }
                    }

                    if (mejor != null) {
                        mejor.mostrarDatos(mayor);
                    }

                    break;

            }

        } while (opcion != 10);
    }
}