public class OopExercises {
    class Book {
        String title;
        int yearOfPublishing;
        boolean isAvailable;
    }

    class Time {
        int hours, minutes, seconds;
    }

    class Account {
        long balance;
        String ownerName;
        boolean locked;
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 5;
        System.out.println(c.getLength() + "; " + c.getArea());
        Box b = new Box();
        System.out.println(b.getVolume());

        Complex number = new Complex();
        number.real = 10;
        number.image = 4;
        // math expression of number = 10.0 + 4.0i
        System.out.println("x: " + number.real + " + " + number.image + "i");
        
        Complex anotherNumber = new Complex();
        anotherNumber.real = 6;
        anotherNumber.image = 6;
        System.out.println("y: " + anotherNumber.real + " + " + anotherNumber.image + "i");
        // math expression of anotherNumber = 6.0 + 6.0i

        number.add(anotherNumber); // number = 16.0 + 10.0i
        System.out.println("modified x: " + number.real + " + " + number.image + "i");

    }
}
class Circle {
    double radius;

    public double getLength() {
        return 2 * Math.PI * radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Box {
    double height;
    double width;
    double length;

    public Box() {
        height = 3;
        width = 3;
        length = 3;     
    }
    public double getVolume() {
        return height * width * length;
    }
}

class Complex {
    double real;
    double image;

    public void add(Complex num) {
        real += num.real;
        image += num.image;
    }

    public void subtract(Complex num) {
        real -= num.real;
        image -= num.image;
    }
}