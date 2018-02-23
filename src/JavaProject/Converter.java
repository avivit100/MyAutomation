package JavaProject;

public class Converter {
    final static double cUSD = 3.76;
    static ScreenMessages sm;
    static PreviousConversions pc;

    public static void main(String[] args){
        boolean bRun = true;
        int iChose;
        double dAmount;
        double dResult = 0;
        sm.welcome();

        try {
            while (bRun) {
                dAmount = 0;
                iChose = sm.choiceScreen();
                while (dAmount == 0){
                    dAmount = sm.getAmount();
                }

                switch (iChose) {
                    case 1:
                        dResult = dAmount * cUSD;
                        break;
                    case 2:
                        dResult = dAmount / cUSD;
                        break;
                }

                pc.addToPrevArr(dResult);
                bRun = sm.resultScreen(dResult);
            }

            sm.endScreen(pc.getPrevArr());
        }
        catch (ArithmeticException ex){
            System.out.println("Error: " + ex.getMessage() + ". Please start all over.");
        }
        catch (Exception ex){
            System.out.println("Error: " + ex.getMessage() + ". Please start all over.");
        }
    }

}
