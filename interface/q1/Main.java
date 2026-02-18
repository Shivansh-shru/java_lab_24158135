// Q1: Motor interface and WashingMachine class
interface Motor {
    int capacity = 100; // interface variables are public static final by default
    void run();
    void consume();
}

class WashingMachine implements Motor {
    public void run() {
        System.out.println("Washing machine is running");
    }
    public void consume() {
        System.out.println("Washing machine is consuming power");
    }
}

public class Main {
    public static void main(String[] args) {
        WashingMachine wm = new WashingMachine();
        wm.run();
        wm.consume();
        System.out.println("Capacity of the motor is " + Motor.capacity);
    }
}
