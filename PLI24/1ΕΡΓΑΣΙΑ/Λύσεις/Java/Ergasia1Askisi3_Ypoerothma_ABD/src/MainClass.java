
public class MainClass {

	public static void main(String[] args) {
		// Create a Game
                /*Team object δεύσμευση μνήμης και δημιουργίας αντικειμένων ομάδων hometeam και awayteam με τα ονόματα των αντικειμένων
                  OmadaraA και OmadaraB*/
                Team team1 = new Team("OmadaraA");   
                Team team2 = new Team("OmadaraB");
                
                /*αρχικοποίηση αντικειμένου παιχνιδιού με το όνομα game. Βλέπωντας την κλάση Game παρατηρώ ότι υπάρχει constructor ο οποίος παίρνει δύο ορίσματα αντικειμένων
                  την Team hT και την Team aT όπου στέλνω τα αντικείμενα που δημιούργησα OmadaraA και OmadaraB*/
                Game game = new Game(team1,team2);
                
		// Simulate Game
                //παρατηρώ ότι η κλάση Game έχει σαν κύρια μέθοδο την simulateGame() την οποία την εκτελώ μέσω του αντικειμένου Game οπου δημιούργησα και τον τελεστή "."
		game.simulateGame();

                // Show Team Statistics
                /*Βλέπω ότι η Κλάση Game έχει δύο μεθόδους όπου και τυπώνει με sout στην οθονη του χρήστη μέσω με τιμές που παίρνει από τις μεθόδους που δημιούργησα της κλάσης Team 
                  η συγκεκριμένη τυπώνει στην οθόνη του χρήστη τα στατιστικά της ομάδας και τοποθετεί επιεπλέον και ένα διακριτικό διαχωριστικό*/
		game.showTeamStats();
                
                // Show Players Statistics
                /*Βλέπω ότι η Κλάση Game έχει δύο μεθόδους όπου και τυπώνει με sout στην οθονη του χρήστη μέσω με τιμές που παίρνει από τις μεθόδους που δημιούργησα της κλάσης Team 
                  η συγκεκριμένη τυπώνει στην οθόνη του χρήστη τα στατιστικά της των παιχτών και τοποθετεί επιεπλέον και ένα διακριτικό διαχωριστικό*/
                game.showPlayersStats();
                
        }//end of main metho
}//end of Main Class
