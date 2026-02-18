import java.util.Scanner;

class NegativeNumberException extends Exception {
    public String toString() {
        return "NegativeNumberException: number should be positive";
    }
}

class Test {
    void ProcessInput(int n) throws NegativeNumberException {
        if (n < 0)
            throw new NegativeNumberException();
        else
            System.out.println("Double value: " + (2 * n));
    }
}

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();

        Test t = new Test();

        try {
            t.ProcessInput(num);
        } catch (NegativeNumberException e) {
            System.out.println("Caught the exception");
            System.out.println("Exception occurred: " + e);
        }
    }
}
