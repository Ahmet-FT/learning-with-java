import java.util.ArrayList;

class Animal {
    private boolean isMammal;

    public Animal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void voice() {
        System.out.println("Animal makes a sound");
    }

    public final void sleep() {
        System.out.println("Animal is sleeping");   
    }

    @Override
    public String toString() {
        return "Animal " + isMammal();
    }
}

class Duck extends Animal {
    public Duck(boolean isMammal) {
        super(isMammal);
    }

    @Override
    public void voice() {
        System.out.println("Duck quacks");
    }

    @Override
    public String toString() {
        return "Duck " + isMammal();
    }
}

class Fish extends Animal {
    public Fish(boolean isMammal) {
        super(isMammal);
    }

    @Override
    public void voice() {
        System.out.println("Fish bubbles");
    }

    @Override
    public String toString() {
        return "Fish " + isMammal();
    }
}

class Zebra extends Animal {
    public Zebra(boolean isMammal) {
        super(isMammal);
    }

    @Override
    public void voice() {
        System.out.println("Zebra neighs");
    }

    @Override
    public String toString() {
        return "Zebra " + isMammal();
    }
}

public class Lab9 {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Animal(true));
        animals.add(new Animal(false));
        animals.add(new Duck(false));
        animals.add(new Duck(false));
        animals.add(new Duck(false));
        animals.add(new Fish(false));
        animals.add(new Fish(false));
        animals.add(new Zebra(true));
        animals.add(new Zebra(true));
        animals.add(new Zebra(true));
        animals.add(new Zebra(true));

        for (Animal animal : animals) 
        {
            System.out.println(animal);
            animal.voice();
            animal.sleep();
        }
    }
}
          

