package expenseServices.interfaces;

import java.time.LocalDateTime;
@FunctionalInterface
public interface CurrentDateTimeInt {
    LocalDateTime currentDateTime ();
}
