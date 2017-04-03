import java.util.ArrayList;

// i broke rent 

public class Monopoly {

	public static final int MAX_NUM_PLAYERS = 6;
	private static final int START_MONEY = 1500;
	private static final int GO_MONEY = 200;

	private ArrayList<Player> players = new ArrayList<Player>();
	private Player currPlayer;
	private UI ui = new UI(players);
	private int numPlayers;
	private Dice dice = new Dice();
	private boolean gameOver = false;
	private Board board = new Board();
	String prop;
	int noBuild;
	int count = 0;
	private boolean colourOwned = false;

	Monopoly () {
		numPlayers = 0;
		ui.display();
		return;
	}

	public void inputNames () {
		do {
			ui.inputName(numPlayers);
			if (!ui.isDone()) {
				players.add(new Player(ui.getString(),ui.getTokenName(numPlayers)));
				numPlayers++;
			}
		} while (!ui.isDone() && numPlayers!=MAX_NUM_PLAYERS);
		return;
	}

	public void giveStartMoney () {
		for (Player p : players) {
			p.doTransaction (START_MONEY);
			ui.displayBankTransaction (p);
		}
		return;
	}

	public int getIndex(String name){
		for(int i = 0; i <= 39; i++)
		{
			if(board.isProperty(i))
			{
				Property property = board.getProperty(i);
				if(name.toLowerCase().equals(property.getName().toLowerCase()))
				{
					return i;
				}
			}
		}
		return 40;
	}

	public void decideStarter () {
		ArrayList<Player> inPlayers = new ArrayList<Player>(players),
				selectedPlayers = new ArrayList<Player>();
		boolean tie = false;
		do {
			int highestTotal = 0;
			for (Player p : inPlayers) {
				dice.roll();
				ui.displayDice(p,dice);
				if (dice.getTotal() > highestTotal) {
					tie = false;
					highestTotal = dice.getTotal();
					selectedPlayers.clear();
					selectedPlayers.add(p);
				} else if (dice.getTotal() == highestTotal) {
					tie = true;
					selectedPlayers.add(p);
				}
			}
			if (tie) {
				ui.displayRollDraw();
				inPlayers = new ArrayList<Player>(selectedPlayers);
				selectedPlayers.clear();
			}
		} while (tie);
		currPlayer = selectedPlayers.get(0);
		ui.displayRollWinner(currPlayer);
		ui.display();
		return;
	}

