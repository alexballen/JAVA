package controller;

import dao.ExpenseDao;
import dao.ExpenseSearchDao;
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
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();

//----------------------------------------------------------------------------------------------------

        /*System.out.println("Ingresar un nuevo gasto¡");*/

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

        /*System.out.println("Actualizar un gasto¡");

        //EDICION DE TODOS LOS CAMPOS DE UN GASTO
        //SE SOLICITA EL ID DEL GASTO A EDITAR, SI EXISTE PERMITE CONTINUAR CON EL INGRESO
        //DE LOS DEMAS CAMPOS, SI NO EXITE DEVUELVE UN MENSAJE QUE INDICA QUE NO SE HAYO EL ID EN LA DB.
        int expenseId;
        boolean foundRecord;
        do {
            System.out.println("Ingresa el ID del gasto que deseas actualizar: ");
            if (scanner.hasNextInt()){
                expenseId = scanner.nextInt();
                expenseDto.setExpense_id(expenseId);

                // Llamar al método updateAll para verificar si el registro existe
                foundRecord = expenseSearchDao.expenseSearch(expenseDto);
                if (!foundRecord) {
                    System.out.println("No existe el ID proporcionado, ingresa un ID valido.");
                    foundRecord = false;
                } else {
                    foundRecord = true;
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine();
                expenseId = 0;
                foundRecord = false;
            }
        } while (!foundRecord);

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
                            System.out.println("El nombre del gasto debe contener solo letras.");
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

                    //SE DEBE INGRESAR EL NUEVO VALOR DE LA DESCRIPCION
                    String descriptionOfExpenses;
                    do {
                        System.out.println("Ingresa una nueva descripcion de tu gasto: ");
                        descriptionOfExpenses = scanner.nextLine().trim();

                        if (descriptionOfExpenses.isEmpty()) {
                            System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
                        } else if (descriptionOfExpenses.length() < 5) {
                            System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
                        } else if (descriptionOfExpenses.length() >= 50) {
                            System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
                        }

                    } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);

                    expenseDto.setExpenseDescription(descriptionOfExpenses);
                    scanner.close();
                    expenseDao.updateAll(expenseDto);
                    System.out.println("Registro completo¡");
        }*/


