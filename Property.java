

public class Property extends Square {

	private boolean isOwned;
	private int value;
	private int rent[];
	private Dice dice = new Dice();
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
	
	
	///////////////////
	public int getRentColourGroup() 
	{  // returns rent if all colour group owned by single player
	return 2*(rent[0]);
	}
	
	public int get1StationsOwned() { // rent if single players owns another station
	return 2*(rent[0]);
	}
	
	public int get2StationsOwned() { // rent if single players owns another 3 stations
	return 3*(rent[0]);
	}
	
	public int get3StationsOwned() { // rent if single players owns all the stations
	return 4*(rent[0]);
	}
	
	
	public int getFactoriesOwned(){  // case of one player owns both factories 
	return 4*(dice.getTotal());
	}
	
	public int get2FactoriesOwned(){  // case of one player owns both factories 
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
				return UI.ERR_TOO_MANY_BUILDINGS; // if a hotel has already been constructed
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
