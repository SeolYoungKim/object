package chapter_10.concurrent_edit;

public class PersonalPlayList extends PlayList {
    public void remove(Song song) {
        tracks().remove(song);
    }
}
