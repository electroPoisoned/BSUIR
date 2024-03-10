package food.vegetables;

public class Pepper extends Vegetable {
    private static final double CALORIES_PER_100G = 40;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Pepper(double weight) {
        super(weight);
    }
}