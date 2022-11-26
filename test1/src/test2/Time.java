package test2;

public class Time {
    private int value;

    Time() {
        value = 0;
    }

    int getSecond() {
        return value % 60;
    }

    int getMinute() {
        return value / 60 % 60;
    }

    int getHour() {
        return value / 3600;
    }

    void start() {
        value++;
    }

    void clear() {
        value = 0;
    }

    public String toString() {
        return toDigital(getHour()) + ":" + toDigital(getMinute()) + ":" + toDigital(getSecond());
    }

    static String toDigital(int a) {
        if (a < 10) {
            return "0" + a;
        } else
            return "" + a;
    }
}