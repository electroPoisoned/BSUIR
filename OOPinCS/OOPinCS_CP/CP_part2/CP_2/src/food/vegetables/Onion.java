package food.vegetables;

public class Onion extends Vegetable {
    private static final double CALORIES_PER_100G = 40;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Onion(double weight) {
        super(weight);
    }
}
