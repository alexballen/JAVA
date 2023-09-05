package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.LookUpTotalDailyExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LookUpTotalDailyExpenses implements LookUpTotalDailyExpensesInt {
    @Override
    public void totalDailyExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        Scanner scanner = new Scanner(System.in);

        //MOSTRAR LISTA DE GASTOS DIARIO CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por dia con su total¡");

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

        int day = 0;
        do {
            System.out.println("Ingresa el dia: ");
            if(scanner.hasNextInt()){
                day = scanner.nextInt();
                if (day >= 1 && day <= numberDaysMonths){
                    System.out.println("Dia ingresado correctamente¡¡");
                } else {
                    System.out.println("Debes ingresar un dia válido (del 1 al " + numberDaysMonths + ").");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                day = 0; // Reiniciar la variable
            }
        } while (day < 1 || day > numberDaysMonths);

        //SE EJECUTA EL CODIGO QUE RELIZA EL FILTRADO

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
        System.out.println("Total Cost: " + totalCost);
    }
}
