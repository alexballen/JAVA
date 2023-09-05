package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.FindTotalMonthlyExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindTotalMonthlyExpenses implements FindTotalMonthlyExpensesInt {
    @Override
    public void totalMonthlyExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        //MOSTRAR LISTA DE GASTOS MENSUALES CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por mes con su total¡");

        int year = 0;
        boolean yearValid = false;
        do {
            System.out.println("Ingresa uno de los siguientes años diponibles: 2021 - 2022 - 2023");
            if (scanner.hasNextInt()){
                year = scanner.nextInt();
                if (year == 2021 || year == 2022 || year == 2023){
                    yearValid = true;
                } else {
                    System.out.println("El años ingresado no esta habilitado¡");
                }
            } else {
                System.out.println("Debes ingresar un numero entero");
                scanner.nextLine(); // Consumir la línea en blanco
            }
        } while (!yearValid);

        System.out.println("Año ingresado correctamente¡¡");

        int month;
        int numberDaysMonths = 0;
        String valueMonth = "";
        do {
            System.out.println("Ingresa el numero del mes: ");
            scanner.nextLine(); // Consumir la línea en blanco
            if (scanner.hasNextInt()){
                month = scanner.nextInt();
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
                month = 0; // Reiniciar la variable
            }
        } while (month < 1 || month > 12);

        System.out.println("Mes ingresado correctamente¡¡");

        //ESCOGER LA SEMANA DEL MES SELECCIONADO PARA FILTRAR

        //PREGUNTAR QUE SEMANA SE DESEA FILTRAR

        int rangeWeekStart = 1;
        int rangeWeekEnd = 0;
        if (numberDaysMonths == 28) {
           rangeWeekEnd = 28;
        } else if (numberDaysMonths == 30) {
           rangeWeekEnd = 30;
        } else {
           rangeWeekEnd = 31;
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
