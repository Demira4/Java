package LessSix;

public class Cat extends Animal {
private static String animalIs = "cat";
protected static int countCat = 0;

Cat (String name, float howMuchRun, float howMuchSwim){
    super(animalIs, name,howMuchRun, howMuchSwim);
    countCat++;
}
@Override
public boolean swim(float dist) {
    return false;
}

}
