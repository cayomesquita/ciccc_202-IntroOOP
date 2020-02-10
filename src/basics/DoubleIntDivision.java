package basics;

public class DoubleIntDivision {
    public static void main(String[] args) {
        double x = 10;
        int y = 3;
        int z = 7;

        int a = z / y;
        double b = x / y;

        int c = (int) x / y;
        double d = z / y;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


    }
}
