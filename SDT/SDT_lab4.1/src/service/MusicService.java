package service;

import exceptions.*;
import music.*;
import music.styles.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MusicService {
    private static final String TOTAL_DURATION = "Total duration: ";
    private static final String SEC = " sec";
    private int duration = 0;
    private static final ArrayList<String> genreList = new ArrayList<>(Arrays.asList("alternative",
            "electronic",
            "folk",
            "jazz",
            "metal",
            "punk",
            "rap",
            "reggae",
            "rock"));
    Scanner scanner = new Scanner(System.in);

    public void getTrackList(List<Track> trackList) {
        if(trackList.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        for (Track t : trackList) {
            System.out.println(t.toString());
        }
        System.out.println();
    }

    public void getTotalDuration(List<Track> trackList) {
        if(trackList.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        for (int i = 0; i < trackList.size(); i++) {
            duration += trackList.get(i).getDuration();
        }
        System.out.println(TOTAL_DURATION + duration + SEC);
        System.out.println();
    }

    public void sortingByStyle(List<Track> trackList) {
        if(trackList.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        String genre = null;
        boolean genreExist = false;
        do {
            try {
                System.out.print("Genre: ");
                genre = scanner.next();
                if(!genreList.contains(genre.toLowerCase())){
                    throw new GenreNotExistException(genre);
                }
                else {
                    genreExist = true;
                }
            } catch (GenreNotExistException e) {}
        }while (!genreExist);
        for (Track t : trackList) {
            if (t.getGenreName().equals(genre)) {
                System.out.println(t);
            }
        }
        for (Track t : trackList) {
            if (!t.getGenreName().equals(genre)) {
                System.out.println(t);
            }
        }
        System.out.println();
    }

    public void findByRange(List<Track> trackList) {
        if(trackList.isEmpty()){
            System.out.println("List is empty!");
            return;
        }
        int from = 0;
        int to = -1;
        do {
            try {
                System.out.print("Range: from ");
                from = scanner.nextInt();
                System.out.print("to ");
                to = scanner.nextInt();

                if(from < 0 || to < 0){
                    throw new DurationLessZeroException();
                }
                if (from > to) {
                    throw new UpperBorderLessLowerBorderException();
                }
            }catch (UpperBorderLessLowerBorderException | DurationLessZeroException e){}
        }while (from>to);
        for (Track track : trackList) {
            if (track.getDuration() >= from && track.getDuration() <= to) {
                System.out.println(track);
            }
        }
    }

    public void addTrack(List<Track> trackList){
        System.out.println("Choose the genre:" +
                "\n\t1.Alternative" +
                "\n\t2.Electronic" +
                "\n\t3.Folk" +
                "\n\t4.Jazz" +
                "\n\t5.Metal" +
                "\n\t6.Punk" +
                "\n\t7.Rap" +
                "\n\t8.Reggae" +
                "\n\t9.Rock\n");

        int choice = scanner.nextInt();
        System.out.println("Enter:");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        int duration = enterDuration();

        switch (choice){
            case 1 -> trackList.add(new Alternative(title, author, duration));
            case 2 -> trackList.add(new Electronic(title, author, duration));
            case 3 -> trackList.add(new Folk(title, author, duration));
            case 4 -> trackList.add(new Jazz(title, author, duration));
            case 5 -> trackList.add(new Metal(title, author, duration));
            case 6 -> trackList.add(new Punk(title, author, duration));
            case 7 -> trackList.add(new Rap(title, author, duration));
            case 8 -> trackList.add(new Reggae(title, author, duration));
            case 9 -> trackList.add(new Rock(title, author, duration));
        }
    }

    private int enterDuration(){
        int duration;
        do {
            try {
                System.out.print("Duration: ");
                duration = scanner.nextInt();
                if(duration <= 0){
                    throw new DurationLessZeroException();
                }
            } catch (DurationLessZeroException e) {
                duration = -1;
            }
        } while (duration <= 0);
        return duration;
    }
}
