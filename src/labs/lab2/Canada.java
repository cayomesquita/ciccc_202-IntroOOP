package labs.lab2;

public class Canada {

    public static final int TOTAL_PROCINVES = 10;
    public static final long MILLION = 1_000_000;

    private Province[] provinces;

    public Canada() {
        provinces = new Province[TOTAL_PROCINVES];
        int index = 0;
        provinces[index++] = new Province("ALBERTA", "EDMONTON", 4_395_586);
        provinces[index++] = new Province("BRITISH COLUMBIA", "VICTORIA", 5_105_576);
        provinces[index++] = new Province("MANITOBA", "WINNIPEG", 1_373_859);
        provinces[index++] = new Province("NEW BRUNSWICK", "FREDERICTON", 780_021);
        provinces[index++] = new Province("NEWFOUNDLAND AND LABRADOR", "ST. JOHN'S", 521_922);
        provinces[index++] = new Province("NOVA SCOTIA", "HALIFAX", 976_768);
        provinces[index++] = new Province("ONTARIO", "TORONTO", 14_659_616);
        provinces[index++] = new Province("PRINCE EDWARD ISLAND", "CHARLOTTETOWN", 157_901);
        provinces[index++] = new Province("QUEBEC", "QUEBEC CITY", 8_522_800);
        provinces[index] = new Province("SASKATCHEWAN", "REGINA", 1_178_657);
    }

    public void displayAllProvinces() {
        for (Province province : provinces) {
            System.out.println(province.getDetails());
        }
    }

    public int getNumOfProvincesBetween(int minPopulationMillions, int maxPopulationMillions) {
        long minPopulation = MILLION * minPopulationMillions;
        long maxPopulation = MILLION * maxPopulationMillions;
        int sum = 0;
        for (Province province : provinces) {
            if (province.getPopulation() >= minPopulation && province.getPopulation() <= maxPopulation) {
                sum++;
            }
        }
        return sum;
    }
}
