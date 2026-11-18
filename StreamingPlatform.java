public class StreamingPlatform {
    private Content[] contents;
    private user[] users;
    private int nbContents;
    private int nbUsers;
    public StreamingPlatform(int capaciteContents, int capaciteUsers) {
        contents = new Content[capaciteContents];
        users = new user[capaciteUsers];
        nbContents=0;
        nbUsers =0;
    }
    public void addContent(Content content) {
        if (nbContents < contents.length) {
            contents[nbContents] = content;
            nbContents++;
        }
    }
    public void addUser(user user) {
        if (nbUsers < users.length) {
            users[nbUsers] = user;
            nbUsers++;
        }
    public Content findContent(String title)
            throws ContentNotFoundException {
        for (int i = 0; i < nbContents; i++) {
            if (contents[i].getTitle().equals(title)) {
                return contents[i];
            }
        }

        throw new ContentNotFoundException(
            "Contenu introuvable : " + title
        );
    }
    public void playContent(user user, String title)
            throws ContentNotFoundException, AccessDeniedException {
        Content content = findContent(title);
        if (!user.canPlay(content)) {
            throw new AccessDeniedException(
                user.getName() + " n'a pas le droit de lire " + title
            );
        }

        content.play();
        user.addWatchedContent(content);
    }
    public Content[] getRecommendations(user user) {
        Content[] recommandations = new Content[10];
        String[] genres = user.getWatchedGenres();
        int n = 0;
        for (int i = 0; i < nbContents && n < 10; i++) {
            Content content = contents[i];
            if (user.hasWatched(content)) {
                continue;
            }
            for (int j = 0; j < genres.length; j++) {
                if (content.getGenre().equals(genres[j])) {
                    if (user.canPlay(content)) {
                        recommandations[n] = content;
                        n++;
                    }
                    break;
                }
            }
        }
        return recommandations;
    }
}