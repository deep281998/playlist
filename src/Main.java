import java.awt.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album arjitalbum = new Album("Arijit Singh" , "Arijit album");

        Album alanalbum = new Album("Alan Walker" , "alanalbum");

        arjitalbum.addsongtoalbum("Kesaria" , 3.6);
        arjitalbum.addsongtoalbum("Tum kya mile" , 4.9);
        arjitalbum.addsongtoalbum("lal ishq" , 6.0);

        alanalbum.addsongtoalbum("faded" , 9.0);
        alanalbum.addsongtoalbum("Alone" , 7.0);

        LinkedList<Song> myplaylist = new LinkedList<>();
        System.out.println(arjitalbum.addToPlaylistFromAlbum("Kesaria" , myplaylist));
        System.out.println(arjitalbum.addToPlaylistFromAlbum(3,myplaylist));
        System.out.println(arjitalbum.addToPlaylistFromAlbum("Tum kya mile" , myplaylist));
        System.out.println(arjitalbum.addToPlaylistFromAlbum(4 , myplaylist));
        System.out.println(alanalbum.addToPlaylistFromAlbum(1 , myplaylist));



        play(myplaylist);
    }

    private static void play(LinkedList<Song> myplaylist){
        if(myplaylist.size() == 0)
        {
            System.out.println("empty play list");
            return;
        }
        ListIterator<Song> itr = myplaylist.listIterator();
        System.out.println("Now Playing"  + itr.next());
        boolean wasnext = true;

        Scanner sc = new Scanner(System.in);

        System.out.println("please enter your choice");
        printMenu();

        boolean quit = false;
        while (!quit){
            System.out.println("please enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(wasnext == false)
                    {
                        itr.next();
                    }
                    if(!itr.hasNext()){
                        System.out.println("Nomore song");
                    }
                    else {
                        System.out.println("your song is : " + itr.next());
                    }
                    break;
                case 3:
                    if(wasnext == true)
                    {
                        itr.previous();
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("you are at start your playlist");
                    }
                    else {
                        System.out.println("currently playing " + itr.previous());
                    }
                    break;
                case 4:
                    if(wasnext == true)
                    {
                        System.out.println("curr song" + itr.previous());
                        wasnext = false;
                    }
                    else {
                        System.out.println("curr song" + itr.next());
                        wasnext = true;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    printsong(myplaylist);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("wrong choice . please select again");
            }
        }
        return;
    }

    private static void printsong(LinkedList<Song> myplaylist) {
        for(Song song : myplaylist){
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {
        System.out.println("1 . show the menu again");
        System.out.println("2 . play the next song");
        System.out.println("3. play previous song");
        System.out.println("4. play current song again");
        System.out.println("5. delete song from playlist");
        System.out.println("6. print all song in playlist");
        System.out.println("7. quit application");
    }


}