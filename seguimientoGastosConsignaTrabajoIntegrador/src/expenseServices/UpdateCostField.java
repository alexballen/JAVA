package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.CurrentDateTimeInt;
import expenseServices.interfaces.ExpenseCostInt;
import expenseServices.interfaces.SearchExpenseDBInt;
import expenseServices.interfaces.UpdateCostFieldInt;

import java.util.Map;
public class UpdateCostField implements UpdateCostFieldInt {
    @Override
    public ExpenseDto updateCost() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        ExpenseCostInt expenseCostInt = new ExpenseCost();
        CurrentDateTimeInt currentDateTimeInt = new CurrentDateTime();

        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");

        if (foundRecord) {
            double costOfExpense = expenseCostInt.expenseCost();
            expenseDto.setCostOfSpending(costOfExpense);
            System.out.println("Campo actualizado con exito¡");

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            expenseDto.setDateTimeExpense(currentDateTimeInt.currentDateTime());
        }
        return expenseDto;
    }
}
