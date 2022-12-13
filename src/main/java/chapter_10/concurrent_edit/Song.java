package chapter_10.concurrent_edit;

public class Song {
    private String singer;
    private String title;

    public Song(String singer, String title) {
        this.singer = singer;
        this.title = title;
    }

    public String singer() {
        return singer;
    }

    public String title() {
        return title;
    }
}
