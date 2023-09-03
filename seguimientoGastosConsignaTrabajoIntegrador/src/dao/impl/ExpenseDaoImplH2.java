package dao.impl;

import config.JdbcConfig;
import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import entities.Expense;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

        List<Expense> expenses = new ArrayList<>();
        List<ExpenseDto> expenseDtos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAllExpenses);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Expense expense = new Expense();

                int expense_id = resultSet.getInt("expense_id");
                String expense_name = resultSet.getString("expense_name");
                double cost_of_spending = resultSet.getDouble("cost_of_spending");
                Timestamp date_time_expense = resultSet.getTimestamp("date_time_expense");
                String expense_category = resultSet.getString("expense_category");
                String expense_description = resultSet.getString("expense_description");

                LocalDateTime dateTimeExpense = date_time_expense.toLocalDateTime();

                expense.setExpense_id(expense_id);
                expense.setExpenseName(expense_name);
                expense.setCostOfSpending(cost_of_spending);
                expense.setDateTimeExpense(dateTimeExpense);
                expense.setExpenseCategory(expense_category);
                expense.setExpenseDescription(expense_description);

                expenses.add(expense);
            }
            for (Expense expense: expenses){
                ExpenseDto expenseDto = new ExpenseDto(expense.getExpense_id(),expense.getExpenseName(),expense.getCostOfSpending(),
                        expense.getDateTimeExpense(),expense.getExpenseCategory(),expense.getExpenseDescription());
                expenseDtos.add(expenseDto);
            }

            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return expenseDtos;
    }

    @Override
    public void updateAll (ExpenseDto expenseDto) {
        String findExpenses = "SELECT * FROM EXPENSE_TRACKING.EXPENSES WHERE expense_id = ?";
        String update = "UPDATE EXPENSE_TRACKING.EXPENSES SET expense_name = ?, " +
                "cost_of_spending = ?, date_time_expense = ?, expense_category = ?, " +
                "expense_description = ? WHERE expense_id = ?";

        try {
            // Verificar si el registro con el expense_id existe en la base de datos
            PreparedStatement selectStatement = connection.prepareStatement(findExpenses);
            selectStatement.setInt(1, expenseDto.getExpense_id());
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()){
                Expense newExpense = new Expense();
                newExpense.setExpense_id(expenseDto.getExpense_id());
                newExpense.setExpenseName(expenseDto.getExpenseName());
                newExpense.setCostOfSpending(expenseDto.getCostOfSpending());
                newExpense.setDateTimeExpense(expenseDto.getDateTimeExpense());
                newExpense.setExpenseCategory(expenseDto.getExpenseCategory());
                newExpense.setExpenseCategory(expenseDto.getExpenseDescription());

                PreparedStatement preparedStatement = connection.prepareStatement(update);
                preparedStatement.setString(1, newExpense.getExpenseName());
                preparedStatement.setDouble(2, newExpense.getCostOfSpending());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(newExpense.getDateTimeExpense()));
                preparedStatement.setString(4, newExpense.getExpenseCategory());
                preparedStatement.setString(5, newExpense.getExpenseDescription());
                preparedStatement.setInt(6, newExpense.getExpense_id());
                preparedStatement.executeUpdate();

                preparedStatement.close();
            } else {
                System.out.println("No se encontró ningún registro con el ID proporcionado.");
            }
            selectStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateName (ExpenseDto expenseDto) {
        String update = "UPDATE EXPENSE_TRACKING.EXPENSES SET expense_name = ?, date_time_expense = ? WHERE expense_id = ?";

        try {
            Expense newExpense = new Expense();
            newExpense.setExpense_id(expenseDto.getExpense_id());
            newExpense.setExpenseName(expenseDto.getExpenseName());
            newExpense.setDateTimeExpense(expenseDto.getDateTimeExpense());


            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, newExpense.getExpenseName());
            preparedStatement.setTimestamp(2,Timestamp.valueOf(newExpense.getDateTimeExpense()));
            preparedStatement.setInt(3, newExpense.getExpense_id());
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void costUpdate (ExpenseDto expenseDto) {
        String update = "UPDATE EXPENSE_TRACKING.EXPENSES SET cost_of_spending = ?, date_time_expense = ? WHERE expense_id = ?";

        try {
            Expense newExpense = new Expense();
            newExpense.setExpense_id(expenseDto.getExpense_id());
            newExpense.setCostOfSpending(expenseDto.getCostOfSpending());
            newExpense.setDateTimeExpense(expenseDto.getDateTimeExpense());

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setDouble(1, newExpense.getCostOfSpending());
            preparedStatement.setTimestamp(2,Timestamp.valueOf(newExpense.getDateTimeExpense()));
            preparedStatement.setInt(3, newExpense.getExpense_id());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void categoryUpdate(ExpenseDto expenseDto) {
        String update = "UPDATE EXPENSE_TRACKING.EXPENSES SET expense_category = ?, date_time_expense = ? WHERE expense_id = ?";

        try {
            Expense newExpense = new Expense();
            newExpense.setExpense_id(expenseDto.getExpense_id());
            newExpense.setExpenseCategory(expenseDto.getExpenseCategory());
            newExpense.setDateTimeExpense(expenseDto.getDateTimeExpense());

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, newExpense.getExpenseCategory());
            preparedStatement.setTimestamp(2,Timestamp.valueOf(newExpense.getDateTimeExpense()));
            preparedStatement.setInt(3, newExpense.getExpense_id());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void descriptionUpdate(ExpenseDto expenseDto) {
        String update = "UPDATE EXPENSE_TRACKING.EXPENSES SET expense_description = ?, date_time_expense = ? WHERE expense_id = ?";

        try {
            Expense newExpense = new Expense();
            newExpense.setExpense_id(expenseDto.getExpense_id());
            newExpense.setExpenseDescription(expenseDto.getExpenseDescription());
            newExpense.setDateTimeExpense(expenseDto.getDateTimeExpense());

            PreparedStatement preparedStatement = connection.prepareStatement(update);

            preparedStatement.setString(1, newExpense.getExpenseDescription());
            preparedStatement.setTimestamp(2,Timestamp.valueOf(newExpense.getDateTimeExpense()));
            preparedStatement.setInt(3, newExpense.getExpense_id());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ExpenseDto expenseDto) {
        String delete = "DELETE FROM EXPENSE_TRACKING.EXPENSES WHERE expense_id = ?";

        try {
            Expense newExpense = new Expense();
            newExpense.setExpense_id(expenseDto.getExpense_id());

            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, newExpense.getExpense_id());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ExpenseDto> searchName(String name) {
        List<ExpenseDto> expenseDtos = getAll();

        List<ExpenseDto> filteredExpenses = new ArrayList<>();
        for (ExpenseDto expenseDto: expenseDtos){
            if(expenseDto.getExpenseName().equalsIgnoreCase(name)){
                filteredExpenses.add(expenseDto);
            }
        }
        return filteredExpenses;
    }

    @Override
    public List<ExpenseDto> searchCategory(String category) {
        List<ExpenseDto> expenseDtos = getAll();

        List<ExpenseDto> filteredExpenses = new ArrayList<>();
        for (ExpenseDto expenseDto: expenseDtos){
            if(expenseDto.getExpenseCategory().equalsIgnoreCase(category)){
                filteredExpenses.add(expenseDto);
            }
        }
        return filteredExpenses;
    }

    @Override
    public List<ExpenseDto> searchDescription(String description) {
        List<ExpenseDto> expenseDtos = getAll();

        List<ExpenseDto> filteredExpenses = new ArrayList<>();
        for (ExpenseDto expenseDto: expenseDtos){
            if(expenseDto.getExpenseDescription().toLowerCase().contains(description.toLowerCase())){
                filteredExpenses.add(expenseDto);
            }
        }
        return filteredExpenses;
    }

    @Override
    public List<ExpenseDto> filterExpensesOfTheDay() {
        LocalDate currentDate = LocalDate.now();

        List<ExpenseDto> expenseDtos = getAll().stream()
                .filter(expenseDto -> {
                    LocalDateTime dateTimeExpense = expenseDto.getDateTimeExpense();
                    return dateTimeExpense != null && dateTimeExpense.toLocalDate().equals(currentDate);
                })
                .collect(Collectors.toList());
        return expenseDtos;
    }

    @Override
    public Map<String, Object> filterExpensesInDateRange(LocalDate startDate, LocalDate endDate) {
        Map<String, Object> result = new HashMap<>();

        List<ExpenseDto> expenseDtos = getAll().stream()
                .filter(expenseDto -> {
                    LocalDateTime dateTimeExpense = expenseDto.getDateTimeExpense();
                    if (dateTimeExpense != null) {
                        LocalDate dateExpense = dateTimeExpense.toLocalDate();

                        // Realiza el filtrado por el rango de fechas especificado
                        return !dateExpense.isBefore(startDate) && !dateExpense.isAfter(endDate);
                    }
                    return false;
                })
                .collect(Collectors.toList());

        double totalCost = expenseDtos.stream()
                .mapToDouble(ExpenseDto::getCostOfSpending)
                .sum();

        result.put("expenses", expenseDtos);
        result.put("totalCost", totalCost);

        return result;
    }

}
