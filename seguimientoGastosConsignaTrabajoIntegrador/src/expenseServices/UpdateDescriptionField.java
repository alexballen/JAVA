package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.*;

import java.util.Map;
public class UpdateDescriptionField implements UpdateDescriptionFieldInt {
    @Override
    public ExpenseDto updateDescription() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        ExpenseDescriptionInt expenseDescriptionInt = new ExpenseDescription();
        CurrentDateTimeInt currentDateTimeInt = new CurrentDateTime();

        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");

        if (foundRecord) {
            String descriptionOfExpenses = expenseDescriptionInt.expenseDescription();
            expenseDto.setExpenseDescription(descriptionOfExpenses);

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            expenseDto.setDateTimeExpense(currentDateTimeInt.currentDateTime());
        }
        return expenseDto;
    }
}
