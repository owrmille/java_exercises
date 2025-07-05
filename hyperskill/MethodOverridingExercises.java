class MethodOverridingExercises {
    public static void main(String[] args) {
        Triangle t = new Triangle(2, 3);
        System.out.println("Area of triangle: " + t.area());
        Circle c = new Circle(1);
        System.out.println("Area of circle: " + c.area());
        Square s = new Square(6);
        System.out.println("Area of square: " + s.area());
        Rectangle r = new Rectangle(7, 3);
        System.out.println("Area of rectangle: " + r.area());
    }
}

class Shape {
    public double area() {
        return 0;
    }
}

class Triangle extends Shape {
    double height;
    double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    @Override
    public double area() {
        return base * height / 2;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape {
    double side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}