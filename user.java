public class user {
    private String name;
    private boolean isSubscribed;
    private Content[] watchedContent;
    private int nbWatched;
    private final int MAX_WATCHED = 100;
    public user(String name, boolean isSubscribed) {
        this.name = name;
        this.isSubscribed = isSubscribed;
        watchedContent = new Content[MAX_WATCHED];
        nbWatched = 0;
    }

    public String getName() {
        return name;
    }
    public boolean isSubscribed() {
        return isSubscribed;
    }

    public boolean canPlay(Content content) {
        return isSubscribed || content.isFree();
    }

    public void addWatchedContent(Content content) {
        if (nbWatched < MAX_WATCHED) {
            watchedContent[nbWatched] = content;
            nbWatched++;
        }
    }
    public String[] getWatchedGenres() {
        String[] genres = new String[nbWatched];
        int n = 0;
        for (int i = 0; i < nbWatched; i++) {
            String genre = watchedContent[i].getGenre();
            boolean existe = false;
            for (int j = 0; j < n; j++) {
                if (genres[j].equals(genre)) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                genres[n] = genre;
                n++;
            }
        }
        String[] resultat = new String[n];
        for (int i = 0; i < n; i++) {
            resultat[i] = genres[i];
        }
        return resultat;
    }
    public boolean hasWatched(Content content) {
        for (int i = 0; i < nbWatched; i++) {
            if (watchedContent[i] == content) {
                return true;
            }
        }
        return false;
    }
}