import java.util.*;

public class Album {

    private String artist;

    private String name;

    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findsong(String name){
        for(Song song : songs){
            if(song.getTitle().equals(name)){
                return true;
            }
        }
        return false;
    }

    public String addsongtoalbum(String title , double duration){
        if(!findsong(title)){
            Song song = new Song(title,duration);
            this.songs.add(song);
            return "Song has been added";
        }
        return "song already exist";
    }

    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playlist) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                playlist.add(song);
                return "Song added to the playlist";
            }
        }
        return "Song not found in the album";
    }

    public String addToPlaylistFromAlbum(int num, LinkedList<Song> playlist) {
        int n = num - 1;
        if (n >= 0 && n < songs.size()) {
            playlist.add(songs.get(n));
            return "Song has been added to the playlist";
        }
        return "Incorrect song number";
    }

}
