package lessSeven;

public class Main {
    private static float ADD_PLATE = 15;
    public static void main (String[] args){
        Plate plate = new Plate(40,70);
        Cat cat1 = new Cat("QOU",10);
        Cat cat2 = new Cat("WEW",35);
        Cat cat3 = new Cat("MAU",15);
        Cat [] cats = {cat1, cat2, cat3};
        plate.info();

        for (int i = 0; i < cats.length; i++) {

            if (cats[i].isSatiety() == false) {
                cats[i].eat(plate);
            }

            if (cats[i].isSatiety()) {
                System.out.printf("Кот %s с аппетитом %s сытый %n", cats[i].getName(), cats[i].getAppetite());
            } else {
                System.out.printf("Кот %s с аппетитом %s голодный %n", cats[i].getName(), cats[i].getAppetite());

            }
        }

        plate.info();
        System.out.printf("В тарелку дабавили %s еды %n", ADD_PLATE);
        plate.addFoodPlate(ADD_PLATE);
        plate.info();

        }

    }
