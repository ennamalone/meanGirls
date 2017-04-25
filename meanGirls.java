
public class meanGirls implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	public boolean rollDone = false;
	public boolean isOwned = false;
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
			if(dicebot.isDouble())
			{
				rollDone = false; // sets to false if a double is rolled
			} 
			if(playerbot.getPosition() == 7 || playerbot.getPosition() == 9 || playerbot.getPosition() == 10 || playerbot.getPosition() == 11 || playerbot.getPosition() == 13 || playerbot.getPosition() == 14 || playerbot.getPosition() == 16 || playerbot.getPosition() == 18 || playerbot.getPosition() == 19 || playerbot.getPosition() == 21 || playerbot.getPosition() == 21 || playerbot.getPosition() == 22 || playerbot.getPosition() == 23 || playerbot.getPosition() == 25 || playerbot.getPosition() == 26 || playerbot.getPosition() == 27 || playerbot.getPosition() == 29 || playerbot.getPosition() == 31 || playerbot.getPosition() == 32 || playerbot.getPosition() == 34 && !isOwned)
			{ // buy our given appointed houses 
				return "buy";
			}
			else if(playerbot.isInJail() && playerbot.getBalance() >= 350)
			{
				return "chance";
			}
			else if (playerbot.isInJail() && playerbot.getBalance() <= 350)
			{
				return "pay";
			}
			else if(playerbot.getBalance() >= 0 && playerbot.getNumHotelsOwned() == 0 && playerbot.getNumHousesOwned() == 0)
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

	
}

