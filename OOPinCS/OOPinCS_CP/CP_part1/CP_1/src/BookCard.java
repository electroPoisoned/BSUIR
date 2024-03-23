public class BookCard {
    private String author;
    private String title;
    private String publishing;
    private int publicationYear;
    private String BBK;
    private String comment;

    public BookCard(String author,
                    String title,
                    String publishing,
                    int publicationYear,
                    String BBK,
                    String comment) {
        this.author = author;
        this.title = title;
        this.publishing = publishing;
        this.publicationYear = publicationYear;
        this.BBK = BBK;
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getBBK() {
        return BBK;
    }

    public void setBBK(String BBK) {
        this.BBK = BBK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "\nBookCard{" +
                "\nauthor:'" + author + '\'' +
                "\ntitle:'" + title + '\'' +
                "\npublishing:'" + publishing + '\'' +
                "\npublicationYear:" + publicationYear +
                "\nBBK " + BBK + "\n" +
                '}';
    }
}
