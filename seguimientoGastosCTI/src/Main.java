import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String createTableQuery = "CREATE TABLE IF NOT EXISTS usuarios (id INT PRIMARY KEY, nombre VARCHAR(50))";
        String insertQuery = "INSERT INTO usuarios VALUES (7, 'John Doe'), (8, 'Jane Smith')";

        ConexionDB.conectarDB(createTableQuery,insertQuery);

        /*boolean salir = false;

        Scanner scanner = new Scanner(System.in);

        while (!salir){
            System.out.println("Opcion 1 Crear un nuevo gasto¡");
            System.out.println("Opcion 2 Salir¡");
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    IngresarGasto ingresarGasto = new IngresarGasto();
                    System.out.println("Informacion de gastos: ");
                    System.out.println("Identificador gasto: " + ingresarGasto.getContadorNuevoGasto());
                    System.out.println("Nombre: " + ingresarGasto.getNombreGasto() +
                            "\nMonto: " + ingresarGasto.getMontoGasto() +
                            "\nFecha y Hora: " + ingresarGasto.getFechaHoraGasto() +
                            "\nCategoría: " + ingresarGasto.getCategoria() +
                            "\nDescripción: " + ingresarGasto.getDescripcion());
                    break;
                case 2:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestra aplicacion¡");
                    break;
                default:
                    System.out.println("No ingreso una opcion correcta¡");
                    break;
            }
        }*/

    }
}
