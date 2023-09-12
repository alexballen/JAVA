package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.*;

import java.util.Map;
public class ExpenseUpdate implements ExpenseUpdateInt {
    @Override
    public ExpenseDto expenseUpdateAll() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        ExpenseNameInt expenseNameInt = new ExpenseName();
        ExpenseCostInt expenseCostInt = new ExpenseCost();
        CurrentDateTimeInt currentDateTimeInt = new CurrentDateTime();
        ExpenseCategoryInt expenseCategoryInt = new ExpenseCategory();
        ExpenseDescriptionInt expenseDescriptionInt = new ExpenseDescription();

        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");

        if (foundRecord) {
            //INGRESAR EL NUEVO VALOR DEL NOMBRE DEL GASTO
            expenseDto.setExpenseName(expenseNameInt.expenseName());

            //INGRESAR EL NUEVO VALOR DEL COSTO DEL GASTO
            expenseDto.setCostOfSpending(expenseCostInt.expenseCost());

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            expenseDto.setDateTimeExpense(currentDateTimeInt.currentDateTime());

            //SE DEBE SELECCIONAR EL NUEVO VALOR DE LA CATEGORIA
            expenseDto.setExpenseCategory(expenseCategoryInt.expenseCategory());

            //SE DEBE INGRESAR EL NUEVO VALOR DE LA DESCRIPCION
            expenseDto.setExpenseDescription(expenseDescriptionInt.expenseDescription());

            System.out.println("Gasto actualizado exitosamente¡¡");
        }
        return expenseDto;
    }
}