//------------------------------------------------------------------------------------------------------

        //EDICION DE UN CAMPO ESPECIFICO DE UN GASTO
        /*System.out.println("Actualizar un campo de un gasto¡");

        int expenseId;
        boolean foundRecord;
        do {
            System.out.println("Ingresa el ID del gasto que deseas actualizar: ");
            if (scanner.hasNextInt()){
                expenseId = scanner.nextInt();
                expenseDto.setExpense_id(expenseId);

                // Llamar al método updateAll para verificar si el registro existe
                foundRecord = expenseSearchDao.expenseSearch(expenseDto);
                if (!foundRecord) {
                    System.out.println("No existe el ID proporcionado, ingresa un ID valido.");
                    foundRecord = false;
                } else {
                    foundRecord = true;
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine();
                expenseId = 0;
                foundRecord = false;
            }
        } while (!foundRecord);

        if (foundRecord) {
            int fieldOption;
            do {
                System.out.println("Selecciona una opcion para actualizar el campo: ");
                System.out.println("Opción 1 - Nombre Campo");
                System.out.println("Opción 2 - Costo Gasto");
                System.out.println("Opción 3 - Categoria Gasto");
                System.out.println("Opción 4 - Descripcion Gasto");

                // Verificar si la opcion seleccionada es un entero
                if (scanner.hasNextInt()){
                    fieldOption = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea en blanco
                    if (fieldOption >= 1 && fieldOption <= 4) {
                        switch (fieldOption) {
                            case 1:
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
                                        System.out.println("El nombre del gasto debe contener solo letras.");
                                    }

                                } while (expenseName.isEmpty() || expenseName.length() < 5 || expenseName.length() >= 50 || !expenseName.matches("^[a-zA-Z ]+$"));

                                //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
                                LocalDateTime currentDateTimeName  = LocalDateTime.now();
                                expenseDto.setDateTimeExpense(currentDateTimeName);

                                expenseDto.setExpenseName(expenseName);
                                expenseDao.updateName(expenseDto);
                                System.out.println("Campo actualizado con exito¡");
                                break;
                            case 2:
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
                                LocalDateTime currentDateTimeCost  = LocalDateTime.now();
                                expenseDto.setDateTimeExpense(currentDateTimeCost);

                                expenseDto.setCostOfSpending(costOfSpending);
                                expenseDao.costUpdate(expenseDto);
                                System.out.println("Campo actualizado con exito¡");
                                break;
                            case 3:
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

                                    // Verificar si la opcion seleccionada es un entero
                                    if (scanner.hasNextInt()) {
                                        categoryOption = scanner.nextInt();
                                        scanner.nextLine(); // Consumir la línea en blanco
                                        if (categoryOption >= 1 && categoryOption <= 10) {
                                            switch (categoryOption) {
                                                case 1:
                                                    expenseDto.setExpenseCategory("Alimentos y Bebidas");
                                                    categoryOptionString = "Alimentos y Bebidas";
                                                    break;
                                                case 2:
                                                    expenseDto.setExpenseCategory("Vivienda");
                                                    categoryOptionString = "Vivienda";
                                                    break;
                                                case 3:
                                                    expenseDto.setExpenseCategory("Transporte");
                                                    categoryOptionString = "Transporte";
                                                    break;
                                                case 4:
                                                    expenseDto.setExpenseCategory("Entretenimiento");
                                                    categoryOptionString = "Entretenimiento";
                                                    break;
                                                case 5:
                                                    expenseDto.setExpenseCategory("Salud");
                                                    categoryOptionString = "Salud";
                                                    break;
                                                case 6:
                                                    expenseDto.setExpenseCategory("Educación");
                                                    categoryOptionString = "Educación";
                                                    break;
                                                case 7:
                                                    expenseDto.setExpenseCategory("Ropa y Accesorios");
                                                    categoryOptionString = "Ropa y Accesorios";
                                                    break;
                                                case 8:
                                                    expenseDto.setExpenseCategory("Tecnología");
                                                    categoryOptionString = "Tecnología";
                                                    break;
                                                case 9:
                                                    expenseDto.setExpenseCategory("Viajes");
                                                    categoryOptionString = "Viajes";
                                                    break;
                                                case 10:
                                                    expenseDto.setExpenseCategory("Mascotas");
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

                                //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
                                LocalDateTime currentDateTimeCategory  = LocalDateTime.now();
                                expenseDto.setDateTimeExpense(currentDateTimeCategory);

                                expenseDto.setExpenseCategory(categoryOptionString);
                                expenseDao.categoryUpdate(expenseDto);
                                System.out.println("Campo actualizado con exito¡");
                                break;
                            case 4:
                                //SE DEBE INGRESAR EL NUEVO VALOR DE LA DESCRIPCION
                                String descriptionOfExpenses;
                                do {
                                    System.out.println("Ingresa una nueva descripcion de tu gasto: ");
                                    descriptionOfExpenses = scanner.nextLine().trim();

                                    if (descriptionOfExpenses.isEmpty()) {
                                        System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
                                    } else if (descriptionOfExpenses.length() < 5) {
                                        System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
                                    } else if (descriptionOfExpenses.length() >= 50) {
                                        System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
                                    }

                                } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);

                                //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
                                LocalDateTime currentDateTimeDescription  = LocalDateTime.now();
                                expenseDto.setDateTimeExpense(currentDateTimeDescription);

                                expenseDto.setExpenseDescription(descriptionOfExpenses);
                                expenseDao.descriptionUpdate(expenseDto);
                                System.out.println("Campo actualizado con exito¡");
                                break;
                        }
                    } else {
                        System.out.println("Debes ingresar una opción válida (del 1 al 4).");
                    }
                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    fieldOption = 0; // Reiniciar la variable
                }
            }while (fieldOption < 1 || fieldOption > 4);
        }*/

