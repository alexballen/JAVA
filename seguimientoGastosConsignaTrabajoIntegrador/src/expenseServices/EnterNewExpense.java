package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.NewExpense;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EnterNewExpense implements NewExpense {
    @Override
    public ExpenseDto addName() {
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar un nuevo gasto¡");

        //INGRESAR NOMBRE DEL GASTO
        String expenseName;
        do {
            System.out.println("Ingresa el nombre del gasto: ");
            expenseName = scanner.nextLine().trim();
            if (expenseName.isEmpty()) {
                System.out.println("El nombre del gasto no puede estar vacío. Por favor, ingresa un nombre válido.");
            } else if (expenseName.length() < 4){
                System.out.println("Debes ingresar en nombre de gasto minimo 4 caracteres.");
            } else if (!expenseName.matches("^[a-zA-Z ]+$")) {
                System.out.println("El nombre del gasto debe contener solo letras y espacios.");
            }

            expenseDto.setExpenseName(expenseName);
        } while (expenseName.isEmpty() || expenseName.length() < 4 || !expenseName.matches("^[a-zA-Z ]+$"));


        //INGRESAR EL VALOR DEL COSTO
        double costOfSpending = 0;
        boolean validInput = false;
        do {
            System.out.println("Ingresa el costo del gasto: ");
            try {
                costOfSpending = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es un número válido. Por favor, ingresa un número.");
            }

            if (validInput) {
                expenseDto.setCostOfSpending(costOfSpending);
            }
        } while (!validInput);

        //SE INGRESA AUTOMATICAMENTE LA FECHA Y HORA EN CADA NUEVO GASTO INGRESADO
        LocalDateTime currentDateTime  = LocalDateTime.now();
        expenseDto.setDateTimeExpense(currentDateTime);

        //SE INGRESA LA CATEGORIA SELECCIONANDO UNA OPCION
        int categoryOption;
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

            // VERIFICAR SI LA OPCION SELECCIONADA ES UN ENTERO
            if (scanner.hasNextInt()) {
                categoryOption = scanner.nextInt();
                scanner.nextLine(); //CONSUMIR LA LINEA EN BLANCO
                if (categoryOption >= 1 && categoryOption <= 10) {
                    switch (categoryOption) {
                        case 1:
                            expenseDto.setExpenseCategory("Alimentos y Bebidas");
                            break;
                        case 2:
                            expenseDto.setExpenseCategory("Vivienda");
                            break;
                        case 3:
                            expenseDto.setExpenseCategory("Transporte");
                            break;
                        case 4:
                            expenseDto.setExpenseCategory("Entretenimiento");
                            break;
                        case 5:
                            expenseDto.setExpenseCategory("Salud");
                            break;
                        case 6:
                            expenseDto.setExpenseCategory("Educación");
                            break;
                        case 7:
                            expenseDto.setExpenseCategory("Ropa y Accesorios");
                            break;
                        case 8:
                            expenseDto.setExpenseCategory("Tecnología");
                            break;
                        case 9:
                            expenseDto.setExpenseCategory("Viajes");
                            break;
                        case 10:
                            expenseDto.setExpenseCategory("Mascotas");
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

        //INGRESAR UNA DESCRIPCION DEL GASTO
        String descriptionOfExpenses;
        do {
            System.out.println("Ingresa una descripcion de tu gasto: ");
            descriptionOfExpenses = scanner.nextLine().trim();
            if (descriptionOfExpenses.isEmpty()){
                System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
            } else if (descriptionOfExpenses.length() < 5){
                System.out.println("Debes ingresar en descripcion de gasto minimo 4 caracteres.");
            } else if (descriptionOfExpenses.length() >= 70) {
                System.out.println("Debes ingresar en descripcion de gasto maximo 70 caracteres.");
            }
            expenseDto.setExpenseDescription(descriptionOfExpenses);

        } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() > 70);

        System.out.println("Datos ingresados exitosamente¡¡");

        return expenseDto;
    }
}
