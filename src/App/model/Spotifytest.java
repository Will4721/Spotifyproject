package App.model;



import java.util.ArrayList;
import java.util.Scanner;

import static App.Service.filehandler.file;

public class Spotifytest {

public static void main(String[] args) {
int p = 1;
    Scanner sc = new Scanner(System.in);
     while(p == 1) {
         printmenu();
         int call = Integer.parseInt(sc.nextLine());
         p = action(sc, call);
     }
}
    public static void printmenu () {

        System.out.println("\nMenu:");
        System.out.println("1. add song");
        System.out.println("2. remove song ");
        System.out.println("3. find song");
        System.out.println("4. Show songs");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
    public static int action(Scanner sc, int call){

    if (call == 1 ){
        System.out.println("Type title of song");
        String title = sc.nextLine();
        System.out.println("Type Author of song");
        String Author = sc.nextLine();
        songs.add(new String(title + " - " + Author));
        return 1;
    }else if(call == 5){

     file();
    return 0;
    }
return 1;
    }
    public static ArrayList<String> songs = new ArrayList<>();
}