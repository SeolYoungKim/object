package chapter_10.concurrent_edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayList {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();

    public void append(Song song) {
        tracks.add(song);
        singers.put(song.singer(), song.title());
    }

    public List<Song> tracks() {
        return tracks;
    }

    public Map<String, String> singers() {
        return singers;
    }
}
