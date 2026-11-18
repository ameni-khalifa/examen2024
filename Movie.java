public class Movie extends Content {
    private int duration;
    public Movie(String title, String genre, boolean isFree, int duration) {
        super(title, genre, isFree);
        this.duration = duration;
    }
    public void afficheDetails() {
        System.out.println("Type : Film");
        System.out.println("Titre : " + title);
        System.out.println("Genre : " + genre);
        System.out.println("Durée : " + duration + " minutes");
        System.out.println("Gratuit : " +isFree);
    }
    public int getDuration() {
        return duration;
    }
}