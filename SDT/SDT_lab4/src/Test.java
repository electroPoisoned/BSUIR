import music.MusicStyles;
import music.Track;

public class Test {
    public static void main(String[] args) {
        Track track = new Track(200,"He Is We","I Wouldn't Mind", MusicStyles.POP);
        System.out.println(track.hashCode());
    }
}