	public void processTurn () {
		boolean turnFinished = false;
		boolean rollDone = false;
		boolean rentOwed = false;
		boolean rentPaid = false;
		boolean negativeBalance = false;
		do {
			ui.inputCommand(currPlayer);
			switch (ui.getCommandId()) {
				case UI.CMD_ROLL :
					if(!negativeBalance){/////////////////////////////////////////
						if (!rollDone) {
							if (!rentOwed) {
								dice.roll();
								ui.displayDice(currPlayer, dice);
								currPlayer.move(dice.getTotal());
								ui.display();
								if (currPlayer.passedGo()) {
									currPlayer.doTransaction(+GO_MONEY);
									ui.displayPassedGo(currPlayer);
									ui.displayBankTransaction(currPlayer);
								}
								ui.displaySquare(currPlayer, board);
								if (board.isProperty(currPlayer.getPosition()) &&
										board.getProperty(currPlayer.getPosition()).isOwned() &&
										!board.getProperty(currPlayer.getPosition()).getOwner().equals(currPlayer) ) {
											rentOwed = true;
								} else {
									rentOwed = false;
								}
								if (!dice.isDouble()) {
									rollDone = true;
								}
							} else {
								ui.displayError(UI.ERR_RENT_OWED);
							}
						}	else {
							ui.displayError(UI.ERR_DOUBLE_ROLL);
						}
						} // end to if negative balance loop
					
					
						if(((currPlayer.getPosition() == 4)) || currPlayer.getPosition() %40 == 4) // case if player lands on Income tax and tax if payed immediately 
						{
							currPlayer.doTransaction(-200);
							ui.displayError(UI.INCOMETAX);
						}
						
						if(((currPlayer.getPosition() == 38)) || currPlayer.getPosition() %40 == 38) // case if player lands on Super tax and tax if payed immediately
						{
							currPlayer.doTransaction(-100);
							ui.displayError(UI.SUPERTAX);
						}
							if(currPlayer.getBalance() <= 0)
							{
								ui.displayError(UI.NEGATIVEBALANCE);
								negativeBalance = true;
							}
								else
								{
									negativeBalance = false;
								}
					break;
					
					
					
				case UI.CMD_PAY_RENT :
					if (board.isProperty(currPlayer.getPosition())) {
						Property property = board.getProperty(currPlayer.getPosition());
						if (property.isOwned()) {
							if (!property.getOwner().equals(currPlayer)) {
								if (!rentPaid) {
									if (currPlayer.getBalance()>=property.getRent()) {
										Player owner = property.getOwner();
										currPlayer.doTransaction(-property.getRent());
										owner.doTransaction(+property.getRent());
										ui.displayTransaction(currPlayer, owner);
										rentPaid = true;	
										rentOwed = false;
								} else {
									ui.displayError(UI.ERR_BANKRUPT);										
									} 
								} else {
									ui.displayError(UI.ERR_RENT_ALREADY_PAID);									
								}
							} else {
								ui.displayError(UI.ERR_SELF_OWNED);								
							}
						} else {
							ui.displayError(UI.ERR_NOT_OWNED);							
						}
					} else {
						ui.displayError(UI.ERR_NOT_A_PROPERTY);
					}
					break;
				case UI.CMD_BUY :
					if (board.isProperty(currPlayer.getPosition())) {
						Property property = board.getProperty(currPlayer.getPosition());
						if (!property.isOwned()) {
							if (currPlayer.getBalance() >= property.getValue()) {
								currPlayer.doTransaction(-property.getValue());
								ui.displayBankTransaction(currPlayer);
								currPlayer.boughtProperty(property);
								ui.displayLatestProperty(currPlayer);
							} else {
								ui.displayError(UI.ERR_INSUFFICIENT_FUNDS);
							}
						} else {
							ui.displayError(UI.ERR_IS_OWNED);
						}
					}
					break;
				case UI.CMD_BALANCE :
					ui.displayBalance(currPlayer);
					break;
				case UI.CMD_PROPERTY :
					ui.displayProperty(currPlayer);
					break;
				case UI.CMD_HELP :
					ui.displayCommandHelp();
					break;
				case UI.CMD_DONE :
					if (rollDone) {
						if(!negativeBalance){ ////////////////////////////////////////////////////
						if (!rentOwed || (rentOwed && rentPaid)) {
							turnFinished = true;
						} else {
							ui.displayError(UI.ERR_RENT_OWED);
						}
					}} else {
						ui.displayError(UI.ERR_NO_ROLL);
					}
					break;
					
					
				case UI.CMD_BUILD : // build command
					String temp_2 = ui.buildInput();
					ui.displayString(">" + ui.build);
					int temp_3 = ui.noBuildInput();
					if(temp_3 > 5)
					{
						ui.displayString("Too many buildings.");
						break;
					}
					ui.displayString(">" + ui.buildNo);
					Property property = board.getProperty(getIndex(temp_2));
					if(board.isProperty(getIndex(temp_2))&&currPlayer.equals(property.getOwner()))
					{
						for(int z = 0; z < currPlayer.getPropertySize(); z++)
						{
							if(property.getColour().equals(currPlayer.getPropertyColour(z)))
							{
								count++;
								if(((property.getColour().equals("dark blue"))||(property.getColour().equals("brown")))&&(count == 2)&&(!property.getColour().equals("utility")))
								{
									colourOwned = true;
									break;
								}
								else if((count == 3)&&(!property.getColour().equals("station")))
								{
									colourOwned = true;
									break;
								}
								else if((count <= 2)||(count <=3))
								{
									ui.displayString("You cannot build unless you own the whole colour group.");
								}
							}
						}
					}
					if(colourOwned)
					{
						property.addBuidings(temp_3);
						ui.displayString("> " + property.getNoOfBuildings());
						currPlayer.doTransaction(temp_3 * -(property.getBuildPrice()));
						ui.displayString("> Bank balance:" + currPlayer.getBalance());
					}

					break;
				case UI.CMD_DEMOLISH :
					String temp_4 = ui.buildInput();
					ui.displayString(">" + ui.build);
					int temp_5 = ui.noBuildInput();

					Property property_1 = board.getProperty(getIndex(temp_4));
					if(board.isProperty(getIndex(temp_4))&&currPlayer.equals(property_1.getOwner()))
					{
						if(temp_5 > 5)
						{
							ui.displayString("You can't demolish that many buildings.");
							break;
						}
						else if((property_1.getNoOfBuildings() >= 0)&&(property_1.getNoOfBuildings() > temp_5))
						{
							ui.displayString("There aren't enough buildings to demolish.");
							break;
						}

						if(board.isProperty(getIndex(temp_4))&&currPlayer.equals(property_1.getOwner()))
						{
							for(int x = 0; x < currPlayer.getPropertySize(); x++)
							{
								if(property_1.getColour().equals(currPlayer.getPropertyColour(x)))
								{
									count++;
									if(((property_1.getColour().equals("dark blue"))||(property_1.getColour().equals("brown")))&&(count == 2)&&(!property_1.getColour().equals("utility")))
									{
										colourOwned = true;
										break;
									}
									else if((count == 3)&&(!property_1.getColour().equals("station")))
									{
										colourOwned = true;
										break;
									}
									else if((count <= 2)||(count <=3))
									{
										ui.displayString("You cannot demolish unless you own the whole colour group.");
									}
								}
							}
						}
					}

					if(colourOwned)
					{
						property_1.demolishBuidings(temp_5);
						ui.displayString("> " + property_1.getNoOfBuildings());
						currPlayer.doTransaction((temp_5 * property_1.getBuildPrice())/2);
						ui.displayString("> Bank balance:" + currPlayer.getBalance());
					}

					break;
				case UI.CMD_QUIT :
					turnFinished = true;
					gameOver = true;
					break;
					
				case UI.CMD_BANKRUPT : // case if bankrupt command entered
					 ui.bankruptme(currPlayer, null, null, currPlayer, rentPaid); // done to match player configuration
					 players.remove(currPlayer); // removes the player form the game
					 numPlayers--;
					 turnFinished = true; // finishes turn
					if(numPlayers <= 1)
					{
						turnFinished = true; // if only one player left once bankruptcy declared calculates winner 
						gameOver = true;
					 }
					break;
			}
		} while (!turnFinished);
		return;
	}

	public void nextPlayer () {
		currPlayer = players.get((players.indexOf(currPlayer) + 1) % players.size());
		return;
	}

	public void decideWinner () {
		ArrayList<Player> playersWithMostAssets = new ArrayList<Player>();
		int mostAssets = players.get(0).getAssets();
		for (Player player : players) {
			ui.displayAssets(player);
			if (player.getAssets() > mostAssets) {
				playersWithMostAssets.clear();
				playersWithMostAssets.add(player);
			} else if (player.getAssets() == mostAssets) {
				playersWithMostAssets.add(player);
			}
		}
		if (playersWithMostAssets.size() == 1) {
			ui.displayWinner(playersWithMostAssets.get(0));
		} else {
			ui.displayDraw(playersWithMostAssets);
		}
		return;
	}

	public void displayGameOver () {
		ui.displayGameOver ();
		return;
	}

	public boolean isGameOver () {
		return gameOver;
	}

}
