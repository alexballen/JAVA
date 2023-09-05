package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.SearchByDateRangeExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearchByDateRangeExpenses implements SearchByDateRangeExpensesInt {
    @Override
    public void searchByDateRange() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        //MOSTRAR LISTA DE GASTOS EN UN RANGO DE FEHAS CON LA SUMA DE SUS GASTOS

        String regexDateFormat = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";

        System.out.println("Busqueda por rango de fecha¡");

        String dateRange1;
        String dateRange2;
        do {
            System.out.println("Ingresa el primer rango de fecha en este formato: DIA/MES/AÑO = 12/04/2023");
            dateRange1 = scanner.next();
            if (dateRange1.isEmpty()){
                System.out.println("No puede estar vacio el campo de fecha¡");
            } else if (!dateRange1.matches(regexDateFormat)) {
                System.out.println("Ingresa un formato de fecha correcto: DIA/MES/AÑO - 12/04/2023");
            }
        } while (dateRange1.isEmpty() || !dateRange1.matches(regexDateFormat));

        do {
            System.out.println("Ingresa el segundo rango de fecha en este formato: DIA/MES/AÑO = 08/09/2023");
            dateRange2 = scanner.next();
            if (dateRange2.isEmpty()){
                System.out.println("No puede estar vacio el campo de fecha¡");
            } else if (!dateRange2.matches(regexDateFormat)) {
                System.out.println("Ingresa un formato de fecha correcto: DIA/MES/AÑO - 08/09/2023");
            }
        } while (dateRange2.isEmpty() || !dateRange2.matches(regexDateFormat));

        String[] parts1 = dateRange1.split("/");
        String[] parts2 = dateRange2.split("/");

        // Verificar si se dividieron en 3 partes
        String valueMonth = "";
        String valueMonth1 = "";
        int numberDaysMonths = 0;
        int numberDaysMonths1 = 0;
        LocalDate startDate = null;
        LocalDate endDate = null;

        if (parts1.length == 3 && parts2.length == 3) {
            try {
                // Convertir las partes en enteros
                int day1 = Integer.parseInt(parts1[0]);
                int month1 = Integer.parseInt(parts1[1]);
                int year1 = Integer.parseInt(parts1[2]);

                int day2 = Integer.parseInt(parts2[0]);
                int month2 = Integer.parseInt(parts2[1]);
                int year2 = Integer.parseInt(parts2[2]);

                //
                if (month1 >= 1 && month1 <= 12) {
                    switch (month1) {
                        case 1 -> valueMonth = "enero";
                        case 2 -> valueMonth = "febrero";
                        case 3 -> valueMonth = "marzo";
                        case 4 -> valueMonth = "abril";
                        case 5 -> valueMonth = "mayo";
                        case 6 -> valueMonth = "junio";
                        case 7 -> valueMonth = "julio";
                        case 8 -> valueMonth = "agosto";
                        case 9 -> valueMonth = "septiembre";
                        case 10 -> valueMonth = "octubre";
                        case 11 -> valueMonth = "noviembre";
                        case 12 -> valueMonth = "diciembre";
                    }
                    numberDaysMonths = switch (valueMonth){
                        case "enero", "marzo", "mayo", "julio", "agosto", "octubre", "diciembre" -> 31;
                        case "abril", "junio", "septiembre", "noviembre" -> 30;
                        case "febrero" -> 28;
                        default -> 0;
                    };
                    if (numberDaysMonths == 28) {
                        if (day1 <= numberDaysMonths) {
                            startDate = LocalDate.of(year1, month1, day1);
                        } else {
                            System.out.println("El mes " + valueMonth + " no tiene " + day1 + " dias.");
                        }
                    } else if (numberDaysMonths == 30){
                        if (day1 <= numberDaysMonths) {
                            startDate = LocalDate.of(year1, month1, day1);
                        } else {
                            System.out.println("El mes de " + valueMonth + " no tiene " + day1 + " dias.");
                        }
                    } else {
                        if (day1 <= numberDaysMonths) {
                            startDate = LocalDate.of(year1, month1, day1);
                        } else {
                            System.out.println("El mes de " + month1 + " no tiene " + day1 + " dias.");
                        }
                    }
                }

                if (month2 >= 1 && month2 <= 12){
                    switch (month2) {
                        case 1 -> valueMonth1 = "enero";
                        case 2 -> valueMonth1 = "febrero";
                        case 3 -> valueMonth1 = "marzo";
                        case 4 -> valueMonth1 = "abril";
                        case 5 -> valueMonth1 = "mayo";
                        case 6 -> valueMonth1 = "junio";
                        case 7 -> valueMonth1 = "julio";
                        case 8 -> valueMonth1 = "agosto";
                        case 9 -> valueMonth1 = "septiembre";
                        case 10 -> valueMonth1 = "octubre";
                        case 11 -> valueMonth1 = "noviembre";
                        case 12 -> valueMonth1 = "diciembre";
                    }
                    numberDaysMonths1 = switch (valueMonth1){
                        case "enero", "marzo", "mayo", "julio", "agosto", "octubre", "diciembre" -> 31;
                        case "abril", "junio", "septiembre", "noviembre" -> 30;
                        case "febrero" -> 28;
                        default -> 0;
                    };

                    if (numberDaysMonths1 == 28) {
                        if (day2 <= numberDaysMonths1) {
                            endDate = LocalDate.of(year2, month2, day2);
                        } else {
                            System.out.println("El mes de " + valueMonth1 + " no tiene " + day2 + " dias.");
                        }
                    } else if (numberDaysMonths1 == 30){
                        if (day2 <= numberDaysMonths1) {
                            endDate = LocalDate.of(year2, month2, day2);
                        } else {
                            System.out.println("El mes de " + valueMonth1 + " no tiene " + day2 + " dias.");
                        }
                    } else {
                        if (day2 <= numberDaysMonths1) {
                            endDate = LocalDate.of(year2, month2, day2);
                        } else {
                            System.out.println("El mes de " + valueMonth1 + " no tiene " + day2 + " dias.");
                        }
                    }
                } else {
                    System.out.println("Debes ingresar un mes válido (del 1 al 12).");
                }

                //SE EJECUTA EL CODIGO QUE RELIZA EL FILTRADO
                if (startDate != null && endDate != null) {
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
                } else {
                    System.out.println("Las fechas no son válidas.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error al convertir las fechas en números.");
            }
        } else {
            System.out.println("Formato de fecha incorrecto. Debe ser DIA/MES/AÑO.");
        }
    }
}
