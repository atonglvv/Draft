package basics.base;

/**
 * @Auther: carver
 * @Date: 2019/4/11 08:34
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
public class Animal {
    private double weight;

    public Animal() {}

    public Animal(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public void move() {
        System.out.println("animal moving");
    }

    public void sleep() {
        System.out.println("animal sleepping");
    }

}

class Fish extends Animal {
    @Override
    public void move() {
        System.out.println("swimming");
    }
}

class Bird extends Animal {

    @Override
    public void move() {
        System.out.println("flying");
    }

}

class AnimalMain {
    public static void main(String[] args) {
        Animal aniamala = new Bird();
        Fish fishb = new Fish();
        aniamala.move();
        aniamala.sleep();
        fishb.sleep();
        fishb.move();
    }
}
