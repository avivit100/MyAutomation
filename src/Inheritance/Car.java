package Inheritance;

public class Car {
    private String type;
    String color;
    int speed;

    public Car(String type, String color, int speed) {
        this.type = type;
        this.color = color;
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected void PrintDetails(){
        System.out.println("Classes.Dog type: " + type);
        System.out.println("Classes.Dog color: " + color);
        System.out.println("Classes.Dog speed: " + speed);
    }
}
