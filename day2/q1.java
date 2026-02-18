interface Motor {
    int capacity = 5;
    void run();
    void consume();
}

class WashingMachine implements Motor {

    public void run() {
        System.out.println("Washing Machine is running.");
    }

    public void consume() {
        System.out.println("Motor is consuming power.");
    }
}

public class q1 {
    public static void main(String[] args) {

        WashingMachine obj = new WashingMachine();

        obj.run();
        obj.consume();

        System.out.println("Capacity of the motor is " + Motor.capacity);
    }
}
