package basics;

public class StringExamples {
    public static void main(String[] args) {
        String name = "Derrick";
        String name1 = "Derrick";
        String name2 = new String("Derrick");

        System.out.println(name == name1);
        System.out.println(name != name2);

        System.out.println(name.equals(name2));

        String coffee = "Starbacks";

        System.out.println(coffee.length());

        System.out.println(coffee.indexOf("bucks"));

        for (int i = 0; i < coffee.length(); i++) {
            System.out.println(coffee.charAt(i));
            System.out.println(coffee.substring(i, i + 1));
        }

        char[] chars = coffee.toCharArray();
        for (char ch : coffee.toCharArray()) {
            System.out.println(ch);
        }
    }

}
