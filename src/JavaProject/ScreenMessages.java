package JavaProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScreenMessages {
    private static Scanner sc = new Scanner(System.in);

    protected static void welcome() {
        System.out.println("*** Welcome to currency converter ***");
    }

    protected static int choiceScreen(){
        String strInput;
        int iChoice = 0;
        boolean bRun = true;

        System.out.println("Please choose an option (1/2):");
        System.out.println("1 - Dollars to Shekels");
        System.out.println("2 - Shekels to Dollars");

        try {
            while (bRun == true) {
                strInput = sc.next();
                if (strInput.equals("1") || strInput.equals("2")){
                    iChoice = Integer.parseInt(strInput);
                    bRun = false;
                }
                else {
                    System.out.println(strInput + " is an invalid Choice, please try again - 1/2.");
                }

            }
        }
        catch(InputMismatchException ex1){
            System.out.println("Invalid Choice. " + ex1.getMessage() + ". Please start all over.");
        }
        catch (NumberFormatException ex2){
            System.out.println("Invalid Choice. " + ex2.getMessage() + ". Please start all over.");
        }
        return iChoice;
    }

    protected static double getAmount(){
        String strInput;
        double dAmount = 0;

        try {
            System.out.println("Please enter an amount to convert");
            strInput = sc.next();
            dAmount = Double.valueOf(strInput);
        }
        catch(NumberFormatException ex1){
            System.out.println("Invalid amount. " + ex1.getMessage());
        }
        catch(ArithmeticException ex2){
            System.out.println("Invalid amount. " + ex2.getMessage());
        }
        return dAmount;
    }

    protected static boolean resultScreen(double dCurrency) {
        String strChose;
        System.out.println("The rate of conversion is: " + dCurrency);
        System.out.println("Would you like to start over? Y/N");

        try {
            while (true) {
                strChose = sc.next();
                if (strChose.toUpperCase().equals("Y")) return true;
                if (strChose.toUpperCase().equals("N")) return false;

                System.out.println("Invalid Choice, please try again - Y/N.");
            }
        }
        catch(InputMismatchException ex1){
            System.out.println("Invalid Choice. " + ex1.getMessage() + ". Please start all over.");
        }
        return false;
    }

    protected static void endScreen(String strPrev){
        System.out.println("Thanks for using our currency converter!");
        System.out.println("The previous results are: " + strPrev);
    }
}
