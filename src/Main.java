public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Bobik");
        Cat catMurka = new Cat("Murka");

        dogBobik.run(150);
        dogBobik.run(600);
        dogBobik.swim(5);
        dogBobik.swim(15);

        catMurka.run(100);
        catMurka.run(250);
        catMurka.swim(10);

        System.out.println("Dog count: " + Dog.getCount());
        System.out.println("Cat count: " + Cat.getCount());
        System.out.println("Animal count: " + Animal.getCount());
    }
}
