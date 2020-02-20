package finalstatic;

public class Time {

    private static int instanceCount;
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour) {
        this.hour = hour;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        checkHour(hour);
        checkMinute(minute);
        checkSecond(second);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    private void checkSecond(int second) {

    }

    private void checkMinute(int minute) {

    }

    private void checkHour(int hour) {

    }

    public String toUniversalForm(){
        return String.format("");
    }

    public String toStandartForm(){
        return String.format("");
    }
}
