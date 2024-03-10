package food.vegetables;

public class Celery extends Vegetable {
    private static final double CALORIES_PER_100G = 14;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Celery(double weight) {
        super(weight);
    }
}