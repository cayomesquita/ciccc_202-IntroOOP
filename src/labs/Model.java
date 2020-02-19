package labs;

/**
 * Model class
 *
 * @author cayo.amorim
 */
public class Model {

    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;

    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;

    public static final String NEW_LINE = "\n";


    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean canSmoke;

    /**
     * Constructor
     */
    public Model() {
    }

    /**
     * Constructor 2
     *
     * @param firstName
     * @param lastName
     * @param heightInches
     * @param weightPounds
     * @param traveler
     * @param smoker
     */
    public Model(String firstName, String lastName, int heightInches, double weightPounds, boolean traveler, boolean smoker) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(heightInches);
        setWeight(weightPounds);
        setCanTravel(traveler);
        setCanSmoke(smoker);
    }

    /**
     * Constructor 3
     *
     * @param firstName
     * @param lastName
     * @param heightInches
     * @param weightPounds
     */
    public Model(String firstName, String lastName, int heightInches, double weightPounds) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(heightInches);
        setWeight(weightPounds);
    }

    /**
     * @return Weight in Feet and inches
     */
    public String getHeightInFeetAndInches() {
        int feet = (int) (getHeight() / INCHES_PER_FOOT);
        int inches = getHeight() % INCHES_PER_FOOT;
        return String.format("%d feet %d inches", feet, inches);
    }

    /**
     * @return Weight in KG
     */
    public long getWeightKg() {
        return Math.round(getWeight() / POUNDS_PER_KG);
    }

    /**
     * Display the model's details
     */
    public void printDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s", getFirstName(), getLastName()));
        sb.append(NEW_LINE);
        sb.append(String.format("Height: %d inches", getHeight()));
        sb.append(NEW_LINE);
        sb.append(String.format("Weight: %d pounds", Double.valueOf(getWeight()).intValue()));
        sb.append(NEW_LINE);
        sb.append(String.format("Does %stravel", isCanTravel() ? "" : "not "));
        sb.append(NEW_LINE);
        sb.append(String.format("Does %ssmoke", isCanSmoke() ? "" : "not "));
        System.out.println(sb.toString());
    }

    /**
     * @return Payment per hour
     */
    public int calculatePayDollarsPerHour() {
        int pay = BASE_RATE_DOLLARS_PER_HOUR;
        if (getHeight() >= TALL_INCHES && getWeight() < THIN_POUNDS) {
            pay += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (isCanTravel()) {
            pay += TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (isCanSmoke()) {
            pay -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        return pay;
    }

    /**
     * Display more model's details
     */
    public void displayModelDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s", getFirstName(), getLastName()));
        sb.append(NEW_LINE);
        sb.append(String.format("Height: %s", getHeightInFeetAndInches()));
        sb.append(NEW_LINE);
        sb.append(String.format("Weight: %.1f pounds", getWeight()));
        sb.append(NEW_LINE);
        sb.append(String.format("Travels: %s", isCanTravel() ? "yep" : "nope "));
        sb.append(NEW_LINE);
        sb.append(String.format("Smokes: %s", isCanSmoke() ? "yep" : "nope "));
        sb.append(NEW_LINE);
        sb.append(String.format("Hourly rate: $%d", calculatePayDollarsPerHour()));
        System.out.println(sb.toString());
    }

    private boolean isNameValid(String name) {
        return name != null && name.length() > 2 && name.length() < 21;
    }

    private boolean isHeightValid(int inches) {
        return inches > 23 && inches < 85;
    }

    private boolean isWeightValid(double inches) {
        return inches >= 80 && inches <= 280;
    }

    private int convertFeetToInch(int feet) {
        return INCHES_PER_FOOT * feet;
    }

    private double convertKgToPound(long kilograms) {
        return POUNDS_PER_KG * kilograms;
    }

    /**
     * @return First Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName First Name
     */
    public void setFirstName(String firstName) {
        if (isNameValid(firstName)) {
            this.firstName = firstName;
        }
    }


    /**
     * @return Last Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName Last Name
     */
    public void setLastName(String lastName) {
        if (isNameValid(lastName)) {
            this.lastName = lastName;
        }
    }

    /**
     * @return Height in inches
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param inches Heigth in inches
     */
    public void setHeight(int inches) {
        if (isHeightValid(inches)) {
            this.height = inches;
        }
    }

    /**
     * Sum the parameters to set the height in inches
     *
     * @param feet   Feet
     * @param inches inches
     */
    public void setHeight(int feet, int inches) {
        this.height = convertFeetToInch(feet) + inches;
    }


    /**
     * @return Weight in pound
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param pounds Weight in pounds
     */
    public void setWeight(double pounds) {
        if (isWeightValid(pounds)) {
            this.weight = pounds;
        }
    }

    /**
     * @param kilograms Weight in KG
     */
    public void setWeight(long kilograms) {
        this.weight = convertKgToPound(kilograms);

    }

    /**
     * @return Traveler
     */
    public boolean isCanTravel() {
        return canTravel;
    }

    /**
     * @param canTravel
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * @return Smoker
     */
    public boolean isCanSmoke() {
        return canSmoke;
    }

    /**
     * @param canSmoke
     */
    public void setCanSmoke(boolean canSmoke) {
        this.canSmoke = canSmoke;
    }
}
