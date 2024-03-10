package food.vegetables;

public class Eggplant extends Vegetable {
    private static final double CALORIES_PER_100G = 25;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Eggplant(double weight) {
        super(weight);
    }
}