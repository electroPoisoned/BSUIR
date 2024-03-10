package exceptions;

public class DurationLessZeroException extends RuntimeException{
    public DurationLessZeroException(){
        System.out.println("WARNING! Duration should be more than 0! Try again!");
    }
}
