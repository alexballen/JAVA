package expenseServices;

import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.UpdateNameFieldInt;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateNameField implements UpdateNameFieldInt {
    @Override
    public ExpenseDto updateName() {
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();

        //EDICION DEL CAMPO NOMBRE DE UN GASTO

        System.out.println("Actualizar el campo nombre de un gasto¡");

        int expenseId;
        boolean foundRecord;
        do {
            System.out.println("Ingresa el ID del gasto que deseas actualizar: ");
            if (scanner.hasNextInt()){
                expenseId = scanner.nextInt();
                expenseDto.setExpense_id(expenseId);

                //SE EJECUTA EL METODO EXPENSESEARCHDAO PARA VERIFICAR SI EL REGITRO EXISTE
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

            //INGRESAR EL NUEVO VALOR DEL NOMBRE DEL GASTO

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
