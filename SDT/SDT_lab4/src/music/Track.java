package music;

import java.util.Objects;

public class Track {
    private int duration;
    private String author;
    private String title;
    private MusicStyles musicStyle;

    public Track(int duration, String author, String title, MusicStyles musicStyle) {
        this.duration = duration;
        this.author = author;
        this.title = title;
        this.musicStyle = musicStyle;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public MusicStyles getMusicStyle() {
        return musicStyle;
    }

    public void setMusicStyle(MusicStyles musicStyle) {
        this.musicStyle = musicStyle;
    }

    @Override
    public String toString() {
        return "Track{" +
                "\n\tduration:" + duration +
                "\n\tauthor:'" + author + '\'' +
                "\n\ttitle:'" + title + '\'' +
                "\n\tmusicStyle:" + musicStyle +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return duration == track.duration && Objects.equals(author, track.author) && Objects.equals(title, track.title) && musicStyle == track.musicStyle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, author, title, musicStyle);
    }
}
