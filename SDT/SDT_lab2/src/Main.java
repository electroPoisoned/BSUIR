import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Book> bookList = fillTheArray();
    public static void main(String[] args) {
        printBooksByAuthor("Jules Verne");
        printBookByPublishing("Reed Elsevier");
        printBooksPublishedAfter(1990);
    }

    static void printBooksByAuthor(String author){
        for (Book book:bookList) {
            if(book.getAuthor() == author){
                System.out.println(book);
            }
        }
    }

    static void printBookByPublishing(String publishing){
        for (Book book:bookList) {
            if(book.getPublishing() == publishing){
                System.out.println(book);
            }
        }
    }

    static void printBooksPublishedAfter(int publicationYear){
        for (Book book:bookList) {
            if(book.getPublicationYear() > publicationYear){
                System.out.println(book);
            }
        }
    }

    static ArrayList fillTheArray(){
        List<Book> bookList= new ArrayList<>();
        bookList.add(new Book("The Lord of the Rings: The Fellowship of the Ring",
                "J.R.R. Tolkien",
                "Reed Elsevier",
                1954,
                1120,
                99.99,
                "hard"));
        bookList.add(new Book("The Song of Ice and Fire: A Game of Thrones",
                "G.R.R. Martin",
                "Pearson",
                1996,
                855,
                99.99,
                "hard"));
        bookList.add(new Book("The Mysterious Island",
                "Jules Verne",
                "Thompson Reuters",
                1875,
                639,
                99.99,
                "hard"));
        
        return (ArrayList) bookList;
    }
}