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
            players[rebounder].increaseOffensiveRebounds();
        	return 1;
        } else {
        	return 0;
        }
	}

	public void defensiveRebound() {
        Random pl_rand = new Random();
        int rebounder = pl_rand.nextInt(5);
    	System.out.println(name + "'s " + players[rebounder].getName() + " gets the defensive rebound");
        players[rebounder].increaseDefensiveRebounds();		
	}

	public void showStats() {
		// Show the statistics of each team in following format
		// Name
		// Points:
		// Shoots Attempted:      Shots Made:         Percentage:
		// Rebounds
                
          
                /*αρχικοποίηση μεταβλητής και χρήση for..loop για να μπω στα στοιχεία 
                του πίνακα του αντικειμένου players ώστε 
                να κάνω την χρήση των getters και setter όπως και μεθόδων, fields για τα ζητούμενα της άσκησης*/
                int i;
                //αρχικοποίηση των μεταβλητών ώστε να βγει το αποτέλεσμα ως άθροισμα των στοιχείων του πίνακα
                int shootsAttempted=0, shotsMade=0, offensiveRebounds=0, defensiveRebounds=0;
                float percentage;
                //χρησιμοποίηση των getter από τον πίνακα αντικειμένων players
                for(i=0;i<players.length;i++){
                    //δημιουργία μεταβλητών αθροίσματος
                    shootsAttempted += players[i].getFGattempted();
                    shotsMade += players[i].getFGmade();
                    offensiveRebounds += players[i].getOffReb();
                    defensiveRebounds += players[i].getDefReb();
                }
                //percentage calculation χρησιμοποίησα την φόρμουλα: (Shots Made / Attempted shoots * 100)
                percentage = (( (float) shotsMade / (float)shootsAttempted )*100);
                //εκτύπωση των στατιστικών βάση των ζητούμενων της άσκησης. επέλεξα String.format ώστε να έχω δύο δεκαδικά ψηφία στο αποτέλεσμα
                System.out.println("Name: "+this.getName()+"\n"+
                                   "Points: "+this.getScore()+"\n"+
                //επέλεξα String.format ώστε να έχω δύο δεκαδικά ψηφία στο αποτέλεσμα
                                   "Shoots Attempted: "+shootsAttempted+"\tShots Made: "+shotsMade+"\tPercentage: "+String.format("%.2f", percentage)+"%\n"+
                                   "Offensive Rebounds: "+offensiveRebounds+
                                   "\tDefensive Rebounds: "+defensiveRebounds);
	}//end of showStats() method

	public void showPlayersStats() {
		// Show the statistics of each player in following format
		// Position Points (... rebounds, ... / ... shoots, index)
		// index = points + rebounds - missed shots

                
                //Χρήση της for..loop για να εισέλθω στα στοιχεία του πίνακα
                int i;  //αρχικοποίηση μεταβλητής για να την χρησιμοποιήσω ως μετρητή της for..loop
                for(i=0;i<players.length;i++){
                  /*αρχικοποίηση μεταβλητής index μέσα στην for..loop διότι δεν με απσχολεί η διάρκειά της με τό πέρας της for..loop
                    σε κάθε θέση του πίνακα του αντικειμένου players της κλάσης Player χρησιμοποίησα τον τελεστή . ώστε να έχω πρόσβαση στα στοιχεία της κλάσης.
                    Για το ζητούμενο shoots αφαίρεσα από το σύνολο των προσπαθειών FGattemted το σύνολο των επιτυχημένων getFGmade*/
                    int index = players[i].points + (players[i].getDefReb()+players[i].getOffReb()) - (players[i].getFGattempted() - players[i].getFGmade()); 
                  
                    /*χρησιμοποιώντας sout για τα ζητούμενα της άσκησης την τοποθέτησα μέσα στην λούπα ώστε να έχω το counter του μετρητή
                    για όλες θέσεις του πίνακα του αντικειμένου players[] της κλάσης Players   */
                    System.out.println(players[i].getName()+" ( "+players[i].getOffReb()+" offensive rebounds, "+players[i].getDefReb()+" defensive rebounds, "+
                                        players[i].getFGattempted()+" / "+players[i].getFGmade()+" shoots, "+"index: "+index);}
        }//end of showPlayersStats() method
}//end of Team class
