// Q3: Employee, Manager (interface), and Head class
import java.util.Scanner;

interface Employee {
    void getDetails();
}

interface Manager extends Employee {
    void getDeptDetails();
}

class Head implements Manager {
    int empId;
    String empName;
    int deptId;
    String deptName;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee id - ");
        empId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter employee name - ");
        empName = sc.nextLine();
    }

    public void getDeptDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department id - ");
        deptId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter department name -");
        deptName = sc.nextLine();
    }

    public void printAll() {
        System.out.println("Employee id - " + empId);
        System.out.println("Employee name - " + empName);
        System.out.println("Department id - " + deptId);
        System.out.println("Department name -" + deptName);
    }

    public static void main(String[] args) {
        Head h = new Head();
        h.getDetails();
        h.getDeptDetails();
        h.printAll();
    }
}

public class Main {
    public static void main(String[] args) {
        Head.main(args);
    }
}
