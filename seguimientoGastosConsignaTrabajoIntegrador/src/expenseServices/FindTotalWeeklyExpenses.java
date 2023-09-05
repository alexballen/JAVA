package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.FindTotalWeeklyExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindTotalWeeklyExpenses implements FindTotalWeeklyExpensesInt {
    @Override
    public void totalWeeklyExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        //MOSTRAR LISTA DE GASTOS SEMANALES CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por semana con su total¡");

        int year = 0;
        do {
            System.out.println("Ingresa uno de los siguientes años diponibles: 2021 - 2022 - 2023");
            if (scanner.hasNextInt()){
                year = scanner.nextInt();
                if (year != 2021 && year != 2022 && year != 2023){
                    System.out.println("El años ingresado no esta habilitado¡");
                }
            } else {
                System.out.println("Debes ingresar un numero entero");
                scanner.nextLine(); // Consumir la línea en blanco
                year = 0; // Reiniciar la variable
            }
        } while (!(year == 2021 || year == 2022 || year == 2023));

        System.out.println("Año ingresado correctamente¡¡");

        int month;
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

        System.out.println("Mes ingresado correctamente¡¡");

        //ESCOGER LA SEMANA DEL MES SELECCIONADO PARA FILTRAR

        //PREGUNTAR QUE SEMANA SE DESEA FILTRAR

        int rangeWeekStart = 0;
        int rangeWeekEnd = 0;
        int weekValue = 0;
        if (numberDaysMonths == 28) {
            do {
                System.out.println("Escoge una opcion de semana a filtrar: ");
                System.out.println("Opción 1 - Semana 1");
                System.out.println("Opción 2 - Semana 2");
                System.out.println("Opción 3 - Semana 3");
                System.out.println("Opción 4 - Semana 4");

                if (scanner.hasNextInt()) {
                    weekValue = scanner.nextInt();

                    if (weekValue >= 1 && weekValue <= 4) {
                        switch (weekValue) {
                            case 1:
                                rangeWeekStart = 1;
                                rangeWeekEnd = 7;
                                break;
                            case 2:
                                rangeWeekStart = 8;
                                rangeWeekEnd = 14;
                                break;
                            case 3:
                                rangeWeekStart = 15;
                                rangeWeekEnd = 21;
                                break;
                            case 4:
                                rangeWeekStart = 22;
                                rangeWeekEnd = 28;
                                break;
                        }
                    } else {
                        System.out.println("Debes ingresar una semana válida (del 1 al 4).");
                    }

                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    weekValue = 0; // Reiniciar la variable
                }
            } while (weekValue < 1 || weekValue > 4);
        } else if (numberDaysMonths == 30) {
            do {
                System.out.println("Escoge una opcion de semana a filtrar: ");
                System.out.println("Opción 1 - Semana 1");
                System.out.println("Opción 2 - Semana 2");
                System.out.println("Opción 3 - Semana 3");
                System.out.println("Opción 4 - Semana 4");
                System.out.println("Opción 5 - Semana 5");

                if (scanner.hasNextInt()){
                    weekValue = scanner.nextInt();

                    if (weekValue >=1 && weekValue <= 5){
                        switch (weekValue){
                            case 1:
                                rangeWeekStart = 1;
                                rangeWeekEnd = 7;
                                break;
                            case 2:
                                rangeWeekStart = 8;
                                rangeWeekEnd = 14;
                                break;
                            case 3:
                                rangeWeekStart = 15;
                                rangeWeekEnd = 21;
                                break;
                            case 4:
                                rangeWeekStart = 22;
                                rangeWeekEnd = 28;
                                break;
                            case 5:
                                rangeWeekStart = 29;
                                rangeWeekEnd = 30;
                        }
                    } else {
                        System.out.println("Debes ingresar una semana válida (del 1 al 5).");
                    }

                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    weekValue = 0; // Reiniciar la variable
                }
            } while (weekValue < 1 || weekValue > 5);
        } else  if (numberDaysMonths == 31) {
            do {
                System.out.println("Escoge una opcion de semana a filtrar: ");
                System.out.println("Opción 1 - Semana 1");
                System.out.println("Opción 2 - Semana 2");
                System.out.println("Opción 3 - Semana 3");
                System.out.println("Opción 4 - Semana 4");
                System.out.println("Opción 5 - Semana 5");

                if (scanner.hasNextInt()){
                    weekValue = scanner.nextInt();

                    if (weekValue >=1 && weekValue <= 5){
                        switch (weekValue){
                            case 1:
                                rangeWeekStart = 1;
                                rangeWeekEnd = 7;
                                break;
                            case 2:
                                rangeWeekStart = 8;
                                rangeWeekEnd = 14;
                                break;
                            case 3:
                                rangeWeekStart = 15;
                                rangeWeekEnd = 21;
                                break;
                            case 4:
                                rangeWeekStart = 22;
                                rangeWeekEnd = 28;
                                break;
                            case 5:
                                rangeWeekStart = 29;
                                rangeWeekEnd = 31;
                        }
                    } else {
                        System.out.println("Debes ingresar una semana válida (del 1 al 5).");
                    }
                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    weekValue = 0; // Reiniciar la variable
                }
            } while (weekValue < 1 || weekValue > 5);
        }

        //SE EJECUTA EL CODIGO QUE RELIZA EL FILTRADO

        LocalDate startDate = LocalDate.of(year, month, rangeWeekStart);
        LocalDate endDate = LocalDate.of(year, month, rangeWeekEnd);
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
        System.out.println("Total Gastos: " + totalCost);
    }
}
