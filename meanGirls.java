
public class meanGirls implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player object	
	
	public boolean rollDone = false;
	public boolean colouredProperty = false;
	public boolean isOwned1 = false;
	public boolean isOwned2 = false;
	public boolean isOwned3 = false;
	public boolean isOwned4 = false;
	public boolean isOwned5 = false;
	public boolean isOwned6 = false;
	public boolean isOwned7 = false;
	public boolean isOwned8 = false;
	public boolean isOwned9 = false;
	public boolean isOwned11 = false;
	public boolean isOwned12 = false;
	public boolean isOwned13 = false;
	public boolean isOwned14 = false;
	public boolean isOwned15 = false;
	public boolean isOwned16 = false;
	public boolean isOwned17 = false;
	public boolean isOwned18 = false;
	public boolean isOwned19 = false;	
	public static BoardAPI boardbot;
	public static PlayerAPI playerbot;
	public static DiceAPI dicebot;
	int i = 0;
	private String[] bought = new String [40]; 
	
	meanGirls (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		boardbot = board;
		playerbot = player;
		dicebot = dice;
		return;
	}
	
	public String getName () 
	{
		return "meanGirls";
	}
	
	public String getCommand () 
	{	
		
		if(playerbot.getProperties().equals("Pentonville Rd")  && playerbot.getProperties().equals("Euston Rd") && playerbot.getProperties().equals("The Angel Islington"))
		{
			colouredProperty = true;
		}
		if(playerbot.getProperties().equals("Pall Mall")  && playerbot.getProperties().equals("Whitehall") && playerbot.getProperties().equals("Northumberland Ave"))
		{
			colouredProperty = true;
		}
		if(playerbot.getProperties().equals("Bow St")  && playerbot.getProperties().equals("Marlborough St") && playerbot.getProperties().equals("Vine St"))
		{
			colouredProperty = true;
		}
		if(playerbot.getProperties().equals("Strand")  && playerbot.getProperties().equals("Fleet St") && playerbot.getProperties().equals("Trafalger Sq"))
		{
			colouredProperty = true;
		}
		if(playerbot.getProperties().equals("Leicester Sq")  && playerbot.getProperties().equals("Coventry St") && playerbot.getProperties().equals("Piccadilly"))
		{
			colouredProperty = true;
		}
		if(playerbot.getProperties().equals("Regent St")  && playerbot.getProperties().equals("Oxford St") && playerbot.getProperties().equals("Bond St"))
		{
			colouredProperty = true;
		}
		
		// checks if bot owns entire colour group
		
		
		
		
		if(!rollDone)
			{
				rollDone = true;
					if(dicebot.isDouble())
					{
						return "roll";
					}
				return "roll";
			}
			
			if(playerbot.getPosition() == 6 && !isOwned1 && boardbot.isProperty(6) && playerbot.getBalance() >= 250) // also ensures purchase is not made with low player balance
			{ // buy our given appointed houses 
				bought[i] = "angel";
				i++;
				isOwned1 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 8 && !isOwned2 && boardbot.isProperty(8) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "euston";
				i++;
				isOwned2 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 9 && !isOwned3 && boardbot.isProperty(9) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "pentoville";
				i++;
				isOwned3 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 11 && !isOwned4 && boardbot.isProperty(11) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "mall";
				i++;
				isOwned4 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 13 && !isOwned5 && boardbot.isProperty(13) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "whitehall";
				i++;
				isOwned5 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 14 && !isOwned6 && boardbot.isProperty(14) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "northumberland";
				i++;
				isOwned6 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 16 && !isOwned7 && boardbot.isProperty(16) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "bow";
				i++;
				isOwned7 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 18 && !isOwned8 && boardbot.isProperty(18) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "marlborough";
				i++;
				isOwned8 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 19 && !isOwned9 && boardbot.isProperty(19) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "vine";
				i++;
				isOwned9 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 21 && !isOwned11 && boardbot.isProperty(21) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "strand";
				i++;
				isOwned11 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 23 && !isOwned12 && boardbot.isProperty(23) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "fleet";
				i++;
				isOwned12 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 24 && !isOwned13 && boardbot.isProperty(24) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "trafalgar";
				i++;
				isOwned13 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 26 && !isOwned14 && boardbot.isProperty(26) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "leicester";
				i++;
				isOwned14 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 27 && !isOwned15 && boardbot.isProperty(27) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "coventry";
				i++;
				isOwned15 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 29 && !isOwned16 && boardbot.isProperty(29) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "piccadilly";
				i++;
				isOwned16 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 31 && !isOwned17 && boardbot.isProperty(31) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses
				bought[i] = "regent";
				i++;
				isOwned17 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 32 && !isOwned18 && boardbot.isProperty(32) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses
				bought[i] = "oxford";
				i++;
				isOwned18 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 34 && !isOwned19 && boardbot.isProperty(34) && playerbot.getBalance() >= 250)
			{ // buy our given appointed houses 
				bought[i] = "bond";
				i++;
				isOwned19 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 5 && boardbot.isStation("King's Cross Station")) // buys station monopoly as part of strategy
			{
				bought[i] = "kings";
				i++;
				return "buy";
			}
			else if(playerbot.getPosition() == 15 && boardbot.isStation("Marylebone Station"))
			{
				bought[i] = "marylebone";
				i++;
				return "buy";
			}
			else if(playerbot.getPosition() == 25 && boardbot.isStation("Fenchurch St Station"))
			{
				bought[i] = "fenchurch";
				i++;
				return "buy";
			}
			else if(playerbot.getPosition() == 35 && boardbot.isStation("Liverpool St Station"))
			{
				bought[i] = "liverpool";
				i++;
				return "buy";
			}
			if(playerbot.getBalance() <= 100 && i <= 25)
			{
				for(i = 0; i <= 25;)
				{
					i = i + 1;
					if(bought[i].equals(bought[i])) // ensures same property is not mortgaged twice
					{
						i = 30;
					}
						return "mortgage " + bought[i++]; // mortgages properties to raise finance
				}
				
				return "done";
			}
			if(playerbot.getBalance() >= 450 && colouredProperty)
			{
				for(i = 0; i <= 25;)
				{
					i++;
					return "build" + bought[i] + 3; // build 3 house on each property if colour group owned
				}
				return "done";
			}
			if(playerbot.getBalance() <= 700 && colouredProperty)
			{
				for(i = 0; i <= 25;)
				{
					i++;
					return "demolish" + bought[i] + 3; // destroys house to gain finance 
				}
				return "done";
			}
			if(playerbot.isInJail()) // case for in jail
			{
				getDecision();
			}	
			if(playerbot.getBalance() <= 0 && playerbot.getNumHotelsOwned() == 0 && playerbot.getNumHousesOwned() == 0) // if player cannot afford to pay rent 
			{
				return "bankrupt";
			} 
			
			else
			{
				rollDone = false;
				return "done";
			}
	}
	
	public String getDecision () 
	{
		if(playerbot.isInJail() && playerbot.getBalance() >= 350) // in jail during early game
		{
			return "pay";
		}
		
		if(playerbot.isInJail() && playerbot.getBalance() <= 350) // in jail during late game
		{
			return "chance";
		}
		else
		{
		return "chance";
		}
	}
}

