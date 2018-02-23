package JavaProject;
import java.util.*;

public class PreviousConversions {
    private static ArrayList <Double> arrPrev = new ArrayList<Double>();

    protected static void addToPrevArr(double dAdd){
        arrPrev.add(dAdd);
    }

    protected static String getPrevArr(){
        String strAllPrev = "";

        for (Double dPrev : arrPrev) {
            strAllPrev += dPrev + ", ";
        }

        return strAllPrev;
    }
}