//----------------------------------------------------------------------------------------------------

        //BUSQUEDA DE GASTO POR PALABRA CONTENIDA EN EL TITULO
        /*String expenseName;
        do {
            System.out.println("Ingresa el nombre del gasto que deseas encontrar: ");
            expenseName = scanner.nextLine().trim();

            if (expenseName.isEmpty()) {
                System.out.println("El campo de busqueda nombre no puede estar vacío. Por favor, ingresa un nombre válido.");
            } else if (expenseName.length() < 5) {
                System.out.println("Debes ingresar un nombre de gasto con al menos 5 caracteres.");
            } else if (expenseName.length() >= 50) {
                System.out.println("Debes ingresar un nombre de gasto con menos de 50 caracteres.");
            } else if (!expenseName.matches("^[a-zA-Z ]+$")) {
                System.out.println("El nombre del gasto debe contener solo letras y espacios en blanco.");
            }

        } while (expenseName.isEmpty() || expenseName.length() < 5 || expenseName.length() >= 50 || !expenseName.matches("^[a-zA-Z ]+$"));

        List<ExpenseDto> filterByName = expenseDao.searchName(expenseName);
        for (ExpenseDto expense: filterByName) {
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }
        int dataFound = filterByName.size();

        if (dataFound > 0) {
            System.out.println("Busqueda exitosa¡");
        } else {
            System.out.println("No se encontro informacion relacionada¡");
        }
        scanner.close();*/

//------------------------------------------------------------------------------------------------------

        //BUSQUEDA POR CATEGORIA, SELECCIONAR OPCION PARA FILTRAR
        /*int categoryOption;
        String categoryOptionString = "";
        do {
            System.out.println("Busqueda por categoria, selecciona una opcion para filtrar: ");
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
                scanner.nextLine(); // Consumir la línea en blanco
                if (categoryOption >= 1 && categoryOption <= 10) {
                    switch (categoryOption) {
                        case 1:
                            expenseDto.setExpenseCategory("Alimentos y Bebidas");
                            categoryOptionString = "Alimentos y Bebidas";
                            break;
                        case 2:
                            expenseDto.setExpenseCategory("Vivienda");
                            categoryOptionString = "Vivienda";
                            break;
                        case 3:
                            expenseDto.setExpenseCategory("Transporte");
                            categoryOptionString = "Transporte";
                            break;
                        case 4:
                            expenseDto.setExpenseCategory("Entretenimiento");
                            categoryOptionString = "Entretenimiento";
                            break;
                        case 5:
                            expenseDto.setExpenseCategory("Salud");
                            categoryOptionString = "Salud";
                            break;
                        case 6:
                            expenseDto.setExpenseCategory("Educación");
                            categoryOptionString = "Educación";
                            break;
                        case 7:
                            expenseDto.setExpenseCategory("Ropa y Accesorios");
                            categoryOptionString = "Ropa y Accesorios";
                            break;
                        case 8:
                            expenseDto.setExpenseCategory("Tecnología");
                            categoryOptionString = "Tecnología";
                            break;
                        case 9:
                            expenseDto.setExpenseCategory("Viajes");
                            categoryOptionString = "Viajes";
                            break;
                        case 10:
                            expenseDto.setExpenseCategory("Mascotas");
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

        List<ExpenseDto> filterByCategory = expenseDao.searchCategory(categoryOptionString);
        for (ExpenseDto expense: filterByCategory){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }*/

