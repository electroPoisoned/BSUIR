package food.vegetables;

public class Potato extends Vegetable {
    private static final double CALORIES_PER_100G = 77;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Potato(double weight) {
        super(weight);
    }
}
