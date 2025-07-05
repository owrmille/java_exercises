class StaticMembersExercises {
    public static void main(String[] args) {
        Cat c1 = new Cat("Fluffy", 7);
        Cat.getNumberOfCats();
        Cat c2 = new Cat("Pinky", 3);
        Cat.getNumberOfCats();
        Cat c3 = new Cat("Brownie", 8);
        Cat.getNumberOfCats();
        Cat c4 = new Cat("Mimi", 5);
        Cat.getNumberOfCats();
        Cat c5 = new Cat("Snowy", 2);
        Cat.getNumberOfCats();
        Cat c6 = new Cat("Billy", 3);
        Cat.getNumberOfCats();
        Cat c7 = new Cat("Pepe", 6);
        Cat.getNumberOfCats();

    }    
}

class Cat {
    String name;
    int age;
    static int counter = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
    }

    public static int getNumberOfCats() {
        return counter;
    }
}