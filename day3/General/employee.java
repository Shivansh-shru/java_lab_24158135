package General;

public class employee {

    protected int empid;
    private String ename;
    protected double basic;

    public employee(int id, String name, double basic) {
        this.empid = id;
        this.ename = name;
        this.basic = basic;
    }

    public double earnings() {
        double da = 0.80 * basic;
        double hra = 0.15 * basic;
        return basic + da + hra;
    }
}
