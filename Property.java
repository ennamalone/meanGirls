// Énna Malone 15357146
// Cian Kelly 15386256
// Brian Finlay 15381151

public class Property extends Square {

	private static final float MORTGAGE_PREMIUM = 1.1f;

	private boolean isOwned;
	private int value;
	private int rent[];
	private Dice dice = new Dice();
	private int buildings;
	private String colour;
	private Player owner;
	private int buildPrice;
	private boolean mortgaged;
	private int mortgageValue;

	Property (String name, String colour, int buildPrice, int value, int[] rent, int mortgageValue) {
		super(name);
		this.colour = colour;
		this.buildPrice = buildPrice;
		this.value = value;
		this.rent = rent;
		isOwned = false;
		this.mortgageValue = mortgageValue;
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
	
	///////////////////
	
	public void setMortgaged() {
		mortgaged = true;
		return;
	}

	public boolean isMortgaged() {
		return mortgaged;
	}

	public void setNotMortgaged() {
		mortgaged = false;
		return;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}

	public int getMortgageRemptionPrice () {
		return (int) (((float) mortgageValue) * MORTGAGE_PREMIUM);
	}
	
	
	///////////////////
	public int getRentColourGroup() 
	{  // returns rent if all colour group owned by single player
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
	
	//////////////////////////
	
	/////////////////////////
	
	
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
		
		public boolean hasBuildings () {
			return buildings > 0;
		}
	}