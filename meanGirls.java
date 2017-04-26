public class meanGirls implements Bot
{
	// The public API of YourTeamName must not change
	// You cannot change any other classes
	// YourTeamName may not alter the state of the board or the player objects
	// It may only inspect the state of the board and the player objects

	boolean hasRolled = false;
	boolean ReleasedFromJail = false;
	static final int PASS_GO_ROLLS = 10; // Average amount of dice rolls it takes before completing one lap of the board i.e. EARLY GAME
	int rollCount = 0;
	int doubleCount = 0;
	private Site site;
	private Utility utility;
	private Station station;
	PlayerAPI thisplayer;
	BoardAPI thisboard;
	DiceAPI thisdice;

	meanGirls (BoardAPI board, PlayerAPI player, DiceAPI dice)
	{
		this.thisplayer = player;
		this.thisboard = board;
		this.thisdice = dice;
		return;
	}

	public String getName()
	{
		return "meanGirls";
	}

	public String getCommand()
	{
		rollCount = rollCount + 1;

		String inputCommand = "";

			if(!hasRolled) // Makes first roll of the turn
			{
				inputCommand = "roll";
				hasRolled = true;
			}

			else if(thisplayer.isInJail()) // Pay out of jail to avoid wasting time and miss out on buying properties
			{
				inputCommand = "pay";
				ReleasedFromJail = true;
			}


			else if(thisboard.getSquare(thisplayer.getPosition()) instanceof Site)
			{ // Runs when they land on an ordinary property
				site = (Site) thisboard.getSquare(thisplayer.getPosition());

				if(thisplayer.getBalance() > site.getPrice() && !site.isOwned())
				{
					inputCommand = "buy"; //buys any property as long as they can afford it
				}

				else if(thisdice.isDouble())
				{
					inputCommand = "roll";
				}

				else
				{
					hasRolled = false;
					inputCommand = "done";
				}
			}

			else if(thisboard.getSquare(thisplayer.getPosition()) instanceof Station) // Land on a station
			{
				station = (Station) thisboard.getSquare(thisplayer.getPosition());

				if(thisplayer.getBalance() > station.getPrice() && !station.isOwned())
				{
					inputCommand = "buy";				}

				else if(thisdice.isDouble())
				{
					inputCommand = "roll";
				}

				else
				{
					hasRolled = false;
					inputCommand = "done";
				}
			}

			else if(thisboard.getSquare(thisplayer.getPosition()) instanceof Utility)
			{
				utility = (Utility) thisboard.getSquare(thisplayer.getPosition());

				if(thisplayer.getBalance() > utility.getPrice() && !utility.isOwned())
				{
					inputCommand = "buy"; 
				}

				else if(thisdice.isDouble())
				{
					inputCommand = "roll";
				}

				else
				{
					hasRolled = false;
					inputCommand = "done";
				}
			}

			else if(thisboard.getSquare(thisplayer.getPosition()) instanceof CommunityChest || thisboard.getSquare(thisplayer.getPosition()) instanceof Chance || thisboard.getSquare(thisplayer.getPosition()) instanceof Tax || thisboard.getSquare(thisplayer.getPosition()) instanceof Square)
			{
				if(!thisdice.isDouble())
				{
					hasRolled = false;
					inputCommand = "done";
				}

				else if(ReleasedFromJail && !thisdice.isDouble())
				{
					hasRolled = false;
					ReleasedFromJail = false;
					inputCommand = "done";
				}

				else if(thisdice.isDouble() && !ReleasedFromJail)
				{
					inputCommand = "roll";
				}
			}
		
		return inputCommand;
	}

	public String getDecision()
	{
		String inputCommand = "roll";
		return inputCommand;
	}
}
