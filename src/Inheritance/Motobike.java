package Inheritance;

public class Motobike extends Car {
    public Motobike(String type, String color, int speed) {
        super(type, color, speed);
    }

    private int numWheel;

    public int getNumWheel() {
        return numWheel;
    }

    public void setNumWeel(int numWeel) {
        this.numWheel = numWheel;
    }

    public void PrintDetails(){
        super.PrintDetails();
        System.out.println("Number of wheels: " + numWheel);
    }
}
