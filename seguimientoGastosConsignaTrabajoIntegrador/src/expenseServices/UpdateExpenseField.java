package expenseServices;

import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.UpdateExpenseFieldInt;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateExpenseField implements UpdateExpenseFieldInt {
    @Override
    public ExpenseDto updateExpense() {
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();

        //EDICION DE UN CAMPO ESPECIFICO DE UN GASTO
        System.out.println("Actualizar el campo costo de un gasto¡");

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

            //INGRESAR EL NUEVO VALOR DEL COSTO DEL GASTO

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

            expenseDto.setCostOfSpending(costOfSpending);

            System.out.println("Campo actualizado con exito¡");
        }
        System.out.println("Datos ingresados exitosamente¡¡");

        return expenseDto;
    }
}
