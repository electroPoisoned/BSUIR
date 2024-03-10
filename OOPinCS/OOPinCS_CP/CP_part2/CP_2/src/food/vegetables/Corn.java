package food.vegetables;

public class Corn extends Vegetable {
    private static final double CALORIES_PER_100G = 86;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Corn(double weight) {
        super(weight);
    }
}