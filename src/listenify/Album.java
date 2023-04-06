package listenify;

import java.util.*;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }
    public boolean findSongInAlbum(String title){
        for(Song song:songList){
            if(song.title==title)
                return true;
        }
        return false;
    }
    public String addSongToAlbum(String title, double duration){
        // check if the song already exists
        // otherwise we will add it to the list
        if(findSongInAlbum(title)==true)
            return "Song already exists";
        else{
            // I need to create an object, the add it to the songList
            Song newSong= new Song(title,duration);
            songList.add(newSong);
            return "New Song has been added successfully";
        }
    }
    public String addSongToPlayList(int trackNo, LinkedList<Song> playList){
        // trackNo 1 2 3 4 ..
        // index no 0 1 2 3 4 ...
        int index=trackNo-1;
        // checking for validity of index
        if(index>=0 && index<this.songList.size()){
            Song song=songList.get(index);
            playList.add(song);
            return "Song added to the playlist";
        }
        return "Invalid track no";
    }
    public String addSongToPlayList(String title, LinkedList<Song> playList){
        // I need to find the song first
        // then add it to the playList
        for(Song song:songList){
            if(song.title==title){
                playList.add(song);
                return "Song has been added successfully";
            }
        }
        return "Song doesn't exist";
    }

}
