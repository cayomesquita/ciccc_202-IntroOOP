package basics;

public class FlowControl {

    public static void main(String[] args) {

        int age = 21;

//        1. if statement
        if (age > 50) {
            System.out.println("Age is greater than 50");
        } else if (age > 30 && age <= 50) {
            System.out.println("30 < Age <= 50");
        } else {
            System.out.println("Age <= 30");
        }

//        2. swicth statement
    int salary= 1_000_001;

        switch (salary) {
            case 1_000_000:
                System.out.println("Pretty good everyone!");
            case 100_000:
                System.out.println("Pretty good everyone!");
            case 10_000:
                System.out.println("Pretty good everyone!");
            case 1_000:
                System.out.println("Pretty good everyone!");
            default:
                System.out.println("Unemployed");
        }
    }

}
