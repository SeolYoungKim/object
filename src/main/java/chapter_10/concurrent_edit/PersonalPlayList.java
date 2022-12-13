package chapter_10.concurrent_edit;

public class PersonalPlayList extends PlayList {
    public void remove(Song song) {
        tracks().remove(song);
        singers().remove(song.singer()); // 부모 클래스와 함께 수정되어야 한다.
    }
}
