package food.vegetables;

public class Ginger extends Vegetable {
    private static final double CALORIES_PER_100G = 80;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Ginger(double weight) {
        super(weight);
    }
}