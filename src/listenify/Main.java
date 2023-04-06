package listenify;

import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album=new Album("Old Hindi Songs","Arijit Singh");

        album.addSongToAlbum("Pathaan",4.5);
        album.addSongToAlbum("Channa Mereya",3.5);
        album.addSongToAlbum("Naina",4.2);

        albums.add(album);

        album=new Album("New Songs","Prateek Kuhad");

        album.addSongToAlbum("Kasoor",4.5);
        album.addSongToAlbum("Tum Mile",3.5);
        album.addSongToAlbum("Barishein",4.2);

        albums.add(album);

        LinkedList<Song> playList1=new LinkedList<>();
        albums.get(0).addSongToPlayList("Pathaan",playList1);
        albums.get(0).addSongToPlayList("Naina",playList1);
        albums.get(1).addSongToPlayList("Kasoor",playList1);
        albums.get(1).addSongToPlayList("Barishein",playList1);
        play(playList1);
    }
    public static void play(LinkedList<Song> playList){
        ListIterator<Song> listIterator= playList.listIterator();
        // validation check
        if(playList.size()==0) return;
        Scanner sc=new Scanner(System.in);
        printMenu();
        System.out.println("Now playing"+listIterator.next());
        boolean forward=true;
        boolean quit=false;
        while(quit==false){
            int choice=sc.nextInt();
            switch(choice){
                case 0:
                    quit=true;
                    break;
                case 1:
                    // to play the next song
                    if(forward==false){  // I'm at the left of last played or printed song
                        listIterator.next();
                        forward=true;
                    }
                    if(listIterator.hasNext())
                        System.out.println(listIterator.next().toString());
                    else System.out.println("You are already at the last song");
                    break;
                case 2:
                    // to play the previous song
                    if(forward==true) {// I'm already at the right of last printed or played song
                        listIterator.previous();
                        forward=false;
                    }
                    if(listIterator.hasPrevious())
                        System.out.println(listIterator.previous().toString());
                    else System.out.println("You are already at the first song");
                    break;
                case 3:
                    // replay the current song
                    if(forward==true) { // I'm at the RHS on current song
                        System.out.println(listIterator.previous().toString());
                        forward=false;
                    }
                    else{ // I'm at the LHS on current song
                        System.out.println(listIterator.next().toString());
                        forward=true;
                    }
                    break;
                case 4:
                    printAllSongs(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    // delete a song
                    if (playList.size() > 0) {
                        if (forward == true)
                            System.out.println(listIterator.previous().toString() + " has been removed from the playlist.");
                        else
                            System.out.println(listIterator.next().toString() + " has been removed from the playlist.");
                        listIterator.remove();
                        if (playList.size() > 0 && listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        } else if (playList.size() > 0 && listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("The playlist is already empty.");
                        }
                        break;
                    }
            }
        }
    }
    public static void printAllSongs(LinkedList<Song> song){
        ListIterator<Song> listIterator=song.listIterator();
        while(listIterator.hasNext())
            System.out.println(listIterator.next().toString());
    }
    public static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
}