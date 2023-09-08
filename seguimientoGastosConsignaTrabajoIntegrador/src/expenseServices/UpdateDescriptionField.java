package expenseServices;

import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.UpdateDescriptionFieldInt;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateDescriptionField implements UpdateDescriptionFieldInt {
    @Override
    public ExpenseDto updateDescription() {
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();

        //EDICION DE UN CAMPO ESPECIFICO DE UN GASTO
        System.out.println("Actualizar el campo descripcion de un gasto¡");

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
                scanner.nextLine(); //CONSUMIR LA LINEA EN BLANCO
                expenseId = 0;
                foundRecord = false;
            }
        } while (!foundRecord);

        if (foundRecord) {
            //SE DEBE INGRESAR EL NUEVO VALOR DE LA DESCRIPCION
            String descriptionOfExpenses;
            do {
                System.out.println("Ingresa una nueva descripcion de tu gasto: ");
                scanner.nextLine(); //CONSUMIR LA LINEA EN BLANCO
                descriptionOfExpenses = scanner.nextLine().trim();

                if (descriptionOfExpenses.isEmpty()) {
                    System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
                } else if (descriptionOfExpenses.length() < 5) {
                    System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
                } else if (descriptionOfExpenses.length() >= 50) {
                    System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
                }

            } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            LocalDateTime currentDateTimeDescription  = LocalDateTime.now();
            expenseDto.setDateTimeExpense(currentDateTimeDescription);

            expenseDto.setExpenseDescription(descriptionOfExpenses);
            System.out.println("Campo actualizado con exito¡");
        }

        return expenseDto;
    }
}
