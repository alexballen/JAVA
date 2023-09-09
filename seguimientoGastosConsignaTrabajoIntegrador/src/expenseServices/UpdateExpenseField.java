package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.SearchExpenseDBInt;
import expenseServices.interfaces.UpdateExpenseFieldInt;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
public class UpdateExpenseField implements UpdateExpenseFieldInt {
    @Override
    public ExpenseDto updateExpense() {
        SearchExpenseDBInt searchExpenseDBInt = new SearchExpenseDB();
        Map<String, Object> result = searchExpenseDBInt.searchExpense();

        ExpenseDto expenseDto = (ExpenseDto) result.get("expenseDto");
        boolean foundRecord = (boolean) result.get("foundRecord");
        Scanner scanner = (Scanner) result.get("Scanner");

        if (foundRecord) {
            //ACTUALIZAR CON EL NUEVO VALOR DEL COSTO DEL GASTO
            double costOfSpending = 0;
            boolean validInput = false;
            do {
                System.out.println("Ingresa el nuevo costo del gasto: ");
                try {
                    costOfSpending = Double.parseDouble(scanner.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("El valor ingresado no es un número válido. Por favor, ingresa un número.");
                }

                if (validInput) {
                    expenseDto.setCostOfSpending(costOfSpending);
                }
            } while (!validInput);

            //SE INGRESA LA FECHA Y HORA ACTUALIZADAS AUTOMATICAMENTE
            LocalDateTime currentDateTimeCost  = LocalDateTime.now();
            expenseDto.setDateTimeExpense(currentDateTimeCost);

            System.out.println("Campo actualizado con exito¡");
        }
        return expenseDto;
    }
}
