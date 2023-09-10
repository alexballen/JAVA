package expenseServices;

import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;

public class ScannerProvider implements ScannerProviderInt {
    private static Scanner scannerInstance;

    @Override
    public Scanner getScannerInstance() {
        if (scannerInstance == null) {
            scannerInstance = new Scanner(System.in);
        }
        return scannerInstance;
    }
}
