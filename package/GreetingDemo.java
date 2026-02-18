interface Greeting {
    void sayHello();
}

public class GreetingDemo {
    public static void main(String[] args) {
        Greeting greet = new Greeting() {
            public void sayHello() {
                System.out.println("Hello! Welcome to the anonymous inner class greeting demo.");
            }
        };
        greet.sayHello();
    }
}
