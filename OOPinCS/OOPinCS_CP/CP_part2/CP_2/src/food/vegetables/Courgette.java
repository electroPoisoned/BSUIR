package food.vegetables;

public class Courgette extends Vegetable {
    private static final double CALORIES_PER_100G = 17;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Courgette(double weight) {
        super(weight);
    }
}