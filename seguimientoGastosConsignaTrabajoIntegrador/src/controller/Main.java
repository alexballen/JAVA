package controller;

import dao.ExpenseDao;
import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.*;
import expenseServices.interfaces.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        NewExpense newExpense = new EnterNewExpense();
        AllExpenseUpdate allExpenseUpdate = new ExpenseUpdate();
        UpdateNameField updateNameField = new UpdateNameField();
        UpdateExpenseFieldInt updateExpenseFieldInt = new UpdateExpenseField();
        UpdateCategoryFieldInt updateCategoryFieldInt = new UpdateCategoryField();
        UpdateDescriptionFieldInt updateDescriptionFieldInt = new UpdateDescriptionField();
        SearchExpenseNameInt searchExpenseNameInt = new SearchExpenseName();
        SearchExpenseCategoryInt searchExpenseCategoryInt = new SearchExpenseCategory();
        SearchExpenseDescriptionInt searchExpenseDescriptionInt = new SearchExpenseDescription();
        LookUpTotalDailyExpensesInt lookUpTotalDailyExpensesInt = new LookUpTotalDailyExpenses();
        FindTotalWeeklyExpensesInt findTotalWeeklyExpensesInt = new FindTotalWeeklyExpenses();
        FindTotalMonthlyExpensesInt findTotalMonthlyExpensesInt = new FindTotalMonthlyExpenses();
        LookUpTotalAnnualExpensesInt lookUpTotalAnnualExpensesInt = new LookUpTotalAnnualExpenses();
        SearchByDateRangeExpensesInt searchByDateRangeExpensesInt = new SearchByDateRangeExpenses();

        Scanner scanner = new Scanner(System.in);

        //------------------------------------------------
        //CREAR UN NUEVO GASTO
        /*expenseDto = newExpense.addName();
        expenseDao.insert(expenseDto);

        System.out.println(expenseDto.getExpenseName());
        System.out.println(expenseDto.getCostOfSpending());*/
        //--------------------------------------------------
        //ACTUALIZAR TODOS LOS CAMPOS DE UN GASTO
        /*expenseDto = allExpenseUpdate.expenseUpdateAll();
        expenseDao.updateAll(expenseDto);

        System.out.println(expenseDto.getExpenseName());
        System.out.println(expenseDto.getCostOfSpending());*/
        //---------------------------------------------------
        //ACTUALIZAR EL CAMPO NOMBRE DE UN GASTO
        /*expenseDto = updateNameField.updateName();
        expenseDao.updateName(expenseDto);
hk

        System.out.println(expenseDto.getExpenseName());*/
        //---------------------------------------------------
        //ACTUALIZAR EL CAMPO COSTO DE UN GASTO
        /*expenseDto = updateExpenseFieldInt.updateExpense();
        expenseDao.costUpdate(expenseDto);

        System.out.println(expenseDto.getCostOfSpending());*/
        //----------------------------------------------------
        //ACTUALIZAR EL CAMPO CATEGORIA DE UN GASTO
        /*expenseDto = updateCategoryFieldInt.updateCategory();
        expenseDao.categoryUpdate(expenseDto);

        System.out.println(expenseDto.getExpenseCategory());*/
        //-----------------------------------------------------
        //ACTUALIZAR EL CAMPO DESCRIPCION DE UN GASTO
        /*expenseDto = updateDescriptionFieldInt.updateDescription();
        expenseDao.descriptionUpdate(expenseDto);

        System.out.println(expenseDto.getExpenseDescription());*/


        //-------------------------------------------------------
        //FILTRO POR NOMBRE DE GASTO
        //searchExpenseNameInt.searchExpenseByName();


        //-------------------------------------------------------
        //FILTRO POR CATEGORIA DE GASTO
        //searchExpenseCategoryInt.searchExpenseByCategory();


        //-------------------------------------------------------
        //FILTRO POR DESCRIPCION DE GASTO
        //searchExpenseDescriptionInt.searchExpenseByDescription();


        //-------------------------------------------------------
        //FILTRAR GASTOS POR DIA CON SU TOTAL
        //lookUpTotalDailyExpensesInt.totalDailyExpenses();


        //--------------------------------------------------------
        //FILTRAR GASTOS POR SEMANA CON SU TOTAL
        //findTotalWeeklyExpensesInt.totalWeeklyExpenses();


        //--------------------------------------------------------
        //FILTRAR GASTOS POR MES CON SU TOTAL
        //findTotalMonthlyExpensesInt.totalMonthlyExpenses();


        //--------------------------------------------------------
        //FILTRAR GASTOS POR AÑO CON SU TOTAL
        //lookUpTotalAnnualExpensesInt.totalAnnualExpenses();


        //--------------------------------------------------------
        //FILTRAR GASTOS POR UN RANGO DE FECHAS
        //searchByDateRangeExpensesInt.searchByDateRange();
        //---------------------------------------------------------

        int categoryOption;
        boolean exit = false;
        do {
            System.out.println("Bienvenidos a mi aplicacion de control de gastos¡");
            System.out.println();

            System.out.println("Selecciona cualquiera de las siguientes opciones: ");
            System.out.println();

            System.out.println("Opción 1 - Ingresar un nuevo Gasto¡");
            System.out.println("Opción 2 - Actualizar todos los campos de un Gasto¡");
            System.out.println("Opción 3 - Actualizar el campo nombre de un Gasto¡");
            System.out.println("Opción 4 - Actualizar el campo costo de un Gasto¡");
            System.out.println("Opción 5 - Actualizar el campo categoria de un Gasto¡");
            System.out.println("Opción 6 - Actualizar el campo descripcion de un Gasto¡");
            System.out.println("Opción 7 - Filtrar por nombre de Gasto¡");
            System.out.println("Opción 8 - Filtrar por categoria de Gasto¡");
            System.out.println("Opción 9 - Filtrar por descripcion de Gasto¡");
            System.out.println("Opción 10 - Filtrar gastos por dia con Total¡");
            System.out.println("Opción 11 - Filtrar gastos por semana con Total¡");
            System.out.println("Opción 12 - Filtrar gastos por mes con Total¡");
            System.out.println("Opción 13 - Filtrar gastos por año con Total¡");
            System.out.println("Opción 14 - Filtrar gastos por rango de Fechas¡");
            System.out.println("Opción 15 - Salir¡");

            // Verificar si la opcion seleccionada es un entero
            if (scanner.hasNextInt()) {
                categoryOption = scanner.nextInt();
                if (categoryOption >= 1 && categoryOption <= 15) {
                    switch (categoryOption) {
                        case 1:
                            expenseDto = newExpense.addName();
                            expenseDao.insert(expenseDto);
                            break;
                        case 2:
                            expenseDto = allExpenseUpdate.expenseUpdateAll();
                            expenseDao.updateAll(expenseDto);
                            break;
                        case 3:
                            expenseDto = updateNameField.updateName();
                            expenseDao.updateName(expenseDto);
                            break;
                        case 4:
                            expenseDto = updateExpenseFieldInt.updateExpense();
                            expenseDao.costUpdate(expenseDto);
                            break;
                        case 5:
                            expenseDto = updateCategoryFieldInt.updateCategory();
                            expenseDao.categoryUpdate(expenseDto);
                            break;
                        case 6:
                            expenseDto = updateDescriptionFieldInt.updateDescription();
                            expenseDao.descriptionUpdate(expenseDto);
                            break;
                        case 7:
                            searchExpenseNameInt.searchExpenseByName();
                            break;
                        case 8:
                            searchExpenseCategoryInt.searchExpenseByCategory();
                            break;
                        case 9:
                            searchExpenseDescriptionInt.searchExpenseByDescription();
                            break;
                        case 10:
                            lookUpTotalDailyExpensesInt.totalDailyExpenses();
                            break;
                        case 11:
                            findTotalWeeklyExpensesInt.totalWeeklyExpenses();
                            break;
                        case 12:
                            findTotalMonthlyExpensesInt.totalMonthlyExpenses();
                            break;
                        case 13:
                            lookUpTotalAnnualExpensesInt.totalAnnualExpenses();
                            break;
                        case 14:
                            searchByDateRangeExpensesInt.searchByDateRange();
                            break;
                        case 15:
                            exit = true;
                            System.out.println("Gracias, vuelva pronto¡");
                            break;
                    }
                } else {
                    System.out.println("Debes ingresar una opción válida (del 1 al 15).");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                categoryOption = 0; // Reiniciar la variable
            }
        } while (!exit);
    }
}
