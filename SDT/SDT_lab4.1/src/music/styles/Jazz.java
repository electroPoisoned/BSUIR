package music.styles;

import music.Track;

public class Jazz extends Track {
    public Jazz(String title, String author, int duration) {
        super(title, author, duration);
    }

    /*private String createGenreName(){
        return String.valueOf(this.getClass()).replaceAll("class music\\.","");
    }*/
}
