
public class Property extends Square {

	private boolean isOwned;
	private int value;
	private int rent[];
	private int buildings;
	private String colour;
	private Player owner;
	private int buildPrice;

	Property (String name, String colour, int buildPrice, int value, int[] rent) {
		super(name);
		this.colour = colour;
		this.buildPrice = buildPrice;
		this.value = value;
		this.rent = rent;
		isOwned = false;
		return;
	}

	public int getBuildPrice(){
		return buildPrice;
	}

	public int getValue () {
		return value;
	}

	public int getRent () {
		return rent[0];
	}

	public String getColour() {
		return colour;
	}

	public boolean isOwned () {
		return isOwned;
	}

	public void setOwner (Player inPlayer) {
		owner = inPlayer;
		isOwned = true;
		return;
	}

	public Player getOwner () {
		return owner;
	}

	public int addBuidings(int noOfBuilds){

		if(buildings >= 5)
		{
			return UI.ERR_TOO_MANY_BUILDINGS;
		}
		else
		{
			buildings += noOfBuilds;
			return buildings;
		}
	}

	public int demolishBuidings(int noOfBuilds){
		buildings -= noOfBuilds;
		return buildings;
	}

	public int getNoOfBuildings(){
		return buildings;
	}
}
