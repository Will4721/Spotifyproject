package App.model;

public class Song {
        private String navn;
        private String author;

    public Song(String navn, String author) {
            this.navn = navn;
            this.author = author;
        }

        public String getNavn() {
            return navn;
        }

        public String getauthor() {
            return author;
        }

        @Override
        public String toString() {
            return navn + " - " + author;
        }

    }
