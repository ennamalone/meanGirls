
public class meanGirls implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects
	
	//problems: if one bot goes to jail and the turn switches if continues to use commands for the jailed bot 
	// : can't figure out how to check if colour group is owned and to then build and morguague houses 
	// perhaps change to switch statements?
	// any other errors let me know 

	public boolean rollDone = false;
	private Site site;
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
		// Add your code here////////////////////////////////
		
		if(!rollDone)
		{
			rollDone = true;
			/*if(dicebot.isDouble())
			{
				rollDone = false; // sets to false if a double is rolled
			} */
			
			
			if(rollDone == true)
			{	
				if(boardbot.getSquare(playerbot.getPosition()) instanceof Site)
				{
					site = (Site) boardbot.getSquare(playerbot.getPosition());
					
					if(!site.isOwned())
					{
						return "buy";
					}
				}
			}
			
			if(playerbot.isInJail() && playerbot.getBalance() <= 350) // case for in jail late game
			{
				///
				return "pay";
			}
			else if (playerbot.isInJail() && playerbot.getBalance() >= 350) // case for in jail early game
			{
				return "pay";
			}
			
			if(playerbot.getBalance() <= 0 && playerbot.getNumHotelsOwned() == 0 && playerbot.getNumHousesOwned() == 0)
			{
				return "bankrupt";
			} 
			
			return "roll";
		}
		else
		{
			rollDone = false;
			return "done";
		}
	}
	
	public String getDecision () 
	{
		// Add your code here
		return "done";
	}

	// || playerbot.getPosition() == 9 || playerbot.getPosition() == 10 || playerbot.getPosition() == 11 || playerbot.getPosition() == 13 || playerbot.getPosition() == 14 || playerbot.getPosition() == 16 || playerbot.getPosition() == 18 || playerbot.getPosition() == 19 || playerbot.getPosition() == 21 || playerbot.getPosition() == 21 || playerbot.getPosition() == 22 || playerbot.getPosition() == 23 || playerbot.getPosition() == 25 || playerbot.getPosition() == 26 || playerbot.getPosition() == 27 || playerbot.getPosition() == 29 || playerbot.getPosition() == 31 || playerbot.getPosition() == 32 || playerbot.getPosition() == 34
}
