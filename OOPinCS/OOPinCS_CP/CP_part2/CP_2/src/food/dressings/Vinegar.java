package food.dressings;

public class Vinegar extends Dressing{
    private static final double CALORIES_PER_100G = 18;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Vinegar(double weight) {
        super(weight);
    }
}
