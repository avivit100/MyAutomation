package TypeOfClasses;

public abstract class AcceptStudent {
    String name;
    int iGrade;

    public AcceptStudent(String name){
        this.name = name;
    }

    abstract void SetGrade(int i);

    public void PrintDetails() {
        System.out.println("The studant: " + name + " has grade: " + iGrade);
    }
}