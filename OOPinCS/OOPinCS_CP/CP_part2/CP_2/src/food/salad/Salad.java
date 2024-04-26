package food.salad;

import food.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salad{
    List<Ingredient> salad = new ArrayList<>();

    public Salad() {
    }

    public void addIngredient(Ingredient ingredientToAdd){
        for (Ingredient ingredient : this.salad) {
            if(ingredient.getName().equals(ingredientToAdd.getName())){
                ingredient.setWeight(ingredient.getWeight() + ingredientToAdd.getWeight());
                return;
            }
        }
        this.salad.add(ingredientToAdd);
    }

    public void showCurrentIngredients(){
        System.out.println();
        for (Ingredient ingredient:this.salad) {
            System.out.println(ingredient.getName() + ": " + ingredient.getWeight() + "g");
        }
    }

    public void removeIngredient(String ingredientToRemove){
        boolean isFound = false;
        for (Ingredient ingredient:this.salad) {
            if (ingredient.getName().equalsIgnoreCase(ingredientToRemove)) {
                isFound = true;
                break;
            }
        }
        salad.removeIf(ingredient -> ingredient.getName().equalsIgnoreCase(ingredientToRemove));
        if(isFound){
            System.out.println("Ingredient removed.");
        }else{
            System.out.println("Ingredient not found.");
        }
    }

    public void changeIngredientWeight(String ingredientToChange){
        boolean isChanged = false;
        for (Ingredient ingredient : this.salad) {
            if((ingredient.getName()).equalsIgnoreCase(ingredientToChange)){
                Scanner scanner = new Scanner(System.in);
                System.out.println(ingredient.getName() + " current weight: " + ingredient.getWeight());
                System.out.print("Enter new weight: ");
                int newWeight = 0;
                do {
                    newWeight = scanner.nextInt();
                    if(newWeight<0){
                        System.out.println("Weight cant be less then 0! Try again.");
                    }
                }while (newWeight<0);
                ingredient.setWeight(newWeight);
                isChanged = true;
            }
        }
        if (!isChanged){
            System.out.println("Ingredient not found.");
        }else{
            System.out.println("Ingredient weight changed.");
        }
        salad.removeIf(ingredient -> ingredient.getWeight()==0);
    }

    public double countCalories(){
        double totalCalories = 0.0;
        for (Ingredient ingredient : salad) {
            totalCalories+=ingredient.getCALORIES_PER_100G()*ingredient.getWeight()/100;
        }

        return totalCalories;
    }

    public double countWeight(){
        double totalWeight = 0.0;
        for (Ingredient ingredient : salad) {
            totalWeight+=ingredient.getWeight();
        }

        return totalWeight;
    }
}