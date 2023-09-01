package dao.impl;

import config.JdbcConfig;
import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import entities.Expense;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ExpenseDaoImplH2 implements ExpenseDao {

    private final Connection connection;

    public ExpenseDaoImplH2() {
        this.connection = JdbcConfig.getDBConnection();
    }

    @Override
    public void insert(ExpenseDto expenseDto) {

        String CREAR_SCHEMA = "CREATE SCHEMA IF NOT EXISTS NOMBRE_DEL_ESQUEMA";
        String ELIMINAR_SCHEMA = "DROP SCHEMA NOMBRE_DEL_ESQUEMA";
        String getAll = "SELECT * FROM EXPENSE_TRACKING.EXPENSES";

        String INSERT = "INSERT INTO EXPENSE_TRACKING.expenses (expense_name, cost_of_spending, " +
                "date_time_expense, expense_category, expense_description) VALUES (?, ?, ?, ?, ?)";
        try {
            Expense newExpense = new Expense();
            newExpense.setExpenseName(expenseDto.getExpenseName());
            newExpense.setCostOfSpending(expenseDto.getCostOfSpending());
            newExpense.setDateTimeExpense(expenseDto.getDateTimeExpense());
            newExpense.setExpenseCategory(expenseDto.getExpenseCategory());
            newExpense.setExpenseDescription(expenseDto.getExpenseDescription());

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, newExpense.getExpenseName());
            preparedStatement.setDouble(2, newExpense.getCostOfSpending());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(newExpense.getDateTimeExpense()));
            preparedStatement.setString(4, newExpense.getExpenseCategory());
            preparedStatement.setString(5, newExpense.getExpenseDescription());
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExpenseDto> getAll() {
        String getAllExpenses = "SELECT * FROM EXPENSE_TRACKING.EXPENSES";
        List<ExpenseDto> expenseDtos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllExpenses);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                ExpenseDto expenseDto = new ExpenseDto();

                int expense_id = resultSet.getInt("expense_id");
                String expense_name = resultSet.getString("expense_name");
                double cost_of_spending = resultSet.getDouble("cost_of_spending");
                Timestamp date_time_expense = resultSet.getTimestamp("date_time_expense");
                String expense_category = resultSet.getString("expense_category");
                String expense_description = resultSet.getString("expense_description");

                LocalDateTime dateTimeExpense = date_time_expense.toLocalDateTime();

                expenseDto.setExpense_id(expense_id);
                expenseDto.setExpenseName(expense_name);
                expenseDto.setCostOfSpending(cost_of_spending);
                expenseDto.setDateTimeExpense(dateTimeExpense);
                expenseDto.setExpenseCategory(expense_category);
                expenseDto.setExpenseDescription(expense_description);

                expenseDtos.add(expenseDto);
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expenseDtos;
    }
}
