package food.vegetables;

public class Asparagus extends Vegetable {
    private static final double CALORIES_PER_100G = 20;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Asparagus(double weight) {
        super(weight);
    }
}