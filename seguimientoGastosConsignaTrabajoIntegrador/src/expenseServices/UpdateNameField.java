package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.CurrentDateTimeInt;
import expenseServices.interfaces.ExpenseNameInt;
import expenseServices.interfaces.SearchExpenseDBInt;
import expenseServices.interfaces.UpdateNameFieldInt;

import java.util.Map;

public class UpdateNameField implements UpdateNameFieldInt {
    @Override
    public ExpenseDto updateName() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        ExpenseNameInt expenseNameInt = new ExpenseName();
        CurrentDateTimeInt currentDateTimeInt = new CurrentDateTime();

        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");

        if (foundRecord) {
            //CAMBIAR EL NOMBRE DE UN GASTO
            String expenseName = expenseNameInt.expenseName();
            expenseDto.setExpenseName(expenseName);
            System.out.println("Campo actualizado con exito¡");

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            expenseDto.setDateTimeExpense(currentDateTimeInt.currentDateTime());
        }
        return expenseDto;
    }
}
