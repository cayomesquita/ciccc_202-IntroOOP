package labs.lab2;

public class Province {

    private static final String[] VALID_PROVINCES = {"ALBERTA"
            , "BRITISH COLUMBIA"
            , "MANITOBA"
            , "NEW BRUNSWICK"
            , "NEWFOUNDLAND AND LABRADOR"
            , "NOVA SCOTIA"
            , "ONTARIO"
            , "PRINCE EDWARD ISLAND"
            , "QUEBEC"
            , "SASKATCHEWAN"};

    private static final String[] VALID_CAPITALS = {"EDMONTON"
            , "VICTORIA"
            , "WINNIPEG"
            , "FREDERICTON"
            , "ST. JOHN'S"
            , "HALIFAX"
            , "TORONTO"
            , "CHARLOTTETOWN"
            , "QUEBEC CITY"
            , "REGINA"};
    public static final String DEFAULT_PROVINCE = "British Columbia";
    public static final String DEFAULT_CAPITAL = "Victoria";
    public static final int DEFAULT_POPULATION = 4_648_055;
    public static final int MIN_POPULATION = 30_000;
    public static final int MAX_POPULATION = 15_000_000;

    private String name;
    private String capital;
    private long population;

    public Province(String provinceName, String capital, long population) {
        if (isValidaProvince(provinceName) && isValidCapital(provinceName, capital) && isValidPopulation(population)) {
            this.name = provinceName;
            this.capital = capital;
            this.population = population;
        } else {
            this.name = DEFAULT_PROVINCE;
            this.capital = DEFAULT_CAPITAL;
            this.population = DEFAULT_POPULATION;
        }
    }

    public Province() {
        this.name = DEFAULT_PROVINCE;
        this.capital = DEFAULT_CAPITAL;
        this.population = DEFAULT_POPULATION;
    }

    public String getDetails() {
        return String.format("The capital of %s (population. %d) is %s.", getName(), getPopulation(), getCapital());
    }

    private boolean isValidPopulation(long population) {
        return (population >= MIN_POPULATION && population <= MAX_POPULATION) ? true : false;
    }

    private boolean isValidCapital(String province, String capital) {
        for (int i = 0; i < VALID_PROVINCES.length; i++) {
            if (VALID_PROVINCES[i].equalsIgnoreCase(province)) {
                return VALID_CAPITALS[i].equalsIgnoreCase(capital);
            }
        }
        return false;
    }

    private boolean isValidaProvince(String provinceName) {
        for (String validProvince : VALID_PROVINCES) {
            if (validProvince.equalsIgnoreCase(provinceName)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
