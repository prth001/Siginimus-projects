package signimus;

class Car {
    String brand;
    String color;
    int speed;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }

    public void start() {
        System.out.println(brand + " " + color + " is starting.");
    }

    public void stop() {
        System.out.println(brand + " " + color + " is stopping.");
        speed = 0;
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println(brand + " " + color + " is accelerating. Current speed: " + speed + " km/h.");
    }

    public void displaySpeed() {
        System.out.println(brand + " " + color + " is currently moving at " + speed + " km/h.");
    }
}

public class oops {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Red");
        Car car2 = new Car("Honda", "Blue");

        car1.start();
        car1.accelerate(50);
        car1.displaySpeed();
        car1.stop();

        System.out.println();

        car2.start();
        car2.accelerate(30);
        car2.displaySpeed();
        car2.stop();
    }
}

