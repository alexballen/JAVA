package dao.dto;

import java.time.LocalDateTime;

public class ExpenseDto {
    private int expense_id;
    private String expenseName;
    private Double costOfSpending;
    private LocalDateTime dateTimeExpense;
    private String expenseCategory;
    private String expenseDescription;

    public ExpenseDto() {
    }
    public ExpenseDto(int expense_id,String expenseName ){
        this.expense_id = expense_id;
        this.expenseName = expenseName;
    }
    public ExpenseDto(int expense_id,Double costOfSpending){
        this.expense_id = expense_id;
        this.costOfSpending = costOfSpending;
    }
    public ExpenseDto(int expense_id,LocalDateTime dateTimeExpense){
        this.expense_id = expense_id;
        this.dateTimeExpense = dateTimeExpense;
    }
    public ExpenseDto(int expense_id, String expenseName, Double costOfSpending, LocalDateTime dateTimeExpense, String expenseCategory, String expenseDescription) {
        this.expense_id = expense_id;
        this.expenseName = expenseName;
        this.costOfSpending = costOfSpending;
        this.dateTimeExpense = dateTimeExpense;
        this.expenseCategory = expenseCategory;
        this.expenseDescription = expenseDescription;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getCostOfSpending() {
        return costOfSpending;
    }

    public void setCostOfSpending(Double costOfSpending) {
        this.costOfSpending = costOfSpending;
    }

    public LocalDateTime getDateTimeExpense() {
        return dateTimeExpense;
    }

    public void setDateTimeExpense(LocalDateTime dateTimeExpense) {
        this.dateTimeExpense = dateTimeExpense;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }
}
