package Inheritance;

public class TestMain {
    public static void main(String[] args) {
        PrivateCar pc = new PrivateCar("Toyota", "Silver", 111);
        pc.PrintDetails();

        Motobike mb = new Motobike("hunda","red", 222);
        mb.setNumWeel(3);
        mb.PrintDetails();

    }
}
