import java.util.Scanner;

class AnnotationsExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("Animal")) {
            Animal a = new Animal();
            System.out.println(a.makeSound());
        } else if (input.equals("Dog")) {
            Dog d = new Dog();
            System.out.println(d.makeSound());
        }
        scanner.close();
    }
}

class Animal {
    public String makeSound() {
        return "animal sound";
    }
}

class Dog extends Animal {
    @Override
    public String makeSound() {
        return "bark";
    }
}