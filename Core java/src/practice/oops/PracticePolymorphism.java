package practice.oops;
class Animal {
    void sound() {
        System.out.println("animal make sound...");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("woof woof...");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("meow meow...");
    }
}

public class PracticePolymorphism {
    public static void main(String[] args) {
        Animal dog = new Dog();  // parent reference, child object --> that's the main power polymorphism gives
        dog.sound();  
        
        Animal cat = new Cat();
        cat.sound();
    }
}
