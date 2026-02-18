
class Fruit {
    void show() {
        System.out.println("This is a fruit.");
    }
}

class Apple extends Fruit {
    void show() {
        System.out.println("This is an Apple.");
    }
}


class Banana extends Fruit {
    void show() {
        System.out.println("This is a Banana.");
    }
}

// Child Class 3
class Cherry extends Fruit {
    void show() {
        System.out.println("This is a Cherry.");
    }
}

public class q1 {
    public static void main(String[] args) {

        
        Fruit f;

       
        f = new Apple();
        f.show();

        f = new Banana();
        f.show();

        f = new Cherry();
        f.show();
    }
}