//-------------------------------------------------------------------------------------------------------

        //BUSQUEDA DE GASTO POR PALABRA CONTENIDA EN LA DESCRIPCION
        /*String descriptionOfExpenses = "";
        do {
            System.out.println("Ingresa una palabra que creas que este en la descripcion para realizar tu busqueda: ");
            descriptionOfExpenses = scanner.nextLine().trim();

            if (descriptionOfExpenses.isEmpty()) {
                System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
            } else if (descriptionOfExpenses.length() < 5) {
                System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
            } else if (descriptionOfExpenses.length() >= 50) {
                System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
            }

        } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);

        List<ExpenseDto> filterByDescription = expenseDao.searchDescription(descriptionOfExpenses);
        for (ExpenseDto expense: filterByDescription){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }

        int dataFound = filterByDescription.size();

        if (dataFound > 0) {
            System.out.println("Busqueda exitosa¡");
        } else {
            System.out.println("No se encontro informacion relacionada¡");
        }
        scanner.close();*/

//------------------------------------------------------------------------------------------------------

        //MOSTRAR LISTA DE GASTOS DIARIO CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gasto por dia con su total¡");

        int year = 0;
        do {
            System.out.println("Ingresa uno de los siguientes años diponibles: 2021 - 2022 - 2023");
            if (scanner.hasNextInt()){
                year = scanner.nextInt();
                if (year != 2021 || year != 2022 || year != 2023){
                    System.out.println("El años ingresado no esta habilitado¡");
                }
            } else {
                System.out.println("Debes ingresar un numero entero");
                scanner.nextLine(); // Consumir la línea en blanco
                year = 0; // Reiniciar la variable
            }
        } while (!(year == 2021 || year == 2022 || year == 2023));

       /* int month;
        int numberDaysMonths = 0;
        String valueMonth = "";
        do {
            System.out.println("Ingresa el numero del mes: ");
            if (scanner.hasNextInt()){
                month = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea en blanco
                if (month >= 1 && month <= 12) {
                    switch (month){
                        case 1:
                            valueMonth = "enero";
                            break;
                        case 2:
                            valueMonth = "febrero";
                            break;
                        case 3:
                            valueMonth = "marzo";
                            break;
                        case 4:
                            valueMonth = "abril";
                            break;
                        case 5:
                            valueMonth = "mayo";
                            break;
                        case 6:
                            valueMonth = "junio";
                            break;
                        case 7:
                            valueMonth = "julio";
                            break;
                        case 8:
                            valueMonth = "agosto";
                            break;
                        case 9:
                            valueMonth = "septiembre";
                            break;
                        case 10:
                            valueMonth = "octubre";
                            break;
                        case 11:
                            valueMonth = "noviembre";
                            break;
                        case 12:
                            valueMonth = "diciembre";
                    }
                    numberDaysMonths = switch (valueMonth){
                        case "enero", "marzo", "mayo", "julio", "agosto", "octubre", "diciembre" -> 31;
                        case "abril", "junio", "septiembre", "noviembre" -> 30;
                        case "febrero" -> 28;
                        default -> 0;
                    };
                } else {
                    System.out.println("Debes ingresar un mes válido (del 1 al 12).");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                month = 0; // Reiniciar la variable
            }
        } while (month < 1 || month > 12);

        int day;
        do {
            System.out.println("Ingresa el dia: ");
            day = scanner.nextInt();
            if(scanner.hasNextInt()){
                if (numberDaysMonths == 28){
                    if (day >= 1 && day <= 28){

                    }
                }
            }
        } while (day >= 1 && day <= 28);

        LocalDate startDate = LocalDate.of(year, month, day);
        LocalDate endDate = LocalDate.of(year, month, day);
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
        /*expenseDto.setExpense_id(9);
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
        /*List<ExpenseDto> filterByDescription = expenseDao.searchDescription("servesa");
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
        /*List<ExpenseDto> expenseDtos =expenseDao.getAll();
        for(ExpenseDto expense: expenseDtos){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }*/








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
