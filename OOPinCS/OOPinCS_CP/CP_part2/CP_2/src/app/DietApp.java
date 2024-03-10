package app;

import dietService.DietService;

import java.util.Scanner;

public class DietApp {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        DietService dietService = new DietService();
        menu(dietService);
    }

    public static void menu(DietService dietService){
        String choice;

        do {
            System.out.print("\n\t\tMENU:\n" +
                    "1.Make Salad/Add Ingredient\n" +
                    "2.Count Calories\n" +
                    "3.Count Weight\n" +
                    "4.Count Calories per 100g\n" +
                    "5.Remove Ingredient\n" +
                    "6.Change Ingredient weight\n" +
                    "7.Show Current Ingredients list\n" +
                    "0.Exit\n");
            System.out.println("\nChoose the action: ");
            choice = scanner.next();
            switch (choice){
                case "1" -> dietService.makeSalad();
                case "2" -> dietService.countCalories();
                case "3" -> dietService.countWeight();
                case "4" -> dietService.countCaloriesPer100g();
                case "5" -> dietService.removeIngredient();
                case "6" -> dietService.changeIngredientWeight();
                case "7" -> dietService.showRecipe();
                case "0" -> System.exit(0);
                default -> System.out.println("The selected item doesnt exist! Try again.");
            }
        }while (true);
    }
}
