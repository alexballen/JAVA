package controller;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.of(2023,9,1,10,30);

        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();

        //----------------------------------------------------------------------------------------------------

        System.out.println("Ingresar un nuevo gasto¡");

        Scanner scanner = new Scanner(System.in);

        /*//INGRESAR NOMBRE DEL GASTO
        String expenseName;
        do {
            System.out.println("Ingresa el nombre del gasto: ");
            expenseName = scanner.nextLine().trim();
            if (expenseName.isEmpty()) {
                System.out.println("El nombre del gasto no puede estar vacío. Por favor, ingresa un nombre válido.");
            }
            if (expenseName.length() < 4){
                System.out.println("Debes ingresar en nombre de gasto minimo 4 caracteres.");
            }
            if (!expenseName.matches("^[a-zA-Z]+$")) {
                System.out.println("El nombre del gasto debe contener solo letras.");
            }
            expenseDto.setExpenseName(expenseName);
        } while (expenseName.isEmpty() || expenseName.length() < 4 || !expenseName.matches("^[a-zA-Z]+$"));

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

            // Verificar si el siguiente token es un entero
            if (scanner.hasNextInt()) {
                categoryOption = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea en blanco
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
            }
            if (descriptionOfExpenses.length() > 4 && descriptionOfExpenses.length() < 20){
                System.out.println("Debes ingresar en descripcion de gasto minimo 5 caracteres, maximo 19 caracteres.");
            }
            expenseDto.setExpenseDescription(descriptionOfExpenses);

        } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() > 4 && descriptionOfExpenses.length() < 20);

        expenseDao.insert(expenseDto);
        System.out.println("Gracias por ingresar todos los datos¡¡");*/

        //------------------------------------------------------------------------------------------------------

        System.out.println("Actualizar un gasto¡");

        //SE DEBE INGRESAR EL ID DEL GASTO PARA EDITARLO
        int expenseId;
        do {
            System.out.println("Ingresa el Id del gasto que deseas actualizar: ");
            if (scanner.hasNextInt()){
                expenseId = scanner.nextInt();
                scanner.nextLine();

                expenseDto.setExpense_id(expenseId);
                expenseDto.setExpenseName("Nuevo registro");
                expenseDto.setCostOfSpending(6500.0);
                expenseDto.setExpenseDescription("Se compra alimento para la consentida de la casa¡");
                expenseDto.setDateTimeExpense(dateTime);
                expenseDao.updateAll(expenseDto);
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine();
                expenseId = 0;
            }
        } while (expenseId == 0);

        //CREATE
        /*expenseDto.setExpenseName("Ensalada de frutas¡");
        expenseDto.setCostOfSpending(43800.0);
        expenseDto.setDateTimeExpense(dateTime);
        expenseDto.setExpenseCategory("Antojo de mi mama");
        expenseDto.setExpenseDescription("Compartir con mi mama y mi hermano¡");

        expenseDao.insert(expenseDto);*/

        //UPDATE
        /*expenseDto.setExpense_id(1);
        expenseDto.setExpenseDescription("Se compra alimento para la consentida de la casa¡");
        expenseDto.setDateTimeExpense(dateTime);
        expenseDao.descriptionUpdate(expenseDto);*/

        //DELETE
        /*expenseDto.setExpense_id(2);
        expenseDao.delete(expenseDto);*/

        //SEARCHS BY NAME
        /*List<ExpenseDto> filterByName = expenseDao.searchName("Hamburguesa");
        for (ExpenseDto expense: filterByName){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }*/
        //SEARCH BY CATEGORY
        /*List<ExpenseDto> filterByCategory = expenseDao.searchCategory("ANTojo");
        for (ExpenseDto expense: filterByCategory){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }*/
        //SEARCH BY DESCRIPTION
        /*List<ExpenseDto> filterByDescription = expenseDao.searchDescription("se");
        for (ExpenseDto expense: filterByDescription){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }*/

        //FILTERS STREAM-API
        //FILTER BY DAY
        /*List<ExpenseDto> filterByDayCurrent = expenseDao.filterExpensesOfTheDay();
        for (ExpenseDto expense: filterByDayCurrent){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }*/
        //FILTER BY RANGE
        /*LocalDate startDate = LocalDate.of(2023, 9, 1);
        LocalDate endDate = LocalDate.of(2023, 9, 20);
        Map<String, Object> result = expenseDao.filterExpensesInDateRange(startDate, endDate);

        // Obtiene la lista de expenses y el totalCost del mapa
        @SuppressWarnings("unchecked")
        List<ExpenseDto> filterExpenses = (List<ExpenseDto>) result.get("expenses");
        double totalCost = (double) result.get("totalCost");

        for (ExpenseDto expense: filterExpenses){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }
        System.out.println("Total Cost: " + totalCost);*/

        //READ
        List<ExpenseDto> expenseDtos =expenseDao.getAll();
        for(ExpenseDto expense: expenseDtos){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }








        /*String createTableQuery = "CREATE TABLE IF NOT EXISTS usuarios (id INT PRIMARY KEY, nombre VARCHAR(50))";
        String insertQuery = "INSERT INTO usuarios VALUES (7, 'John Doe'), (8, 'Jane Smith')";*/

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
