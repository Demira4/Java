package LessSix;

public class Dog extends Animal {
    protected static int countDog;
    protected static String animalIs = "dog";
    Dog (String name, float howMuchRun, float howMuchSwiw){
        super(animalIs, name, howMuchRun, howMuchSwiw);
        countDog++;

    }
}
