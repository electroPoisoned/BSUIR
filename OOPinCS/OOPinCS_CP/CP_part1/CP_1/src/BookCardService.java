import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookCardService {
    public void task1(){
        BookCard bookCard1 = new BookCard("J.R.R. Tolkien",
                "The Lord of the Rings: The Fellowship of the Ring",
                "Reed Elsevier",
                1954,
                "84(4Bel)-44",
                "The story takes place in Middle-Earth");
        bookCard1.setRating(5.6);

        BookCard bookCard2 = new BookCard("G.R.R. Martin",
                "The Song of Ice and Fire: A Game of Thrones",
                "Pearson",
                1996,
                "84(7Coc)-44",
                "Long ago, in a time forgotten, a preternatural event threw the seasons out of balance.");
        bookCard2.setRating(5.9);

        System.out.println(bookCard1.toString());
        System.out.println(bookCard2.toString() + "\n");
    }

    public void task2(){
        List<BookCard> bookCardList = new ArrayList<>();

        bookCardList.add(new BookCard("J.R.R. Tolkien",
                "The Lord of the Rings: The Fellowship of the Ring",
                "Reed Elsevier",
                1954,
                "84(4GB)-44",
                "The story takes place in “Middle-Earth"));
        bookCardList.get(0).setRating(5.6);
        bookCardList.add(new BookCard("G.R.R. Martin",
                "The Song of Ice and Fire: A Game of Thrones",
                "Pearson",
                1996,
                "84(7USA)-44",
                "Long ago, in a time forgotten," +
                        " a preternatural event threw the seasons out of balance."));
        bookCardList.get(1).setRating(5.9);
        bookCardList.add(new BookCard("Jules Verne",
                "The Mysterious Island",
                "Thompson Reuters",
                1875,
                "84(4Fra)",
                "Five Union prisoners escape from the siege of Richmond in a balloon," +
                        " are blown off course and crash on an uncharted island."));
        bookCardList.get(2).setRating(5.3);

        System.out.println(bookCardList + "\n");
        sortList(bookCardList);
        System.out.println(bookCardList + "\n");
    }

    public static void sortList(List list){
        list.sort(new Comparator<BookCard>() {
            @Override
            public int compare(BookCard o1, BookCard o2) {
                return Integer.compare(o1.getPublicationYear(), o2.getPublicationYear());
            }
        });
    }
}
