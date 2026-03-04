package App.Service;
import App.model.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static App.model.Spotifytest.songs;


public class filehandler {
    public static void file(){

    long startTime = System.nanoTime();
    try {

        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter("src\\App\\Service\\songs.txt"));
        for(String tekst : songs) {

            bufferedwriter.write(String.valueOf(Spotifytest.songs));
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

