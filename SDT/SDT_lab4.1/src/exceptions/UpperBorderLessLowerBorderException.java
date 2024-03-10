package exceptions;

public class UpperBorderLessLowerBorderException extends RuntimeException{
    public UpperBorderLessLowerBorderException(){
        System.out.println("WARNING! Upper border should be more than lower border! Try again!");
    }
}
