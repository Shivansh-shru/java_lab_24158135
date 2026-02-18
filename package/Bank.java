public class Bank {
    private double principal = 1000; // Example non-static member

    static class InterestCalculator {
        public static double calculateSimpleInterest(double p, double r, double t) {
            return (p * r * t) / 100;
        }
        // Cannot access non-static member 'principal' directly here
    }

    public static void main(String[] args) {
        double si = InterestCalculator.calculateSimpleInterest(1000, 5, 2);
        System.out.println("Simple Interest: " + si);
        // The following line would cause an error:
        // System.out.println(principal); // Not accessible
    }
}
