class Car {
    String brand;
    String color;
    int speed;

    Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0;
    }

    void start() {
        System.out.println(brand + " car is starting.");
    }

    void stop() {
        System.out.println(brand + " car is stopping.");
        speed = 0;
    }

    void accelerate(int increment) {
        speed += increment;
        System.out.println(brand + " car is accelerating. Speed is now " + speed + " km/h.");
    }

    void displayStatus() {
        System.out.println(brand + " car (Color: " + color + ") is moving at " + speed + " km/h.");
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Red");
        Car car2 = new Car("Honda", "Blue");

        car1.start();
        car1.accelerate(50);
        car1.displayStatus();
        car1.stop();

        car2.start();
        car2.accelerate(30);
        car2.displayStatus();
        car2.stop();
    }
}

