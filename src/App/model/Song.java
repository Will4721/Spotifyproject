package App.model;

public class Song implements Comparable<Song> {
        private String navn;
        private String author;
        private Genre genre;

    public Song(String navn, String author,Genre genre) {
            this.navn = navn;
            this.author = author;
            this.genre = genre;
        }

    public void setNavn(String navn) {

        this.navn = navn;

    }
    public String getNavn() {
            return navn;
        }

        public String getauthor() {
            return author;
        }

        @Override
        public String toString() {
            return navn + " - " + author + " - "+ genre;
        }


    @Override
    public int compareTo(Song o) {
        return this.navn.compareToIgnoreCase(o.navn);
    }

  
}
