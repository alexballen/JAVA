package exceptions;

import java.sql.SQLException;

public class ExceptionHandling extends Exception {
    public ExceptionHandling(String message) {
        super(message);
    }

    public ExceptionHandling(String message, Throwable cause) {
        super(message, cause);
    }

    public  ExceptionHandling(String message, SQLException e) {

    }

}
