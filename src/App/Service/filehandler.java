package App.Service;
import App.model.*;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class filehandler {
    public static void file(){

    long startTime = System.nanoTime();
    try {

        BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter("src\\App\\Service\\songs.txt"));
        for(int i = 1; i <= 10; i++) {

            bufferedwriter.write(songs);
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

