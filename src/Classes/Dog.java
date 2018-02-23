package Classes;

public class Dog {
   private String name;
   private int age;
   private String food;

   public Dog (String name, int age){
       this.name = name;
       this.age = age;
       food = "no food";
   }
   public Dog (String name, String food){
       this.name = name;
       age = 0;
       this.food = food;
   }

   public void PrintDetails(){
       System.out.println("Classes.Dog name: " + name);
       System.out.println("Classes.Dog age: " + age);
       System.out.println("Classes.Dog food: " + food);
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
