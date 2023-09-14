package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.EnterYearInt;
import expenseServices.interfaces.ExpensePrintingInt;
import expenseServices.interfaces.LookUpTotalAnnualExpensesInt;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
public class LookUpTotalAnnualExpenses implements LookUpTotalAnnualExpensesInt {
    @Override
    public void totalAnnualExpenses() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        EnterYearInt enterYearInt = new EnterYear();
        ExpensePrintingInt expensePrintingInt = new ExpensePrinting();

        //MOSTRAR LISTA DE GASTOS ANUALES CON LA SUMA DE SUS GASTOS

        System.out.println("Filtrar gastos por año con su total¡");

        //INGRESAR DIA
        int year = enterYearInt.enterYear();

        //SE DEFINEN DOS OBJETOS DE TIPO LOCALDATE, CON VALORES DE INICIO Y FIN PARA BUSQUEDA POR RANGO DE FECHA
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);

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
