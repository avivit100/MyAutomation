package JUnit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReadFile {
    private static String strMyData = "nothing";

    @Test
    public void A_GetMyData() throws IOException {
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader("D:\\Automation\\Files\\MyData.txt"));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            strMyData = sb.toString();
            br.close();
        } 
        catch(IOException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        finally {
            br.close();
        }
    }

    @Test
    public void B_PrintMyData(){
        System.out.println(strMyData);

    }
}
