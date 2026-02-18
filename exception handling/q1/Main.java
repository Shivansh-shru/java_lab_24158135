import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arr[] = new int[4];

        System.out.println("Enter the numbers");
        for (int i = 0; i <= 4; i++) {
            arr[i] = sc.nextInt();
        }

        try {
            System.out.println(arr[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception in thread \"main\" " + e);
        }
    }
}
