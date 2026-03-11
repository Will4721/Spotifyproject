package App.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


import static App.Service.filehandler.file;
import static App.Service.filehandler2.file2;
import static App.Service.filehandler3.file3;

public class Spotifytest {
    //jeg ville gerne lave API som henter lyrics ned og lave en play funktion Api'en kommer fra Genius
    //private static final String ACCESS_TOKEN = "n8E4zoBg2crW5l3Sq6l2KK3funD_KTHyLnkjTpjz7WEkQOaqiCG2xeD2_n8U5ENr";
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
         printmenu(prem,printer);
         int call = Integer.parseInt(sc.nextLine());
         p = action(sc, call);
     }
}
    public static void printmenu (String prem,Thread printer) {
        if(prem.equalsIgnoreCase("No")){
            printer.start();
        }

        System.out.println("\nMenu:");
        System.out.println("1. add song");
        System.out.println("2. remove song ");
        System.out.println("3. find song");
        System.out.println("4. Show songs");
        System.out.println("5. Rediger i sang");
        System.out.println("6. Sort sanglisten");
        System.out.println("7. Exit");
        System.out.println("8. create playlist");
        if(prem.equalsIgnoreCase("yes")){
            System.out.println("9. Download song");
        }
        System.out.print("Choose an option: ");
    }
    public static int action(Scanner sc, int call) {


        if (call == 1) {

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
            songs.add(new Song(title, Author, Type));

            return 1;
        } else if (call == 3) {
            String find = sc.nextLine();
            for (Song s : songs) {
                if (s.getNavn().equalsIgnoreCase(find)) {
                    System.out.println(s);
                    System.out.println("https://www.youtube.com/results?search_query=" + find + "+" + "song");
                    System.out.println("https://open.spotify.com/search/" + find);
                    return 1;
                }
            }
            System.out.println("Song not found");
        } else if (call == 4) {
            System.out.println(songs);
            System.out.println("done");
            return 1;
        } else if (call == 5) {
            System.out.println("What song do you want to edit");
            System.out.println(songs);
            System.out.println("type integer");
            int number = Integer.parseInt(sc.nextLine());
            System.out.println("now type the new title");
            Song song = songs.get(number);
            String nname = sc.nextLine();
            song.setNavn(nname);

            songs.set(number, song);
            return 1;
        } else if (call == 6) {
            Collections.sort(songs);
            return 1;
        } else if (call == 7) {
            file();
            return 0;
        } else if (call == 2) {
            System.out.println("delete by typing index number");
            int remove = Integer.parseInt(sc.nextLine());
            songs.remove(remove);
            return 1;
        }else if(call == 8){
            System.out.println("how many songs do you wish to enter in playlist");
            int howmany = Integer.parseInt(sc.nextLine());
            for(int i=0;i < howmany; i++ ) {
                try {
                    System.out.println("what song should be added?");
                    String find = sc.nextLine();
                    //den går ikke vidre her fra
                    //opdagede at den lave NumberformatExeption når man skrev navn case sensitive og det er blevert fikset med try and catch
                    //men den printer stadig ikke ud det i catch og hvorfor skal man skrive det case senstive når jeg har sagt ignorer det
                    // ||||||||||||||||||||||||||||||||||
                    // vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
                    for (Song s : songs) {
                        if (s.getNavn().equalsIgnoreCase(find)) {
                            System.out.println(s);
                            System.out.println("type in author name?");
                            String findaut = sc.nextLine();
                            System.out.println("type in Genre name?");
                            Genre Type = null;
                            try {
                                Type = Genre.valueOf(sc.nextLine());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid genre. Please choose one of the listed genres.");

                            }
                            playlist.add(new Song(find, findaut, Type));
                            System.out.println("here" + playlist);

                        }

                    }
                    }catch(NumberFormatException e){
                    System.out.println("what the fuck");
                }

            }
            file3();
            return 1;
        } else if(call == 9){
        System.out.println("download by typing index number");
        int download = Integer.parseInt(sc.nextLine());
        System.out.println("you have downloaded: " + songs.get(download));
        return 1;
    }
return 1;
    }
    public static ArrayList<Song> songs = new ArrayList<>();
    public static ArrayList<Song> playlist = new ArrayList<>();

}