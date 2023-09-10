package expenseServices;

import expenseServices.interfaces.CurrentDateTimeInt;

import java.time.LocalDateTime;
public class CurrentDateTime implements CurrentDateTimeInt {
    @Override
    public LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}
