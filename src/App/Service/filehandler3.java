package App.Service;

import App.model.Song;
import App.model.Spotifytest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static App.model.Spotifytest.playlist;
import static App.model.Spotifytest.songs;

public class filehandler3 {
    public static void file3(){

        long startTime = System.nanoTime();
        try {

            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter("src\\App\\model\\customplaylist.txt"));
            for(Song tekst : playlist) {

                bufferedwriter.write(String.valueOf(Spotifytest.playlist));
                bufferedwriter.newLine();
            }
            bufferedwriter.close();

        } catch (IOException e) {
            e.printStackTrace();  // Printer fejlen
        }

        long endTime = System.nanoTime();  // Slut CPU tid
        long duration = endTime - startTime;

        System.out.println("CPU tid (nanosekunder): " + duration);
    }
}
