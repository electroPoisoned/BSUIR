package food.dressings;

public class OliveOil extends Dressing{
    private static final double CALORIES_PER_100G = 884;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public OliveOil(double weight) {
        super(weight);
    }
}