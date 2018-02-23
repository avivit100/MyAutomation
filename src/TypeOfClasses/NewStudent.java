package TypeOfClasses;

public class NewStudent extends AcceptStudent implements Lessons {
    public NewStudent(String name) {
        super(name);
    }

    @Override
    void SetGrade (int i) {
        iGrade = i;
    }

     public void FirstLesson(){
        if (iGrade <=80)
            System.out.println("Studant name:" + name + " has to subscribe to first lesson.");
        else
            System.out.println("Studant name:" + name + " doesn't have to subscribe to first lesson.");
    }

    public void SecoundLesson(){
        if (iGrade <=90)
            System.out.println("Studant name:" + name + " has to subscribe to secound lesson.");
        else
            System.out.println("Studant name:" + name + " doesn't have to subscribe to secound lesson.");
    }

     void Calculate(){
        int iNew =  iGrade/0;
        System.out.println("New grade = " + iNew);
    }
}
