package main;

import music.Track;
import service.MusicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Track> trackList = new ArrayList<>();
    private static MusicService musicService = new MusicService();

    public static void main(String[] args) {
        while (true){
            menu();
        }
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\tMENU:" +
                "\n1.Total duration" +
                "\n2.Track list" +
                "\n3.Sort by style" +
                "\n4.Find by range" +
                "\n5.Add Track" +
                "\n0.Exit");
        System.out.print("Enter: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> musicService.getTotalDuration(trackList);
            case 2 -> musicService.getTrackList(trackList);
            case 3 -> musicService.sortingByStyle(trackList);
            case 4 -> musicService.findByRange(trackList);
            case 5 -> musicService.addTrack(trackList);
            case 0 -> System.exit(0);
        }
    }
}
