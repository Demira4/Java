package LessSix;

import java.util.Scanner;

import static LessSix.Animal.countAnimal;
import static LessSix.Cat.countCat;
import static LessSix.Dog.countDog;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main (String[] arg){
        System.out.println("Введите дистанцию, которую должны пробежать животные: ");
        float distLengthRun = scanner.nextFloat();
        System.out.println("Введите дитанцию, которую должны проплыть животные: ");
        float distLengthSwim = scanner.nextFloat();
        int win = 1;
        int fail = 0;

        Cat cat1 = new Cat("Barsik", 200, 0);
        Cat cat2 = new Cat("Vaska", 150, 0);
        Cat cat3 = new Cat("Pushok", 180, 0);
        Dog dog1 = new Dog("Sharik", 500,10);
        Dog dog2 = new Dog("Reks", 450,10);
        Dog dog3 = new Dog("Gav", 400,10);


        Animal [] animal = {cat1,cat2,cat3,dog1,dog2,dog3};

        for (int i = 0; i< animal.length; i++){
            if (animal[i].getHowMuchRun()>=distLengthRun) {
                System.out.println(animal[i].getWhoIsAnimal()+ animal[i].getName() + " успешно преодолевает дистанцию " + distLengthRun + "м" );

            } else {
                System.out.println(animal[i].getWhoIsAnimal() +" "+ animal[i].getName() + " не может преодолеть дистанцию " + distLengthRun + "м");
                System.out.printf("потому что %s %s может преодолеть максимум %s м %n", animal[i].getWhoIsAnimal(),animal[i].getName(), animal[i].getHowMuchRun());
            }
            if (animal[i].getHowMuchSwim()>=distLengthSwim) {
                System.out.println(animal[i].getWhoIsAnimal()+ animal[i].getName() + " успешно проплывает дистанцию " + distLengthSwim + "м" );

            } else {
                System.out.println(animal[i].getWhoIsAnimal() +" "+ animal[i].getName() + " не может проплыть дистанцию " + distLengthSwim + "м");
                System.out.printf("потому что %s %s может проплыть максимум %s м %n", animal[i].getWhoIsAnimal(),animal[i].getName(), animal[i].getHowMuchSwim());
            }
        }
        System.out.println("**************");
        System.out.printf("Всего участвовало %s животных: %s собак и %s кошек", countAnimal, countDog, countCat );


    }
}
