
public class Player {
	String pos;
	int points;
        //Δημιουργία μεταβλητής για τα επιθετικά rebounds
	int offensiveRebounds;
	////Δημιουργία μεταβλητής για τα αμυντικά rebounds
        int defensiveRebounds;
        //int rebounds;
        int fg_made;
	int fg_attempted;
	
	public Player(String p) {
		pos = p;
		points = 0;
                
                //Αρχικοποίηση της μεταβλητής των επιθετικών rebounds στην τιμή 0 μέσα στον κατασκευαστή
		offensiveRebounds = 0;
                //Αρχικοποίηση της μεταβλητής των αμυντικών rebounds στην τιμή 0 μέσα στον κατασκευαστή
                defensiveRebounds = 0;
                
		fg_made = 0;
		fg_attempted = 0;
	}

	public void increasePoints(int p) {points += p;}
        
        //Δημιουργία μεθόδου η οποία αυξάνει κατά 1 χρησιμοποιώντας τον τελεστή ++ όποτε καλείται η μέθοδος increaseOffensiveRebounds()
	public void increaseOffensiveRebounds() {offensiveRebounds++;}
        //Δημιουργία μεθόδου η οποία αυξάνει κατά 1 χρησιμοποιώντας τον τελεστή ++ όποτε καλείται η μέθοδος increaseDefensiveRebounds()
        public void increaseDefensiveRebounds() {defensiveRebounds++;}
	
        public void increaseFG_made() {fg_made++;}
	public void increaseFG_attempted() {fg_attempted++;}

	public String getName() { return pos; }
	public int getFGattempted() { return fg_attempted; }
	public int getFGmade() { return fg_made; }
        
        //Δημιουργία getter η οποία επιστρέφει την μεταβλητή offensiveRebounds
	public int getOffReb() { return offensiveRebounds; }
        
        //Δημιουργία μεθόδου getter η οποία επιστρέφει την μεταβλητή defensiveRebounds
        public int getDefReb() { return defensiveRebounds; }


}
