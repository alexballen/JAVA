package expenseServices;

import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.ExpenseUpdateInt;
import expenseServices.interfaces.SearchExpenseDBInt;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class ExpenseUpdate implements ExpenseUpdateInt {
    @Override
    public ExpenseDto expenseUpdateAll() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");
        Scanner scanner = (Scanner) result.get("Scanner");

        if (foundRecord){
             //INGRESAR EL NUEVO VALOR DEL NOMBRE DEL GASTO
            String expenseName;
            do {
                System.out.println("Ingresa el nuevo nombre del gasto: ");
                expenseName = scanner.nextLine().trim();

                if (expenseName.isEmpty()) {
                    System.out.println("El campo nombre no puede estar vacío. Por favor, ingresa un nombre válido.");
                } else if (expenseName.length() < 5) {
                    System.out.println("Debes ingresar un nombre de gasto con al menos 5 caracteres.");
                } else if (expenseName.length() >= 50) {
                    System.out.println("Debes ingresar un nombre de gasto con menos de 50 caracteres.");
                } else if (!expenseName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("El nombre del gasto debe contener solo letras y espacios.");
                }

            } while (expenseName.isEmpty() || expenseName.length() < 5 || expenseName.length() >= 50 || !expenseName.matches("^[a-zA-Z ]+$"));

            expenseDto.setExpenseName(expenseName);

            //INGRESAR EL NUEVO VALOR DEL COSTO DEL GASTO
            double costOfSpending = 0;
            boolean validInput = false;
            do {
                System.out.println("Ingresa el nuevo costo del gasto: ");
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

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            LocalDateTime currentDateTime  = LocalDateTime.now();
            expenseDto.setDateTimeExpense(currentDateTime);

            //SE DEBE SELECCIONAR EL NUEVO VALOR DE LA CATEGORIA
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

                // Verificar si la opcion seleccionada es un entero
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
                    scanner.nextLine(); //CONSUMIR LA LINEA EN BLANCO
                    categoryOption = 0; // Reiniciar la variable
                }
            } while (categoryOption < 1 || categoryOption > 10);

            //SE DEBE INGRESAR EL NUEVO VALOR DE LA DESCRIPCION
            String descriptionOfExpenses;
            do {
                System.out.println("Ingresa una nueva descripcion de tu gasto: ");
                descriptionOfExpenses = scanner.nextLine().trim();

                if (descriptionOfExpenses.isEmpty()) {
                    System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
                } else if (descriptionOfExpenses.length() < 5) {
                    System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
                } else if (descriptionOfExpenses.length() >= 70) {
                    System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
                }

            } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() > 70);

            expenseDto.setExpenseDescription(descriptionOfExpenses);
        }
        System.out.println("Datos ingresados exitosamente¡¡");

        return expenseDto;
    }
}
