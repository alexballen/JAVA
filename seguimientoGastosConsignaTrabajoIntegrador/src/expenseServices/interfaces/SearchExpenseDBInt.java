package expenseServices.interfaces;

import java.util.Map;

@FunctionalInterface
public interface SearchExpenseDBInt {
    Map<String, Object> searchExpense ();
}
