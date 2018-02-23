public class FirstClass
{
    public static void main(String[] args) {
        /*String strName = "Avivit Hubara Treitel";
        int iAge = 7*6;
        System.out.println(strName + " " + iAge);

        int iFirst = 123;
        int iSecound = 456;

        if (iFirst > iSecound)System.out.println("First is biger");
        if (iFirst < iSecound)System.out.println("Secound is biger");

        if (iFirst == iSecound)
            System.out.println("First equals Secound");
        if (iFirst != iSecound)
            System.out.println("First not equals Secound");

        int iSmall;
        long lBig = 100000000000000l;
        iSmall = (int) lBig;
        System.out.println("Before casting " + lBig);
        System.out.println("After  casting " + iSmall);

        byte bOne;
        int iTwo = 12345;
        bOne = (byte) iTwo;
        System.out.println("Before casting " + iTwo);
        System.out.println("After  casting " + bOne);*/

        int x = 123;
        int y = 456;
        int z = 789;
        float fff = (float)x;
        double ddd = (double)x;


        System.out.println(123+456+789);
        System.out.println(x+y+z);

        System.out.println(x-y-z);
        System.out.println("Before casting " + x);
        System.out.println("After  casting " + fff);
        System.out.println("After  casting " + ddd);
        fff = (float)x;
        ddd = (double)x;
        System.out.println("After  casting " + fff);
        System.out.println("After  casting " + ddd);

    }
}
