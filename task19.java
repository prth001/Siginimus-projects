interface Shape {
    double calculateArea();
}

abstract class Rectangle implements Shape {
    protected double width;
    protected double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 5) {
            @Override
            public double calculateArea() {
                return width * height;
            }
        };

        Rectangle.Circle circle = new Rectangle.Circle(3);

        System.out.println("Area of rectangle: " + rectangle.calculateArea());
        System.out.println("Area of circle: " + circle.calculateArea());
    }
}

class Rectangle {
    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }
}
