package classes;

public class Driver {
    public static void main(String[] args) {
        Pokemon pika = new Pokemon("Pikachu", "Eletric", 100, 70);

        Pokemon charizard = new Pokemon("Charizard", "Fire/Fly", 120, 70);

        System.out.println(pika.name);
        System.out.println(charizard.name);

    }
}
