
public class meanGirls implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	
	// : can't figure out how to check if colour group is owned and to then build and morguague houses 
	
	// a other errors let me know 
	public boolean rollDone = false;
	public boolean isOwned1 = false;
	public boolean isOwned2 = false;
	public boolean isOwned3 = false;
	public boolean isOwned4 = false;
	public boolean isOwned5 = false;
	public boolean isOwned6 = false;
	public boolean isOwned7 = false;
	public boolean isOwned8 = false;
	public boolean isOwned9 = false;
	public boolean isOwned10 = false;
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
			if(!rollDone)
			{
				rollDone = true;
					if(dicebot.isDouble())
					{
						return "roll";
					}
				return "roll";
			}
			
			if(playerbot.isInJail()) // case for in jail
			{
				getDecision();
			}	
			if(playerbot.getBalance() <= 0 && playerbot.getNumHotelsOwned() == 0 && playerbot.getNumHousesOwned() == 0) // if player cannot afford to pay rent 
			{
				return "bankrupt";
			} 
			if(playerbot.getPosition() == 7 && !isOwned1 && boardbot.isProperty(7))
			{ // buy our given appointed houses 
				isOwned1 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 9 && !isOwned2 && boardbot.isProperty(9))
			{ // buy our given appointed houses 
				isOwned2 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 10 && !isOwned3 && boardbot.isProperty(10))
			{ // buy our given appointed houses 
				isOwned3 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 11 && !isOwned4 && boardbot.isProperty(11))
			{ // buy our given appointed houses 
				isOwned4 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 13 && !isOwned5 && boardbot.isProperty(13))
			{ // buy our given appointed houses 
				isOwned5 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 14 && !isOwned6 && boardbot.isProperty(14))
			{ // buy our given appointed houses 
				isOwned6 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 16 && !isOwned7 && boardbot.isProperty(16))
			{ // buy our given appointed houses 
				isOwned7 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 18 && !isOwned8 && boardbot.isProperty(18))
			{ // buy our given appointed houses 
				isOwned8 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 19 && !isOwned9 && boardbot.isProperty(19))
			{ // buy our given appointed houses 
				isOwned9 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 21 && !isOwned10 && boardbot.isProperty(21))
			{ // buy our given appointed houses 
				isOwned10 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 22 && !isOwned11 && boardbot.isProperty(22))
			{ // buy our given appointed houses 
				isOwned11 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 23 && !isOwned12 && boardbot.isProperty(23))
			{ // buy our given appointed houses 
				isOwned12 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 25 && !isOwned13 && boardbot.isProperty(25))
			{ // buy our given appointed houses 
				isOwned13 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 26 && !isOwned14 && boardbot.isProperty(26))
			{ // buy our given appointed houses 
				isOwned14 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 27 && !isOwned15 && boardbot.isProperty(27))
			{ // buy our given appointed houses 
				isOwned15 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 29 && !isOwned16 && boardbot.isProperty(29))
			{ // buy our given appointed houses 
				isOwned16 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 31 && !isOwned17 && boardbot.isProperty(31))
			{ // buy our given appointed houses
				isOwned17 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 32 && !isOwned18 && boardbot.isProperty(32))
			{ // buy our given appointed houses
				isOwned18 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 34 && !isOwned19 && boardbot.isProperty(34))
			{ // buy our given appointed houses 
				isOwned19 = true;
				return "buy";
			}
			else if(playerbot.getPosition() == 5 && boardbot.isStation("King's Cross Station")) // buys station monopoly as part of strategy
			{
				return "buy";
			}
			else if(playerbot.getPosition() == 15 && boardbot.isStation("Marylebone Station"))
			{
				return "buy";
			}
			else if(playerbot.getPosition() == 25 && boardbot.isStation("Fenchurch St Statio"))
			{
				return "buy";
			}
			else if(playerbot.getPosition() == 35 && boardbot.isStation("Liverpool St Station"))
			{
				return "buy";
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

