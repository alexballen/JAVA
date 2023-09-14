package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.EnterMonthInt;
import expenseServices.interfaces.EnterYearInt;
import expenseServices.interfaces.ExpensePrintingInt;
import expenseServices.interfaces.FindTotalMonthlyExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
public class FindTotalMonthlyExpenses implements FindTotalMonthlyExpensesInt {
    @Override
    public void totalMonthlyExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        EnterYearInt enterYearInt = new EnterYear();
        EnterMonthInt enterMonthInt = new EnterMonth();
        ExpensePrintingInt expensePrintingInt = new ExpensePrinting();

        //MOSTRAR LISTA DE GASTOS MENSUALES CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por mes con su total¡");

        //INGRESAR AÑO
        int year = enterYearInt.enterYear();

        //INGRESAR MES
        Map<String, Object> result2 = enterMonthInt.enterMonth();
        int month = (int) result2.get("month");
        int numberDaysMonths = (int) result2.get("numberDaysMonths");

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

        //SE DEFINEN DOS OBJETOS DE TIPO LOCALDATE, CON VALORES DE INICIO Y FIN PARA BUSQUEDA POR RANGO DE FECHA
        LocalDate startDate = LocalDate.of(year, month, rangeWeekStart);
        LocalDate endDate = LocalDate.of(year, month, rangeWeekEnd);

        //SE OBTIENEN DEL MAP EL RESULTADO DEL FILTRADO
        Map<String, Object> result = expenseDao.filterExpensesInDateRange(startDate, endDate);

        //OBTIENE LA LISTA DE EXPENSES Y EL TOTALCOST DEL MAPA
        @SuppressWarnings("unchecked")
        List<ExpenseDto> filterExpenses = (List<ExpenseDto>) result.get("expenses");
        double totalCost = (double) result.get("totalCost");

        //IMPRIMIR GASTO Y COSTO TOTAL
        expensePrintingInt.expensePrinting(filterExpenses, totalCost);
    }
}
