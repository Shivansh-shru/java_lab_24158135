package Marketing;

import General.employee;

public class sales extends employee {

    public sales(int id, String name, double basic) {
        super(id, name, basic);
    }

    public double tallowance() {
        return 0.05 * earnings();
    }
}
