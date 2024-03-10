import music.*;
import music.styles.*;

public class Test {
    public static void main(String[] args) {
        Track rockTrack = new Rock("A","XXX",666);
        Track rapTrack = new Rap("B","Lilxxx",123);
        Track jazzTrack = new Jazz("C","coleman robertson ford nigger",545);
        Track electronictrack = new Electronic("D","JVGVH", 12);
        rockTrack.getGenreName();

        System.out.println(rockTrack.toString());
        System.out.println(rapTrack.toString());
        System.out.println(jazzTrack.toString());
        System.out.println(electronictrack);
    }
}
