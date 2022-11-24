package lessSeven;

public class Plate {
    private float food;
    private float volume;


    public float getFood() {
        return food;
    }

    public void setFood(float food) {
        this.food = food;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public Plate(float food, float volume) {
        this.food = food;
        this.volume = volume;

    }

    public void eatPlate(float eat){

       if (eat <= food) {
           food = food - eat;

       } else {
           System.out.println("В тарелке недостаточно еды");
       }
    }
    public void addFoodPlate(float f){

        food += f;
    }

    public void info(){
        System.out.println("В тарелке " + food + " еды");
    }

}
