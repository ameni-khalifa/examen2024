public class main{
	public static void main(String[] args) {
		StreamingPlatform plateforme = new StreamingPlatform(10, 5);
		 Movie m1 = new Movie("Inception", "Sci-Fi", false, 148);
	     serie s1 = new serie("Stranger Things", "Thriller", false, 25, 50);
	     Movie m2 = new Movie("Charlie Chaplin", "Comedy", true, 75);
	     serie s2 = new serie("Friends", "Comedy", true, 236, 22);
	     plateforme.addContent(m1);
		        plateforme.addContent(s1);
		        plateforme.addContent(m2);
		        plateforme.addContent(s2);
		        m1.afficheDetails();
		        System.out.println();
		        s1.afficheDetails();
		        System.out.println();
		        m2.afficheDetails();
		        System.out.println();
		        s2.afficheDetails();
		        System.out.println();
		        user user1 = new user("Imene", false);
		        user user2 = new user("Jihene", true);
		        plateforme.addUser(user1);
		        plateforme.addUser(user2);
		        try {
		            plateforme.playContent(user1, "Inception");
		        } catch (ContentNotFoundException | AccessDeniedException e) {
		            System.out.println(e.getMessage());
		        }
		        try {
		            plateforme.playContent(user1, "Charlie Chaplin");
		        } catch (ContentNotFoundException | AccessDeniedException e) {
		            System.out.println(e.getMessage());
		        }
	
		        try {
		            plateforme.playContent(user2, "Stranger Things");
		        } catch (ContentNotFoundException | AccessDeniedException e) {
		            System.out.println(e.getMessage());
		        }
		        try {
		            plateforme.playContent(user2, "Friends");
		        } catch (ContentNotFoundException | AccessDeniedException e) {
		            System.out.println(e.getMessage());
		        }
	
		        Content[] recommandations = plateforme.getRecommendations(user2);
		        for (int i = 0; i < recommandations.length; i++) {

		            if (recommandations[i] != null) {
		                recommandations[i].afficheDetails();
		                System.out.println();
		            }
		        }
		    }
			
		}

