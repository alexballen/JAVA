package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.SearchExpenseDBInt;
import expenseServices.interfaces.UpdateNameFieldInt;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class UpdateNameField implements UpdateNameFieldInt {
    @Override
    public ExpenseDto updateName() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");
        Scanner scanner = (Scanner) result.get("Scanner");

        if (foundRecord) {
            //ACTUALIZAR CON EL NUEVO VALOR DEL NOMBRE DEL GASTO
            String expenseName;
            do {
                System.out.println("Ingresa el nuevo nombre del gasto: ");
                expenseName = scanner.nextLine().trim();

                if (expenseName.isEmpty()) {
                    System.out.println("El campo nombre no puede estar vacío. Por favor, ingresa un nombre válido.");
                } else if (expenseName.length() < 5) {
                    System.out.println("Debes ingresar un nombre de gasto con al menos 5 caracteres.");
                } else if (expenseName.length() >= 50) {
                    System.out.println("Debes ingresar un nombre de gasto con menos de 50 caracteres.");
                } else if (!expenseName.matches("^[a-zA-Z ]+$")) {
                    System.out.println("El nombre del gasto debe contener solo letras y espacios.");
                }
                expenseDto.setExpenseName(expenseName);
            } while (expenseName.isEmpty() || expenseName.length() < 5 || expenseName.length() >= 50 || !expenseName.matches("^[a-zA-Z ]+$"));

            System.out.println("Campo actualizado con exito¡");

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            LocalDateTime currentDateTimeName  = LocalDateTime.now();
            expenseDto.setDateTimeExpense(currentDateTimeName);
        }
        return expenseDto;
    }
}
