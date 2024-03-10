package disc;

import music.MusicStyles;
import music.Track;
import service.MusicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Disc {
    private List<Track> trackList = new ArrayList<>();
    private MusicService musicService = new MusicService();

    public Disc() {
        trackList.add(new Track(200,"He Is We","I Wouldn't Mind", MusicStyles.POP));
        trackList.add(new Track(151,"Mike Dimes","NO TRENDS", MusicStyles.RAP_AND_HIPHOP));
        trackList.add(new Track(132,"Nth Shade","FORCE", MusicStyles.ELECTRONIC));
        trackList.add(new Track(215,"Baroque Festival Orchestra, Alberto Lizzio","Winter(L'Inverno)Op.8 No.4 F Minor:Allegro Non Molto", MusicStyles.CLASSIC));
        trackList.add(new Track(284,"Coleman Hawkins Quartet","Quintessence", MusicStyles.JAZZ));
        trackList.add(new Track(240,"The Neighbourhood","Sweater Weather", MusicStyles.ALTERNATIVE));
        trackList.add(new Track(170,"Magnolia Park, Ethan Ross","Do Or Die", MusicStyles.METAL));
        trackList.add(new Track(263,"YG Marley","Praise Jah In The Moonlight", MusicStyles.REGGAE));
        trackList.add(new Track(231,"Siouxsie and the Banshees","Happy House", MusicStyles.PUNK));
        trackList.add(new Track(208,"blink-182","ONE MORE TIME", MusicStyles.ROCK));
        trackList.add(new Track(310,"Iron & Wine","You Never Know", MusicStyles.FOLK_AND_ACOUSTIC));
        trackList.add(new Track(163,"XXXTENTACION","Save Me", MusicStyles.RAP_AND_HIPHOP));
        trackList.add(new Track(300,"Lil Peep","Broken Smile(My All)", MusicStyles.RAP_AND_HIPHOP));
        trackList.add(new Track(506,"Wardruna","Lifjaberg", MusicStyles.FOLK_AND_ACOUSTIC));
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\tMENU:\n1.Total duration\n2.Track list\n3.Sort by style\n4.Find by range\n0.Exit");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> musicService.getTotalDuration(trackList);
            case 2 -> musicService.getTrackList(trackList);
            case 3 -> {
                System.out.println("Example:");
                musicService.sortingByStyle(trackList, MusicStyles.RAP_AND_HIPHOP);
            }
            case 4 -> {
                System.out.print("Range: from ");
                int from = scanner.nextInt();
                System.out.println(" to ");
                int to = scanner.nextInt();
                musicService.findByRange(from, to, trackList);
            }
            case 0 -> System.exit(0);
        }

    }
}
