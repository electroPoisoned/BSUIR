package food.dressings;

public class SourCream extends Dressing{
    private static final double CALORIES_PER_100G = 193;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public SourCream(double weight) {
        super(weight);
    }
}