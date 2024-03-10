package food.vegetables;

public class Pea extends Vegetable {
    private static final double CALORIES_PER_100G = 81;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Pea(double weight) {
        super(weight);
    }
}