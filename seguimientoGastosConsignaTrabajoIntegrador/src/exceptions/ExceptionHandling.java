package exceptions;

import java.sql.SQLException;

public class ExceptionHandling extends Exception {
    public ExceptionHandling(String message) {
        super(message);
    }
}
