public class serie extends Content {

    private int nbEpisodes;
    private int dureeEpisode;

    public serie(String title, String genre, boolean isFree,
                 int nbEpisodes, int dureeEpisode) {

        super(title, genre, isFree);
        this.nbEpisodes = nbEpisodes;
        this.dureeEpisode = dureeEpisode;
    }
    public void afficheDetails() {
        System.out.println("Type : Série");
        System.out.println("Titre : " + title);
        System.out.println("Genre : " + genre);
        System.out.println("Nombre d'épisodes : " + nbEpisodes);
        System.out.println("Durée d'un épisode : " + dureeEpisode);
        System.out.println("Durée totale : " + getDuration() + " minutes");
        System.out.println("Gratuit : " + isFree);
    }
    public int getDuration() {
        return nbEpisodes * dureeEpisode;
    }
}