import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Scanner;

public class ScoundClass {
    public static void main(String[] args) {
        if (args == null) System.out.println("no args");
        else System.out.println("arg = " + args);

        
        /*for (int i=0; i <5; i++) {
            System.out.println("");
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
        }
        

        System.out.println("");
        System.out.println("Type number");

        Scanner sca = new Scanner(System.in);
        int myNumber = sca.nextInt();
        while (myNumber<= 5){
            System.out.print("*");
            myNumber++;
        }

        System.out.println("");

        System.out.println("Type one number");
        int a = sca.nextInt();

        System.out.println("Type secound number");
        int b = sca.nextInt();

        System.out.println("The answer " + a*b);
        */
        System.out.println("");
        String str = myFunction("Avivit", "Hubara Treitel");
        System.out.println(str);

        GetNumber();

    }
        static void GetNumber() {
            System.out.println("Please type a number");
            Scanner scanner = new Scanner(System.in);
            int iNum = scanner.nextInt();
            SumDigits(iNum);
        }

        static void SumDigits (int iNum) {
            int iSum = 0;
            while(iNum>0) {
                iSum += iNum%10;
                iNum = iNum/10;
            }
            if (iSum/10 <= 0) {
                System.out.println("The sum of the digits: " + iSum);
            }
            else {
                SumDigits(iSum);
            }

        }




    static String myFunction(String Fname, String Lname){
        return Fname + " " + Lname;

    }
}
