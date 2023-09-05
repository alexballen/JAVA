package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.SearchExpenseCategoryInt;

import java.util.List;
import java.util.Scanner;

public class SearchExpenseCategory implements SearchExpenseCategoryInt {
    @Override
    public void searchExpenseByCategory() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        //BUSQUEDA POR CATEGORIA, SELECCIONAR OPCION PARA FILTRAR

        int categoryOption;
        String categoryOptionString = "";
        do {
            System.out.println("Busqueda por categoria, selecciona una opcion para filtrar: ");
            System.out.println("Opción 1 - Alimentos y Bebidas");
            System.out.println("Opción 2 - Vivienda");
            System.out.println("Opción 3 - Transporte");
            System.out.println("Opción 4 - Entretenimiento");
            System.out.println("Opción 5 - Salud");
            System.out.println("Opción 6 - Educación");
            System.out.println("Opción 7 - Ropa y Accesorios");
            System.out.println("Opción 8 - Tecnología");
            System.out.println("Opción 9 - Viajes");
            System.out.println("Opción 10 - Mascotas");

            // Verificar si la opcion seleccionada es un entero
            if (scanner.hasNextInt()) {
                categoryOption = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea en blanco
                if (categoryOption >= 1 && categoryOption <= 10) {
                    switch (categoryOption) {
                        case 1:
                            expenseDto.setExpenseCategory("Alimentos y Bebidas");
                            categoryOptionString = "Alimentos y Bebidas";
                            break;
                        case 2:
                            expenseDto.setExpenseCategory("Vivienda");
                            categoryOptionString = "Vivienda";
                            break;
                        case 3:
                            expenseDto.setExpenseCategory("Transporte");
                            categoryOptionString = "Transporte";
                            break;
                        case 4:
                            expenseDto.setExpenseCategory("Entretenimiento");
                            categoryOptionString = "Entretenimiento";
                            break;
                        case 5:
                            expenseDto.setExpenseCategory("Salud");
                            categoryOptionString = "Salud";
                            break;
                        case 6:
                            expenseDto.setExpenseCategory("Educación");
                            categoryOptionString = "Educación";
                            break;
                        case 7:
                            expenseDto.setExpenseCategory("Ropa y Accesorios");
                            categoryOptionString = "Ropa y Accesorios";
                            break;
                        case 8:
                            expenseDto.setExpenseCategory("Tecnología");
                            categoryOptionString = "Tecnología";
                            break;
                        case 9:
                            expenseDto.setExpenseCategory("Viajes");
                            categoryOptionString = "Viajes";
                            break;
                        case 10:
                            expenseDto.setExpenseCategory("Mascotas");
                            categoryOptionString = "Mascotas";
                            break;
                    }
                } else {
                    System.out.println("Debes ingresar una opción válida (del 1 al 10).");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                categoryOption = 0; // Reiniciar la variable
            }
        } while (categoryOption < 1 || categoryOption > 10);

        List<ExpenseDto> filterByCategory = expenseDao.searchCategory(categoryOptionString);
        for (ExpenseDto expense: filterByCategory){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }
    }
}
