package food.dressings;

public class GreekYogurt extends Dressing{
    private static final double CALORIES_PER_100G = 62.8;

    public GreekYogurt(double weight) {
        super(weight);
    }

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }
}