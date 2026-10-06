package App.Service;

import App.model.Genre;
import App.Ui.Song;

import java.io.*;

import static App.model.Spotifytest.songs;

public class filehandler2 {
    public static void file2() {

        long startTime = System.nanoTime();
        try {

            BufferedReader br = new BufferedReader(new FileReader("src\\App\\model\\songs.txt"));
            {
                String line;
                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(" - ");

                    String title = parts[0];
                    String author = parts[1];
                    Genre genre = Genre.valueOf(parts[2]);

                    songs.add(new Song(title, author, genre));
                }

                br.close();

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

