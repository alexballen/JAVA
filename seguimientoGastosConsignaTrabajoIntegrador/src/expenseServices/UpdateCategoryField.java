package expenseServices;

import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.UpdateCategoryFieldInt;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateCategoryField implements UpdateCategoryFieldInt {
    @Override
    public ExpenseDto updateCategory() {
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();

        //EDICION DE UN CAMPO ESPECIFICO DE UN GASTO
        System.out.println("Actualizar el campo categoria de un gasto¡");

        int expenseId;
        boolean foundRecord;
        do {
            System.out.println("Ingresa el ID del gasto que deseas actualizar: ");
            if (scanner.hasNextInt()){
                expenseId = scanner.nextInt();
                expenseDto.setExpense_id(expenseId);

                // Llamar al método updateAll para verificar si el registro existe
                foundRecord = expenseSearchDao.expenseSearch(expenseDto);
                if (!foundRecord) {
                    System.out.println("No existe el ID proporcionado, ingresa un ID valido.");
                    foundRecord = false;
                } else {
                    foundRecord = true;
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine();
                expenseId = 0;
                foundRecord = false;
            }
        } while (!foundRecord);

        if (foundRecord) {
            //SE DEBE SELECCIONAR EL NUEVO VALOR DE LA CATEGORIA
            int categoryOption;
            String categoryOptionString = "";
            do {
                System.out.println("Ingrese una de las siguientes categorías: ");
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
                expenseDto.setExpenseCategory(categoryOptionString);
            } while (categoryOption < 1 || categoryOption > 10);

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            LocalDateTime currentDateTimeCategory  = LocalDateTime.now();
            expenseDto.setDateTimeExpense(currentDateTimeCategory);

            System.out.println("Campo actualizado con exito¡");
        }

        scanner.close();

        return expenseDto;
    }
}
