package food.vegetables;

public class Cucumber extends Vegetable {
    private static final double CALORIES_PER_100G = 15;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Cucumber(double weight) {
        super(weight);
    }

}
