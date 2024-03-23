import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookCardService {
    public void task1(){
        BookCard bookCard1 = new BookCard("J.R.R. Tolkien",
                "The Lord of the Rings: The Fellowship of the Ring",
                "Reed Elsevier",
                1954,
                "84(4Bel)-44",
                "The story takes place in “Middle-Earth”," +
                        " an ancient land in which several human-like species- including the dwarves," +
                        " elves, and hobbits- coincide." +
                        " The story features a character introduced in a previous Middle-earth novel" +
                        " from Tolkien,Bilbo Baggins, who plays the same role," +
                        " after 60 years following his last appearance." +
                        " In celebration of the 111th birthday of Bilbo," +
                        " a relative of the family, Frodo Baggins,"+
                        " is given an all-powerful ring- said to have been forged by" +
                        " Sauron the Dark Lord and infused with magical powers.\n" +
                        "As Frodo soon finds out from Gandalf the Grey," +
                        " another wizard, the ring enables Sauron to enslave and dominate all of humanity," +
                        " which for obvious reasons, poses a threat to Bilbo and his entire species." +
                        " Determined, he sets off on an adventure to destroy the ring," +
                        " accompanied by some of his Hobbit-friends." +
                        " The trip intensifies as time goes on," +
                        " and as Bilbo explores the vast lands of Middle-earth," +
                        " he meets a number of new traveling companions." +
                        " Together, they conquest further and meet new challenges to approach.");

        BookCard bookCard2 = new BookCard("G.R.R. Martin",
                "The Song of Ice and Fire: A Game of Thrones",
                "Pearson",
                1996,
                "84(7Coc)-44",
                "Long ago, in a time forgotten," +
                        " a preternatural event threw the seasons out of balance."+
                        " In a land where summers can last decades and winters a lifetime," +
                        " trouble is brewing. The cold is returning," +
                        " and in the frozen wastes to the north of Winterfell," +
                        " sinister forces are massing beyond the kingdom’s protective Wall." +
                        " To the south, the king’s powers are failing—his most trusted adviser dead" +
                        " under mysterious circumstances and his enemies" +
                        " emerging from the shadows of the throne."+
                        " At the center of the conflict lie the Starks of Winterfell," +
                        " a family as harsh and unyielding as the frozen land they were born to." +
                        " Now Lord Eddard Stark is reluctantly summoned to serve as the king’s new Hand," +
                        " an appointment that threatens to sunder not only his family but the kingdom itself.");

        System.out.println(bookCard1.toString());
        System.out.println(bookCard2.toString());
    }

    public void task2(){
        List<BookCard> bookCardList = new ArrayList<>();

        bookCardList.add(new BookCard("J.R.R. Tolkien",
                "The Lord of the Rings: The Fellowship of the Ring",
                "Reed Elsevier",
                1954,
                "84(4GB)-44",
                "The story takes place in “Middle-Earth"));
        bookCardList.add(new BookCard("G.R.R. Martin",
                "The Song of Ice and Fire: A Game of Thrones",
                "Pearson",
                1996,
                "84(7USA)-44",
                "Long ago, in a time forgotten," +
                        " a preternatural event threw the seasons out of balance."));
        bookCardList.add(new BookCard("Jules Verne",
                "The Mysterious Island",
                "Thompson Reuters",
                1875,
                "84(4Fra)",
                "Five Union prisoners escape from the siege of Richmond in a balloon," +
                        " are blown off course and crash on an uncharted island."));

        System.out.println(bookCardList);
        sortList(bookCardList);
        System.out.println(bookCardList);
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
