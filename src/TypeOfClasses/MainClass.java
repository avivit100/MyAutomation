package TypeOfClasses;

public class MainClass {
    public static void main(String[] args) {
        NewStudent student1 = new NewStudent("Avivit");
        student1.SetGrade(80);
        student1.PrintDetails();
        student1.FirstLesson();
        student1.SecoundLesson();

        try {
            student1.Calculate();
        }
        catch( ArithmeticException | NullPointerException ex){
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally{

            System.out.println("End of program.");
        }
    }
}
