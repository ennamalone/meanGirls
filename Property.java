
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
	
	public int getRentColourGroup() {
		return (2*rent[0]);
	}
	
	public int get1StationsOwned() {
		return (rent[0]);
	}
	
	public int get2StationsOwned() {
		return 2*(rent[0]);
	}
	
	public int get3StationsOwned() {
		return 3*(rent[0]);
	}

	public int getFactoriesOwned(){
		return 4*(dice.getTotal());
	}
	
	public int getFactories2Owned(){
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
