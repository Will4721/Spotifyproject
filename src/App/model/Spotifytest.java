package App.model;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
import org.json.JSONArray;

import static App.Service.filehandler.file;
import static App.Service.filehandler2.file2;

public class Spotifytest {
    private static final String ACCESS_TOKEN = "n8E4zoBg2crW5l3Sq6l2KK3funD_KTHyLnkjTpjz7WEkQOaqiCG2xeD2_n8U5ENr";
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
        System.out.println("8. Play song");
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
            System.out.println("What song do you want to remove");
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
        } else if (call == 8) {
            System.out.print("Indtast sangtitel: ");
            String songTitle = sc.nextLine();

            try {
                // Encode sangtitel korrekt (håndterer specialtegn og mellemrum)
                String query = URLEncoder.encode(songTitle, StandardCharsets.UTF_8.toString());
                String apiUrl = "https://api.genius.com/search?q=" + query;

                // Opret connection
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);

                // Læs respons via InputStreamReader (vigtigt!)
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON (kræver at din json.jar er loadet i projektet)
                JSONObject json = new JSONObject(response.toString());
                JSONArray hits = json.getJSONObject("response").getJSONArray("hits");

                if (hits.length() > 0) {
                    JSONObject firstHit = hits.getJSONObject(0).getJSONObject("result");
                    String songUrl = firstHit.getString("url");
                    System.out.println("Fandt sang: " + firstHit.getString("full_title"));
                    System.out.println("URL: " + songUrl);
                } else {
                    System.out.println("Ingen resultater fundet for: " + songTitle);
                }

            } catch (UnsupportedEncodingException e) {
                System.out.println("Fejl i tekst-kodning: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Netværks- eller API fejl: " + e.getMessage());
            }
            return 1; // Returnerer til din menu-løkke

    }else if(call == 9){
        System.out.println("download by typing index number");
        int download = Integer.parseInt(sc.nextLine());
        System.out.println("you have downloaded: " + songs.get(download));
        return 1;
    }
return 1;
    }
    public static ArrayList<Song> songs = new ArrayList<>();


}