package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
public class FindTotalWeeklyExpenses implements FindTotalWeeklyExpensesInt {
    @Override
    public void totalWeeklyExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        EnterYearInt enterYearInt = new EnterYear();
        EnterMonthInt enterMonthInt = new EnterMonth();
        ChooseWeekInt chooseWeekInt = new ChooseWeek();
        ExpensePrintingInt expensePrintingInt = new ExpensePrinting();

        //MOSTRAR LISTA DE GASTOS SEMANALES CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por semana con su total¡");

        //INGRESAR AÑO
        int year = enterYearInt.enterYear();

        //INGRESAR MES
        Map<String, Object> result2 = enterMonthInt.enterMonth();
        int month = (int) result2.get("month");
        int numberDaysMonths = (int) result2.get("numberDaysMonths");

        //SE OBTIENE LA SEMANA DEL MES QUE SE DESEA FILTRAR
        Map<String, Object> result3 = chooseWeekInt.chooseWeek(numberDaysMonths);
        int rangeWeekStart = (int) result3.get("rangeWeekStart");
        int rangeWeekEnd = (int) result3.get("rangeWeekEnd");

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
