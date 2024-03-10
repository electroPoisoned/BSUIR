package food.vegetables;

public class Radish extends Vegetable {
    private static final double CALORIES_PER_100G = 19;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Radish(double weight) {
        super(weight);
    }
}

