package App.Service;

import App.model.Genre;
import App.model.Song;
import App.model.Spotifytest;

import java.io.*;

import static App.model.Spotifytest.songs;

public class filehandler2 {
    public static void file2() {

        long startTime = System.nanoTime();
        try {

            BufferedReader br = new BufferedReader(new FileReader("src\\App\\model\\songs.txt"));
            {
                while (br.ready()) {
                    songs.add(new Song(br.readLine(), br.readLine(), Genre.valueOf(br.readLine())));

                }

                long endTime = System.nanoTime();  // Slut CPU tid
                long duration = endTime - startTime;

                System.out.println("CPU tid (nanosekunder): " + duration);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

