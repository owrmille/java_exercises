public class ConstructorsExercises {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        System.out.println("Name: " + e1.name);
        System.out.println("Salary: " + e1.salary);
        System.out.println("Address: " + e1.address);
        System.out.println();
        
        Employee e2 = new Employee("Olly", 30);
        System.out.println("Name: " + e2.name);
        System.out.println("Salary: " + e2.salary);
        System.out.println("Address: " + e2.address);
        System.out.println();

        Employee e3 = new Employee("Becky", 10, "Fls str.1");
        System.out.println("Name: " + e3.name);
        System.out.println("Salary: " + e3.salary);
        System.out.println("Address: " + e3.address);

        System.out.println("\n");

        Phone p1 = new Phone("Nick", "232-81");
        System.out.println("ownerName: " + p1.ownerName);
        System.out.println("number: " + p1.number);
        System.out.println("countryCode: " + p1.countryCode);
        System.out.println("cityCode: " + p1.cityCode);
        System.out.println();

        Phone p2 = new Phone("Mia", "+8 ", "917 ", "956-54");
        System.out.println("ownerName: " + p2.ownerName);
        System.out.println("number: " + p2.number);
        System.out.println("countryCode: " + p2.countryCode);
        System.out.println("cityCode: " + p2.cityCode);
    }
}

class Phone {

    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    Phone(String ownerName, String number) {
        this.ownerName = ownerName;
        this.number = number;
    }

    Phone(String ownerName, String countryCode, String cityCode, String number) {
        this(ownerName, number);
        this.countryCode = countryCode;
        this.cityCode = cityCode;
    }
}

class Employee {

    String name;
    int salary;
    String address;

    Employee() {
        this.name = "unknown";
        this.salary = 0;
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.address = "unknown";
    }

    Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}