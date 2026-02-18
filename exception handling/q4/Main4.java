import java.util.Scanner;

class InvalidHourException extends Exception {
    public String toString() {
        return "InvalidHourException:hour is not greater than 24";
    }
}

class InvalidMinuteException extends Exception {
    public String toString() {
        return "InvalidMinuteException:hour is not greater than 60";
    }
}

class InvalidSecondException extends Exception {
    public String toString() {
        return "InvalidSecondException:hour is not greater than 60";
    }
}

class Time {
    int h, m, s;

    void getTime(int h, int m, int s) throws InvalidHourException, InvalidMinuteException, InvalidSecondException {

        if (h < 0 || h > 24)
            throw new InvalidHourException();
        if (m < 0 || m > 60)
            throw new InvalidMinuteException();
        if (s < 0 || s > 60)
            throw new InvalidSecondException();

        this.h = h;
        this.m = m;
        this.s = s;

        System.out.println("Correct Time-> " + h + ":" + m + ":" + s);
    }
}

public class Main4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter hours:");
        int h = sc.nextInt();
        System.out.println("Enter minutes:");
        int m = sc.nextInt();
        System.out.println("Enter seconds:");
        int s = sc.nextInt();

        Time t = new Time();

        try {
            t.getTime(h, m, s);
        } catch (Exception e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occurred: " + e);
        }
    }
}
