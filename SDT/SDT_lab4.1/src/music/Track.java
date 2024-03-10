package music;

public abstract class Track {
    private String title;
    private String author;
    private int duration;
    private String genreName;

    public Track(String title, String author, int duration) {
        this.title = title;
        this.author = author;
        this.duration = duration;
        this.genreName = String.valueOf(this.getClass()).replaceAll("class music\\.styles\\.","");
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "\n\tduration:" + duration +
                "\n\tauthor:'" + author + '\'' +
                "\n\ttitle:'" + title + '\'' +
                "\n\tgenreName:" + genreName +
                "\n}";
    }
}
