package exceptions;

public class GenreNotExistException extends RuntimeException{
    public GenreNotExistException(String genre){
        System.out.println("WARNING! Genre '" + genre + "' isn't exist! Try again!");
    }
}
