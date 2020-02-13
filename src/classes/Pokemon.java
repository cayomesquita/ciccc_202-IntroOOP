package classes;

//Blueprint
public class Pokemon {
    //    fields(attributes)
    String name;
    String type;
    int healthPoint;
    int attackPoint;

    public Pokemon(String name, String type, int healthPoint, int attackPoint) {
        this.name = name;
        this.type = type;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
    }

    //    methods(begaviors)

    void attack(Pokemon enemy) {
        if (enemy.dodge()) {
            System.out.println(enemy.name + " dodged my super-power attack!");
        } else {
            System.out.println("I'm attacking " + enemy.name + " with " + this.attackPoint);
        }
    }

    boolean dodge() {
        return Math.random() > 0.5;
    }

    void evolve() {
        System.out.println("I'm evolving...");
        healthPoint += 20;
        attackPoint += 20;
    }
}
