
public class meanGirls implements Bot {
	
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	public boolean rollDone = false;
	public boolean isOwned = false;
	BoardAPI boardbot;
	PlayerAPI playerbot;
	DiceAPI dicebot;

	
	meanGirls (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		boardbot = board;
		playerbot = player;
		dicebot = dice;
		return;
	}
	
	public String getName (BoardAPI board, PlayerAPI player, DiceAPI dice) {
		boardbot = board;
		playerbot = player;
		dicebot = dice;
		return "meanGirls";
	}
	
	public String getCommand (BoardAPI board, PlayerAPI player, DiceAPI dice) 
	{
		boardbot = board;
		playerbot = player;
		dicebot = dice;
		
		// Add your code here////////////////////////////////
		
		if(!rollDone)
		{
			rollDone = true;
			if(dice.isDouble())
			{
				rollDone = false; // sets to false if a double is rolled
			} 
			if(player.getPosition() == 7 || player.getPosition() == 9 || player.getPosition() == 10 || player.getPosition() == 11 || player.getPosition() == 13 || player.getPosition() == 14 || player.getPosition() == 16 || player.getPosition() == 18 || player.getPosition() == 19 || player.getPosition() == 21 || player.getPosition() == 21 || player.getPosition() == 22 || player.getPosition() == 23 || player.getPosition() == 25 || player.getPosition() == 26 || player.getPosition() == 27 || player.getPosition() == 29 || player.getPosition() == 31 || player.getPosition() == 32 || player.getPosition() == 34 && !isOwned)
			{ // buy our given appointed houses 
				return "buy";
			}
			else if(player.isInJail() && player.getBalance() >= 350)
			{
				return "chance";
			}
			else if (player.isInJail() && player.getBalance() <= 350)
			{
				return "pay";
			}
			else if(player.getBalance() >= 0 && player.getNumHotelsOwned() == 0 && player.getNumHousesOwned() == 0)
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "meanGirls";
	}

	@Override
	public String getCommand() {
		// TODO Auto-generated method stub
		if(!rollDone)
		{
			rollDone = true;
			return "roll";
		}
		else
		{
			rollDone = false;
			return "done";
		}
	}
	
}

