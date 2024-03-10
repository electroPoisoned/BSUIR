package dietService;

import food.dressings.*;
import food.salad.Salad;
import food.vegetables.*;

import java.util.Scanner;

public class DietService {
    private static Salad salad = new Salad();
    private static Scanner scanner = new Scanner(System.in);

    public DietService() {
    }

    public void makeSalad(){
        System.out.println("1.Asparagus" +
                "\n2.Broccoli" +
                "\n3.Cabbage" +
                "\n4.Celery" +
                "\n5.Corn" +
                "\n6.Courage" +
                "\n7.Cucumber" +
                "\n8.Eggplant" +
                "\n9.Ginger" +
                "\n10.Green Beans" +
                "\n11.Onion" +
                "\n12.Pea" +
                "\n13.Pepper" +
                "\n14.Potato" +
                "\n15.Radish" +
                "\n16.Tomato" +
                "\n0.Stop choosing ingredients");

        String choice;
        do{
            System.out.println("\tChoose the ingredient:");
            choice = scanner.next();


            double weight = 0;
            do {
                if (!choice.equals("0") && Integer.parseInt(choice) < 17 && Integer.parseInt(choice) >=0) {
                    System.out.println("\tEnter the weight of chosen ingredient");
                    weight = scanner.nextDouble();
                    if (weight < 0) {
                        System.out.println("\tWeight cant be less then 0! Try again.");
                    }
                }
            }while (weight<0);
            switch (choice){
                case "0" -> System.out.println("\nStop choosing ingredients");
                case "1" -> salad.addIngredient(new Asparagus(weight));
                case "2" -> salad.addIngredient(new Broccoli(weight));
                case "3" -> salad.addIngredient(new Cabbage(weight));
                case "4" -> salad.addIngredient(new Celery(weight));
                case "5" -> salad.addIngredient(new Corn(weight));
                case "6" -> salad.addIngredient(new Courgette(weight));
                case "7" -> salad.addIngredient(new Cucumber(weight));
                case "8" -> salad.addIngredient(new Eggplant(weight));
                case "9" -> salad.addIngredient(new Ginger(weight));
                case "10" -> salad.addIngredient(new GreenBeans(weight));
                case "11" -> salad.addIngredient(new Onion(weight));
                case "12" -> salad.addIngredient(new Pea(weight));
                case "13" -> salad.addIngredient(new Pepper(weight));
                case "14" -> salad.addIngredient(new Potato(weight));
                case "15" -> salad.addIngredient(new Radish(weight));
                case "16" -> salad.addIngredient(new Tomato(weight));
                default -> System.out.println("The selected item doesnt exist! Try again.");
            }
        }while (!choice.equals("0"));


        System.out.println("\n1.Mayonnaise" +
                "\n2.Olive Oil" +
                "\n3.Sour Cream" +
                "\n4.Vinegar" +
                "\n5.GreekYogurt" +
                "\n6.Stop choosing dressing" +
                "\n0.No dressing\n");
        do{
            System.out.println("\tChoose the dressing: ");
            choice = scanner.next();

            double weight = 0;
            do {
                if (!choice.equals("0") && Integer.parseInt(choice) < 6 && Integer.parseInt(choice) >= 0) {
                    System.out.println("\tEnter the weight of chosen dressing: ");
                    weight = scanner.nextDouble();
                }
                if(weight<0){
                    System.out.println("Weight cant be less then 0! Try again.");
                }
            }while (weight<0);
            switch (choice){
                case "0" -> System.out.println("No dressing added.");
                case "1" -> salad.addIngredient(new Mayonnaise(weight));
                case "2" -> salad.addIngredient(new OliveOil(weight));
                case "3" -> salad.addIngredient(new SourCream(weight));
                case "4" -> salad.addIngredient(new Vinegar(weight));
                case "5" -> salad.addIngredient(new GreekYogurt(weight));
                case "6" -> System.out.println("Stop choosing dressing.");
                default -> System.out.println("The selected item doesnt exist! Try again.");
            }
        }while (!choice.equals("0") && !choice.equals("6"));

        salad.showCurrentIngredients();
    }

    public void countCalories(){
        System.out.println("\nThe total calorie content of the salad: " + salad.countCalories());
    }

    public void countWeight(){
        System.out.println("\nThe total weight of the salad: " + salad.countWeight());
    }

    public void countCaloriesPer100g(){
        System.out.println("\nCalorie content of 100g of salad: " +
                salad.countCalories()/salad.countWeight()*100);
    }

    public void removeIngredient(){
        salad.showCurrentIngredients();
        System.out.print("\nChoose ingredient to remove: ");
        String ingredientToRemove = scanner.next();

        salad.removeIngredient(ingredientToRemove);
        System.out.println("\n\tCurrent Ingredient list: ");
        salad.showCurrentIngredients();
    }

    public void showRecipe(){
        System.out.println("\tRecipe:");
        salad.showCurrentIngredients();
        System.out.println();
    }

    public void changeIngredientWeight(){
        salad.showCurrentIngredients();
        System.out.print("\nChoose ingredient to change: ");
        String ingredientToChange = scanner.next();
        salad.changeIngredientWeight(ingredientToChange);
    }
}