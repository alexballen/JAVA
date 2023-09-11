package expenseServices;

import expenseServices.interfaces.ExpenseCategoryInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;
public class ExpenseCategory implements ExpenseCategoryInt {
    @Override
    public String expenseCategory() {
        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        //SE DEBE SELECCIONAR EL NUEVO VALOR DE LA CATEGORIA
        int categoryOption;
        String categoryOptionString = "";
        do {
            System.out.println("Ingrese una de las siguientes categorías: ");
            System.out.println("Opción 1 - Alimentos y Bebidas");
            System.out.println("Opción 2 - Vivienda");
            System.out.println("Opción 3 - Transporte");
            System.out.println("Opción 4 - Entretenimiento");
            System.out.println("Opción 5 - Salud");
            System.out.println("Opción 6 - Educación");
            System.out.println("Opción 7 - Ropa y Accesorios");
            System.out.println("Opción 8 - Tecnología");
            System.out.println("Opción 9 - Viajes");
            System.out.println("Opción 10 - Mascotas");

            if (scanner.hasNextInt()) {
                categoryOption = scanner.nextInt();
                if (categoryOption >= 1 && categoryOption <= 10) {
                    switch (categoryOption) {
                        case 1:
                            categoryOptionString = "Alimentos y Bebidas";
                            break;
                        case 2:
                            categoryOptionString = "Vivienda";
                            break;
                        case 3:
                            categoryOptionString = "Transporte";
                            break;
                        case 4:
                            categoryOptionString = "Entretenimiento";
                            break;
                        case 5:
                            categoryOptionString = "Salud";
                            break;
                        case 6:
                            categoryOptionString = "Educación";
                            break;
                        case 7:
                            categoryOptionString = "Ropa y Accesorios";
                            break;
                        case 8:
                            categoryOptionString = "Tecnología";
                            break;
                        case 9:
                            categoryOptionString = "Viajes";
                            break;
                        case 10:
                            categoryOptionString = "Mascotas";
                            break;
                    }
                } else {
                    System.out.println("Debes ingresar una opción válida (del 1 al 10).");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                categoryOption = 0; // Reiniciar la variable
            }

        } while (categoryOption < 1 || categoryOption > 10);

        return categoryOptionString;
    }
}
