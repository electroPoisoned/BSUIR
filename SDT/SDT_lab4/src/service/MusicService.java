package service;

import music.MusicStyles;
import music.Track;

import java.util.List;

public class MusicService {
    private static final String TOTAL_DURATION = "Total duration: ";
    private static final String SEC = " sec";
    private int duration = 0;

    public void getTrackList(List<Track> trackList) {
        for (Track t : trackList) {
            System.out.println(t.toString());
        }
        System.out.println();
    }

    public void getTotalDuration(List<Track> trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            duration += trackList.get(i).getDuration();
        }
        System.out.println(TOTAL_DURATION + duration + SEC);
        System.out.println();
    }

    public void sortingByStyle(List<Track> trackList, MusicStyles style) {
        for (Track t : trackList) {
            if (t.getMusicStyle() == style) {
                System.out.println(t.toString());
            }
        }
        for (Track t : trackList) {
            if (t.getMusicStyle() != style) {
                System.out.println(t.toString());
            }
        }
        System.out.println();
    }

    public void findByRange(int from, int to, List<Track> trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            if (trackList.get(i).getDuration() >= from && trackList.get(i).getDuration() <= to) {
                System.out.println(trackList.get(i).toString());
            }
        }
    }
}
