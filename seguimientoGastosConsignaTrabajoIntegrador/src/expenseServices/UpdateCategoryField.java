package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.CurrentDateTimeInt;
import expenseServices.interfaces.ExpenseCategoryInt;
import expenseServices.interfaces.SearchExpenseDBInt;
import expenseServices.interfaces.UpdateCategoryFieldInt;

import java.util.Map;
public class UpdateCategoryField implements UpdateCategoryFieldInt {
    @Override
    public ExpenseDto updateCategory() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        ExpenseCategoryInt expenseCategoryInt = new ExpenseCategory();
        CurrentDateTimeInt currentDateTimeInt = new CurrentDateTime();

        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");

        if (foundRecord) {
            //SE DEBE SELECCIONAR EL NUEVO VALOR DE LA CATEGORIA
            String categoryOption = expenseCategoryInt.expenseCategory();
            expenseDto.setExpenseCategory(categoryOption);
            System.out.println("Campo actualizado con exito¡");

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            expenseDto.setDateTimeExpense(currentDateTimeInt.currentDateTime());
        }
        return expenseDto;
    }
}
