package dao;

import dao.dto.ExpenseDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ExpenseDao {
    //CRUD

    //CREATE
    void insert (ExpenseDto expenseDto);

    //READ
    List<ExpenseDto> getAll();

    //UPDATE
    void updateAll (ExpenseDto expenseDto);
    void updateName (ExpenseDto expenseDto);
    void costUpdate (ExpenseDto expenseDto);
    void categoryUpdate (ExpenseDto expenseDto);
    void descriptionUpdate (ExpenseDto expenseDto);

    //DELETE
    void delete (ExpenseDto expenseDto);

    //SEARCH
    List<ExpenseDto> searchName (String name);
    List<ExpenseDto> searchCategory (String category);
    List<ExpenseDto> searchDescription (String description);

    //FILTERS STREAM-API
    List<ExpenseDto> filterExpensesOfTheDay ();
    Map<String, Object> filterExpensesForTheWeek (LocalDate startDate, LocalDate endDate);

}
