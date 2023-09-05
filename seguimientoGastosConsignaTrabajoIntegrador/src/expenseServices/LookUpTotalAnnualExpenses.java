package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.LookUpTotalAnnualExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LookUpTotalAnnualExpenses implements LookUpTotalAnnualExpensesInt {
    @Override
    public void totalAnnualExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        //MOSTRAR LISTA DE GASTOS ANUALES CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por año con su total¡");

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

        //SE EJECUTA EL CODIGO QUE RELIZA EL FILTRADO

        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
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
