package LessSix;

public abstract class Animal {
    private String whoIsAnimal;
    private String name;
    private float howMuchRun;
    private float howMuchSwim;
    protected static int countAnimal = 0;


    public String getWhoIsAnimal() {
        return this.whoIsAnimal;
    }

    public String getName() {
        return this.name;
    }

    public float getHowMuchRun() {
        return this.howMuchRun;
    }

    public float getHowMuchSwim() {
        return this.howMuchSwim;
    }

    public Animal(String whoIsAnimal, String name, float howMuchRun, float howMuchSwim) {
        this.whoIsAnimal = whoIsAnimal;
        this.name = name;
        this.howMuchRun = howMuchRun;
        this.howMuchSwim = howMuchSwim;
        countAnimal++;
    }
    public boolean run (float dist){
        return (dist<=howMuchRun);
    }
    public boolean swim (float dist) {
        return (dist<=howMuchSwim);
    }

}
