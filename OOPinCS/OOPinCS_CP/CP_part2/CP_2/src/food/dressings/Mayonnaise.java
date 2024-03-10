package food.dressings;

public class Mayonnaise extends Dressing{
    private static final double CALORIES_PER_100G = 680;

    public double getCALORIES_PER_100G() {
        return CALORIES_PER_100G;
    }

    public Mayonnaise(double weight) {
        super(weight);
    }
}
