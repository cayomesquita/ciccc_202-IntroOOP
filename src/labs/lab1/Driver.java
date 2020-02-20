package labs.lab1;

public class Driver {

    public static void main(String[] args) {
        Model model = new Model();
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 66, 158.3);
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 66, 158.3, true, false);
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 23, 79.9);
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 85, 280.1);
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 24, 80);
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 84, 280);
        model.printDetails();
        System.out.println();

        model = new Model("123456789012345678901", "123456789012345678901", 0, 0.0);
        model.printDetails();
        System.out.println();

        model = new Model("12345678901234567890", "12345678901234567890", 0, 0.0);
        model.printDetails();
        System.out.println();

        model = new Model("123", "123", 0, 0.0);
        model.printDetails();
        System.out.println();

        model = new Model("Cayo", "Amorim", 70, 120.0, true, false);
        model.displayModelDetails();
        System.out.println();

        model = new Model("Cayo", "Mesquita", 40, 120.0, false, true);
        model.displayModelDetails();
        System.out.println();

    }
}
