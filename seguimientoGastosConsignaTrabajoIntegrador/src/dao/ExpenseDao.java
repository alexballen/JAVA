package dao;

import dao.dto.ExpenseDto;

import java.util.List;

public interface ExpenseDao {
    //CRUD

    //CREATE
    void insert (ExpenseDto expenseDto);

    //READ
    List<ExpenseDto> getAll();

    //UPDATE

    //DELETE

}
