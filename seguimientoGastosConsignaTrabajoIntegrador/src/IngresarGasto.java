
import java.util.Scanner;

public class IngresarGasto extends Gastos{

    private int contadorNuevoGasto = 0;

    public IngresarGasto(int contadorNuevoGasto){
        this.contadorNuevoGasto = contadorNuevoGasto;
    }

    public int getContadorNuevoGasto() {
        return contadorNuevoGasto;
    }

    public void setContadorNuevoGasto(int contadorNuevoGasto) {
        this.contadorNuevoGasto = contadorNuevoGasto;
    }

    public IngresarGasto() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del gasto:");
        String nombreGasto = scanner.nextLine();

        System.out.println("Ingrese el año:");
        int year = scanner.nextInt();

        System.out.println("Ingrese el mes:");
        int month = scanner.nextInt();

        System.out.println("Ingrese el día:");
        int day = scanner.nextInt();

        System.out.println("Ingrese la hora:");
        int hour = scanner.nextInt();

        System.out.println("Ingrese los minutos:");
        int minute = scanner.nextInt();

        System.out.println("Ingrese el monto del gasto:");
        int montoGasto = scanner.nextInt();

        scanner.nextLine(); // Limpia el búfer de nueva línea

        System.out.println("Ingrese la categoría del gasto:");
        String categoria = scanner.nextLine();

        System.out.println("Ingrese la descripción del gasto:");
        String descripcion = scanner.nextLine();

        setContadorNuevoGasto(++contadorNuevoGasto);
        setNombreGasto(nombreGasto);
        setFechaHoraGasto(year, month, day,hour,minute);
        setMontoGasto(montoGasto);
        setCategoria(categoria);
        setDescripcion(descripcion);
    }

}
