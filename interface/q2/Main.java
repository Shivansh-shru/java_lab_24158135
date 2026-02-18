// Q2: Salary interface, Manager, and Substaff classes
import java.util.Scanner;

interface Salary {
    void earnings();
    void deductions();
    void bonus();
}

class Manager implements Salary {
    double basic;
    Manager(double basic) {
        this.basic = basic;
    }
    public void earnings() {
        double earn = basic + 0.8 * basic + 0.15 * basic;
        System.out.println("Earnings - " + (int)earn);
    }
    public void deductions() {
        double ded = 0.12 * basic;
        System.out.println("Deduction -" + (int)ded);
    }
    // No bonus() implementation here
    public void bonus() {
        // Not implemented in Manager
    }
}

class Substaff extends Manager {
    Substaff(double basic) {
        super(basic);
    }
    @Override
    public void bonus() {
        double bon = 0.5 * basic;
        System.out.println("Bonus - " + (int)bon);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Basic salary - ");
        double basic = sc.nextDouble();
        Substaff s = new Substaff(basic);
        s.earnings();
        s.deductions();
        s.bonus();
    }
}

public class Main {
    public static void main(String[] args) {
        Substaff.main(args);
    }
}
