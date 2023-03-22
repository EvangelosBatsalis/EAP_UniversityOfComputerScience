
public class Player {
	String pos;
	int points;
	int rebounds;
	int fg_made;
	int fg_attempted;
	
	public Player(String p) {
		pos = p;
		points = 0;
		rebounds = 0;
		fg_made = 0;
		fg_attempted = 0;
	}

	public void increasePoints(int p) {points += p;}
	public void increaseRebounds() {rebounds++;}
	public void increaseFG_made() {fg_made++;}
	public void increaseFG_attempted() {fg_attempted++;}

	public String getName() { return pos; }
	public int getFGattempted() { return fg_attempted; }
	public int getFGmade() { return fg_made; }
	public int getReb() { return rebounds; }


}
