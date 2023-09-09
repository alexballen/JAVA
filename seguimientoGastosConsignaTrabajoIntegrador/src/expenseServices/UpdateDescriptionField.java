package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.SearchExpenseDBInt;
import expenseServices.interfaces.UpdateDescriptionFieldInt;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class UpdateDescriptionField implements UpdateDescriptionFieldInt {
    @Override
    public ExpenseDto updateDescription() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");
        Scanner scanner = (Scanner) result.get("Scanner");

        if (foundRecord) {
            //ACTUALIZAR CON EL NUEVO VALOR DE LA DESCRIPCION
            String descriptionOfExpenses;
            do {
                System.out.println("Ingresa una nueva descripcion de tu gasto: ");
                descriptionOfExpenses = scanner.nextLine().trim();

                if (descriptionOfExpenses.isEmpty()) {
                    System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
                } else if (descriptionOfExpenses.length() < 5) {
                    System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
                } else if (descriptionOfExpenses.length() >= 50) {
                    System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
                }
                expenseDto.setExpenseDescription(descriptionOfExpenses);
            } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            LocalDateTime currentDateTimeDescription  = LocalDateTime.now();
            expenseDto.setDateTimeExpense(currentDateTimeDescription);

            System.out.println("Campo actualizado con exito¡");
        }
        return expenseDto;
    }
}
