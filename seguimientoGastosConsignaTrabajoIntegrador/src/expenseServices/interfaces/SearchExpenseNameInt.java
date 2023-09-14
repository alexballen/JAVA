package expenseServices.interfaces;

import exceptions.ExceptionHandling;

@FunctionalInterface
public interface SearchExpenseNameInt {
    void searchExpenseByName () throws ExceptionHandling;
}
