import java.util.Random;

public class Team {
	String name;
	int score;
	Player players[] = new Player[5];
	
	public Team(String n) {
		name = n;
		score = 0;
		// Create the first line-up by position
		players[0] = new Player("Point Guard");
		players[1] = new Player("Shooting Guard");
		players[2] = new Player("Small Forward");
		players[3] = new Player("Power Forward");
		players[4] = new Player("Center");
	}

	public void increaseScore(int s) { score +=s;}
	public String getName() { return name; }	
	public int getScore() { return score; }	
	
	public int shoot() {
		// There is a 50% chance to miss, 40% to get 2-points, and 10% for 3-points 
        Random rand = new Random();  
        Random pl_rand = new Random();
        int shot_outcome = rand.nextInt(1000);
        int shooter = pl_rand.nextInt(5);
        System.out.println(name + "'s " + players[shooter].getName() + " shoots");
        players[shooter].increaseFG_attempted();
        if (shot_outcome < 500) {
        	return 0;
        } else if (shot_outcome < 900) {
        	players[shooter].increasePoints(2);
            players[shooter].increaseFG_made();
        	return 2;
        } else {
        	players[shooter].increasePoints(3);
            players[shooter].increaseFG_made();
            return 3;
        }
	}

	public int offensiveRebound() {
		// There is a 20% chance to get an offensive rebound 
        Random rand = new Random();  
        Random pl_rand = new Random();
        int reb_outcome = rand.nextInt(1000);
        int rebounder = pl_rand.nextInt(5);
        if (reb_outcome > 800) {
        	System.out.println(name + "'s " + players[rebounder].getName() + " gets the offensive rebound");
            players[rebounder].increaseRebounds();
        	return 1;
        } else {
        	return 0;
        }
	}

	public void defensiveRebound() {
        Random pl_rand = new Random();
        int rebounder = pl_rand.nextInt(5);
    	System.out.println(name + "'s " + players[rebounder].getName() + " gets the defensive rebound");
        players[rebounder].increaseRebounds();		
	}

	public void showStats() {
		// Show the statistics of each team in following format
		// Name
		// Points:
		// Shoots Attempted:      Shots Made:         Percentage:
		// Rebounds
	}

	public void showPlayersStats() {
		// Show the statistics of each player in following format
		// Position Points (... rebounds, ... / ... shoots, index)
		// index = points + rebounds - missed shots
	}


}
