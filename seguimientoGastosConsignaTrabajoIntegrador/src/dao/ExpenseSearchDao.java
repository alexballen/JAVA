package dao;

import dao.dto.ExpenseDto;
@FunctionalInterface
public interface ExpenseSearchDao {
    boolean expenseSearch (ExpenseDto expenseDto);
}
