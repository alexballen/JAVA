package controller;

import expenseServices.*;
import expenseServices.interfaces.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        OptionMenuInt optionMenuInt = new OptionMenu();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            boolean repit = optionMenuInt.repit();
            if (repit) {
                System.out.println("Volviendo al menú principal...");
            } else {
                exit = true;
                System.out.println("Gracias, vuelva pronto!");
            }
        }
        scanner.close();
    }
}
