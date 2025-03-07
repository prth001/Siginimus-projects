/*Task 1: Convert a Lambda Expression into a Method Reference*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("john", "alice", "bob", "eve");
        names.forEach(Main::printUpperCase);
    }

    public static void printUpperCase(String name) {
        System.out.println(name.toUpperCase());
    }
}


/*Task 2: Create an Interface with a Default Method and Override it in a Class*/

interface MyInterface {
    default void sayHello() {
        System.out.println("Hello from the default method!");
    }
    void greet();
}

class MyClass implements MyInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello from the overridden method!");
    }

    @Override
    public void greet() {
        System.out.println("Greetings from MyClass!");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.sayHello();
        myClass.greet();
    }
}
