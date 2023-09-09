package expenseServices;

import dao.ExpenseSearchDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.SearchExpenseDBInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SearchExpenseDB implements SearchExpenseDBInt {
    @Override
    public Map<String, Object> searchExpense() {
        Map<String, Object> result = new HashMap<>();

        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);
        ExpenseSearchDao expenseSearchDao = new ExpenseDaoImplH2();

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

        result.put("expenseDto", expenseDto);
        result.put("foundRecord", foundRecord);
        result.put("Scanner", scanner);

        return result;
    }
}
