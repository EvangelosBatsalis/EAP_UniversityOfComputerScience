 
public class MainClass {

	public static void main(String[] args) {
		// Create a Game
                //Team object δεύσμευση μνήμης και δημιουργίας αντικειμλένων ομάδως hometeam και awayteam
                Team team1 = new Team("OmadaraA");   
                Team team2 = new Team("OmadaraB");
                
                
                Game game = new Game(team1,team2);
                
		// Simulate Game
		game.simulateGame();

                // Show Team Statistics
		game.showTeamStats();

                // Show Players Statistics
                game.showPlayersStats();
                
        }

}
