package food.vegetables;

public class Broccoli extends Vegetable {
    private static final double CALORIES_PER_100G = 34;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Broccoli(double weight) {
        super(weight);
    }
}