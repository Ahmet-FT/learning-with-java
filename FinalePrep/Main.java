class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal constructor called: " + name);
        System.out.println("Animal constructor called age is: " + age);

    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age); // Üst sınıfın constructor'ını çağırıyor
        System.out.println("Dog constructor called: " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 5);
    }
}
