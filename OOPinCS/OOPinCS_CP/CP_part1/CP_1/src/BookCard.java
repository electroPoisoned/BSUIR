public class BookCard {
    private String author;
    private String title;
    private String publishing;
    private int publicationYear;
    private String BBK;
    private String comment;
    private double rating;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 6) {
            throw new IllegalArgumentException("Rating must be between 0 and 6");
        }
        this.rating = rating;
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
        return "BookCard{" +
                "\nauthor='" + author + '\'' +
                "\ntitle='" + title + '\'' +
                "\npublishing='" + publishing + '\'' +
                "\npublicationYear=" + publicationYear +
                "\nBBK=<" + BBK + '>' +
                "\nrating=" + rating +
                "\n}\n";
    }
}
