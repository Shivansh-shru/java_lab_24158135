public class University {
    private String universityName;
    private String location;

    public University(String universityName, String location) {
        this.universityName = universityName;
        this.location = location;
    }

    class Department {
        private String deptName;
        private String hodName;

        public Department(String deptName, String hodName) {
            this.deptName = deptName;
            this.hodName = hodName;
        }

        public void display() {
            System.out.println("University Name: " + universityName);
            System.out.println("Location: " + location);
            System.out.println("Department Name: " + deptName);
            System.out.println("HOD Name: " + hodName);
        }
    }

    public static void main(String[] args) {
        University uni = new University("ABC University", "Delhi");
        University.Department dept = uni.new Department("Computer Science", "Dr. Sharma");
        dept.display();
    }
}
