package controller;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.of(2023,8,29,4,30);

        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();

        expenseDto.setExpenseName("Perro caliente");
        expenseDto.setCostOfSpending(17900);
        expenseDto.setDateTimeExpense(dateTime);
        expenseDto.setExpenseCategory("Antojo tarde");
        expenseDto.setExpenseDescription("Me dio hambre mucha hambre.");

        expenseDao.insert(expenseDto);

        List<ExpenseDto> expenseDtos =expenseDao.getAll();
        for(ExpenseDto expense: expenseDtos){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }








        /*String createTableQuery = "CREATE TABLE IF NOT EXISTS usuarios (id INT PRIMARY KEY, nombre VARCHAR(50))";
        String insertQuery = "INSERT INTO usuarios VALUES (7, 'John Doe'), (8, 'Jane Smith')";*/

        /*boolean salir = false;

        Scanner scanner = new Scanner(System.in);

        while (!salir){
            System.out.println("Opcion 1 Crear un nuevo gasto¡");
            System.out.println("Opcion 2 Salir¡");
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    IngresarGasto ingresarGasto = new IngresarGasto();
                    System.out.println("Informacion de gastos: ");
                    System.out.println("Identificador gasto: " + ingresarGasto.getContadorNuevoGasto());
                    System.out.println("Nombre: " + ingresarGasto.getNombreGasto() +
                            "\nMonto: " + ingresarGasto.getMontoGasto() +
                            "\nFecha y Hora: " + ingresarGasto.getFechaHoraGasto() +
                            "\nCategoría: " + ingresarGasto.getCategoria() +
                            "\nDescripción: " + ingresarGasto.getDescripcion());
                    break;
                case 2:
                    salir = true;
                    System.out.println("Gracias por utilizar nuestra aplicacion¡");
                    break;
                default:
                    System.out.println("No ingreso una opcion correcta¡");
                    break;
            }
        }*/

    }

}
