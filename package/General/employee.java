package General;

public class employee {
    protected int empid;
    private String ename;
    protected double basic;

    public employee(int empid, String ename, double basic) {
        this.empid = empid;
        this.ename = ename;
        this.basic = basic;
    }

    public double earnings() {
        return basic + 0.8 * basic + 0.15 * basic;
    }

    public int getEmpid() {
        return empid;
    }

    public String getEname() {
        return ename;
    }
}
