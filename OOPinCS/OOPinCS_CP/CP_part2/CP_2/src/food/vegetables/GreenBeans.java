package food.vegetables;

public class GreenBeans extends Vegetable {
    private static final double CALORIES_PER_100G = 31;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public GreenBeans(double weight) {
        super(weight);
    }
}
