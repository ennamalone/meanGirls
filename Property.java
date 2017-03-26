
public class Property extends Square {

	private boolean isOwned;
	private int value;
	private int rent[];
	private Dice dice = new Dice();
	private Player owner;
	
	Property (String name, int value, int[] rent) {
		super(name);
		this.value = value;
		this.rent = rent;
		isOwned = false;
		return;
	}
	
	public int getValue () {
		return value;
	}
	
	public int getRent () {
		return (rent[0]);
	}
	
	public int getRentColourGroup() {  // returns rent if all colour group owned by single player
		return (2*rent[0]);
	}
	
	public int get1StationsOwned() { // rent if single players owns another station
		return (rent[0]);
	}
	
	public int get2StationsOwned() { // rent if single players owns another 2 stations
		return 2*(rent[0]);
	}
	
	public int get3StationsOwned() { // rent if single players owns all the stations
		return 3*(rent[0]);
	}

	
	public int getFactories2Owned(){  // case of one player ownies both factories 
		return 10*(dice.getTotal());
	}
	
	public boolean isOwned () {
		return isOwned;
	}
	//////////////////////////
	public void setOwner (Player inPlayer) {
		owner = inPlayer;
		
		isOwned = true;
		return;
	}
	/////////////////////////
	public Player getOwner () {
		return owner;
	}
}
