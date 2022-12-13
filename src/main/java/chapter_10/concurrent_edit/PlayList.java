package chapter_10.concurrent_edit;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private List<Song> tracks = new ArrayList<>();

    public void append(Song song) {
        tracks().add(song);
    }

    public List<Song> tracks() {
        return tracks;
    }
}
