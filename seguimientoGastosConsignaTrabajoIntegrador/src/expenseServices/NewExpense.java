package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.*;
public class NewExpense implements NewExpenseInt {
    @Override
    public ExpenseDto addName() {
        ExpenseDto expenseDto = new ExpenseDto();
        ExpenseNameInt expenseNameInt = new ExpenseName();
        ExpenseCostInt expenseCostInt = new ExpenseCost();
        CurrentDateTimeInt currentDateTimeInt = new CurrentDateTime();
        ExpenseCategoryInt expenseCategoryInt = new ExpenseCategory();
        ExpenseDescriptionInt expenseDescriptionInt = new ExpenseDescription();

        System.out.println("Ingresar un nuevo gasto¡");

        //INGRESAR NOMBRE DEL GASTO
        expenseDto.setExpenseName(expenseNameInt.expenseName());

        //INGRESAR EL VALOR DEL COSTO
        expenseDto.setCostOfSpending(expenseCostInt.expenseCost());

        //SE INGRESA AUTOMATICAMENTE LA FECHA Y HORA EN CADA NUEVO GASTO INGRESADO
        expenseDto.setDateTimeExpense(currentDateTimeInt.currentDateTime());

        //SE INGRESA LA CATEGORIA SELECCIONANDO UNA OPCION
        expenseDto.setExpenseCategory(expenseCategoryInt.expenseCategory());

        //INGRESAR UNA DESCRIPCION DEL GASTO
        expenseDto.setExpenseDescription(expenseDescriptionInt.expenseDescription());

        System.out.println("Datos ingresados exitosamente¡¡");

        return expenseDto;
    }
}
