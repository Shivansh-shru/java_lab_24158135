package Marketing;
import General.employee;
import java.util.Scanner;

public class sales extends employee {
    public sales(int empid, String ename, double basic) {
        super(empid, ename, basic);
    }

    public double tallowance() {
        return 0.05 * earnings();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee id and employee name: ");
        int empid = sc.nextInt();
        String ename = sc.next();
        System.out.print("Enter the basic salary: ");
        double basic = sc.nextDouble();
        sales s = new sales(empid, ename, basic);
        double totalEarning = s.earnings();
        System.out.println("The emp id of the employee is " + s.getEmpid());
        System.out.println("The total earning is " + totalEarning);
    }
}
