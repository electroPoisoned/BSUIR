/*Book: id, Название, Автор(ы), Издательство, Год издания, Количество страниц, Цена, Тип переплета. Создать массив объектов.
Вывести:
a) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года. */

public class Book {
    private int id;
    private String bookTitle;
    private String author;
    private String publishing;
    private int publicationYear;
    private int numOfPages;
    private double price;
    private String cover;
    static int numberOfBooks = 0;

    public Book(String bookTitle,
                String author,
                String publishing,
                int publicationYear,
                int numOfPages,
                double price,
                String cover) {
        numberOfBooks++;
        this.id = numberOfBooks;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publishing = publishing;
        this.publicationYear = publicationYear;
        this.numOfPages = numOfPages;
        this.price = price;
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\n\tid: " + this.id + "\n" +
                "\tbookTitle: '" + bookTitle + "\'\n" +
                "\tauthor: '" + author + "\'\n" +
                "\tpublishing: '" + publishing + "\'\n" +
                "\tpublicationYear: " + publicationYear + "\n" +
                "\tnumOfPages: " + numOfPages + "\n" +
                "\tprice: " + price + "\n" +
                "\tcover: '" + cover + "\'\n" +
                "}\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
