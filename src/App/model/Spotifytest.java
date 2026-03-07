package App.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static App.Service.filehandler.file;
import static App.Service.filehandler2.file2;

public class Spotifytest {

public static void main(String[] args) {
    Thread printer = new Thread(() -> {
        while (true) {
            System.out.println("You want a break from the ads?");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    int p = 1;
    Scanner sc = new Scanner(System.in);
    System.out.println("Are you a premium member?\nType Yes or No");
    String prem = sc.nextLine();
    file2();
     while(p == 1) {
         printmenu(prem);
         int call = Integer.parseInt(sc.nextLine());
         p = action(sc, call,prem, printer);
     }
}
    public static void printmenu (String prem) {

        System.out.println("\nMenu:");
        System.out.println("1. add song");
        System.out.println("2. remove song ");
        System.out.println("3. find song");
        System.out.println("4. Show songs");
        System.out.println("5. Rediger i sang");
        System.out.println("6. Sort sanglisten");
        System.out.println("7. Exit");
        if(prem.equalsIgnoreCase("yes")){
            System.out.println("8. Download song");
        }
        System.out.print("Choose an option: ");
    }
    public static int action(Scanner sc, int call,String prem,Thread printer){

        if(prem.equalsIgnoreCase("No")){
            printer.start();
        }
    if (call == 1 ){

        System.out.println("Type title of song");
        String title = sc.nextLine();
        System.out.println("Type Singer of song");
        String Author = sc.nextLine();
        System.out.println("Type Genre of song?\nChoose between these: Classical, Blues,Folk, Pop, Rock, HipHop, RB, EDM, Country  WARNING:Case sensitive");
        Genre Type = null;
        try {
            Type = Genre.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid genre. Please choose one of the listed genres.");
            return 1;
        }
        songs.add(new Song(title,Author,Type));

        return 1;
    }else if(call == 3){
        String find = sc.nextLine();
        for (Song s : songs) {
            if (s.getNavn().equalsIgnoreCase(find)) {
                System.out.println(s);
                return 1;
            }
        }
        System.out.println("Song not found");
    } else if(call == 4){
        System.out.println(songs);
        System.out.println("done");
        return 1;
    } else if(call == 5){
        System.out.println("What song do you want to remove");
        System.out.println(songs);
        System.out.println("type integer");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println("now type the new title");
        Song song = songs.get(number);
        String nname = sc.nextLine();
        song.setNavn(nname);

        songs.set(number, song );
        return 1;
    } else if(call == 6){
        Collections.sort(songs);
        return 1;
    } else if(call == 7){
     file();
    return 0;
    }else if(call == 2){
    System.out.println("delete by typing index number");
    int remove = Integer.parseInt(sc.nextLine());
    songs.remove(remove);
    return 1;
    }else if(call == 8){
        System.out.println("download by typing index number");
        int download = Integer.parseInt(sc.nextLine());
        System.out.println("you have downloaded: " + songs.get(download));
        return 1;
    }
return 1;
    }
    public static ArrayList<Song> songs = new ArrayList<>();


}