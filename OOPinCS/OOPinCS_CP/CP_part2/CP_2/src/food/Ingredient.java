package food;

public abstract class Ingredient {
    private double weight;
    private String name;

    public Ingredient(double weight) {
        this.weight = weight;
        this.name = String.valueOf(this.getClass()).replaceAll(".*\\.", "");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double getCALORIES_PER_100G();
}