package lessSeven;

public class Cat {
    private String name;
    private float appetite;
    private boolean satiety;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAppetite() {
        return appetite;
    }

    public void setAppetite(float appetite) {
        this.appetite = appetite;
    }


    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public Cat(String name, float appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.eatPlate(appetite);
            satiety = true;
        } else {
            satiety = false;
        }

    }
}
