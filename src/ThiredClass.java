import Classes.Dog;

import java.util.ArrayList;

public class ThiredClass {

    public static void main(String[] args) {
        Dog dog1 = new Dog("aaa",2 );
        Dog dog2 = new Dog("bbb","Dogi");

        dog1.PrintDetails();
        dog2.PrintDetails();

        dog1.setName("ccc");
        dog1.PrintDetails();

        SecoundString();
        IsNumberExist();
        AverageNumbers();
    }

    static private void SecoundString() {
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("happy");
        listString.add("bless");
        listString.add("health");

        for (int i = 0; i < listString.size(); i++) {
            if (i == 1) {
                System.out.println("Secound String is: " + listString.get(i));
            }
        }
    }

    static private void AverageNumbers() {
        int[] arrNum = {34, 76, 81, 46, 99, 46};
        int iSum = 0;
        for (int i = 0; i < arrNum.length; i++) {
            iSum += arrNum[i];
        }
        System.out.println("Average of numbers is: " + iSum / arrNum.length);
    }

    static private void IsNumberExist() {
        int[] arrNum = {22, 33, 44, 55, 66};
        boolean bExist = false;
        for (int i = 0; i < arrNum.length; i++) {
            if (arrNum[i] == 67) {
                bExist = true;
                break;
            }
        }

        if (bExist) {
            System.out.println("Number 67 exists in the array");
        } else {
            System.out.println("Number 67 doesn't exist in the array");
        }

    }
}
