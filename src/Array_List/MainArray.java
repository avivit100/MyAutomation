package Array_List;
import Classes.Dog;

import java.util.ArrayList;

public class MainArray {
    public static void main(String[] args) {
        String[] arrString = {"aaa", "bbb", "ccc"};
        System.out.println(arrString[2]);

        ArrayList<Dog> myDog = new ArrayList<Dog>();
        for(int i=1; i<=3; i++){
            Dog dog = new Dog("Shemesh"+i, i);
            myDog.add(dog);
        }

        int i = myDog.size()-1;
        myDog.get(i).PrintDetails();
    }

}
