import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

public class Monopoly
{
	public static final int NUM_SQUARES = 40;
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int rent = 16;

	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int playerIndex;
	String temp = new String();
	String command;
	private Boolean condition;

	Player player = new Player(command);
	int p = 0, z = 0, i = 0, k = 0;
	int rolls = 0;
	int dice1;
	int dice2;
	int diceTotal;

	void turn()
	{
		for(Player element : players)
		{ // allows each arraylist element to be accessed independently
			condition = true; // sets boolean
			playerTurns(element);// calls playerTurns function
		}
		
		turn();
	}

	Monopoly()
	{
		for (int p=0; p < MAX_NUM_PLAYERS; p++) 
		{ // gets players names and assigns a balance to each
			ui.displayString("Please enter the player name for player " + (p+1) + ", or to finish enter done.");
			temp = ui.getCommand();

			if(temp.toLowerCase().equals("done"))
			{
				ui.displayString(temp);
				whoFirst();
				turn();
				break;
			}
			else
			{

				players.add(new Player(temp));
				ui.displayString(players.get(p).getName() + " is player " + (p+1) + "."); // players name is displayed
				ui.displayString("Balance:" + players.get(p).getBalance()); // players balance is displayed
				playerIndex++;
			}
		}

		ui.display();
		return;
	}

	public void whoFirst()
	{ // function to decide who goes first based on highest dice roll

		int diceA = 0, diceB = 0, a = 0, temp = 0, playerOrder = 0;
		int resArr[] = new int[players.size() + 1];
		int RollFirst;

		if(players.size() < 2) // If there are less than 2 players
		{
			ui.displayString("\nYou need more players to play!");
		}
		else
		{
			ui.displayString("\nRolling the dice to see who goes first:");

			for(a = 0; a < players.size(); a++) // Runs for however many names have been entered
			{				
				diceA = 1 + (int)(Math.random() * 6.0); // dice roll random between 1-6
				diceB = 1 + (int)(Math.random() * 6.0); // dice roll random between 1-6

				RollFirst = diceA + diceB; // Finding the total of the two die

				resArr[a] = diceA + diceB;

				ui.displayString(players.get(a).getName() + " rolled " + RollFirst);
			}

			for(a = 0; a < players.size(); a++)
			{
				if(resArr[a] > temp) // Storing the largest number
				{
					temp = resArr[a];
					playerOrder = a; // The location of the highest roller in the players list
				}
			}

			String test = players.get(playerOrder).getName() + " rolled the highest number, " + temp + " and will play first!";
			ui.displayString(test);
		}

		Collections.swap(players, 0, playerOrder); // Swapping the highest roller with player 1 so that the highest roller starts

	}
	
	private void DiceRoll() 
	{
		Random diceRoll = new Random();

		if(rolls < 1)
		{
			dice1 = 1 + diceRoll.nextInt(6); // dice roll random between 1-6
			dice2 = 1 + diceRoll.nextInt(6); // dice roll random between 1-6

			ui.displayString("Your rolled dice are " + dice1 + " and " + dice2 + ".");

			diceTotal = dice1 + dice2;
			rolls++;

			// counts the number of dice roll so user can only have one rolls if doubled is not rolled

			for (int i = 0; i < diceTotal;  i++)
			{
				players.get(p).move(+1);
				ui.display();
				try
				{
					Thread.sleep(500);
				} catch (InterruptedException e)
				{
					System.out.println("Sleep exeception.");
				}
			}
		}
		else if(rolls >= 1) // case if player has already rolled this turn 
		{
			ui.displayString("You cannot roll until your next turn.");
			return;
		}
		if(dice1 == dice2)
		{
			rolls--;
			playerTurns(player);
			DiceRoll();
		}

		return;
	}

	public void playerTurns(Player e)
	{ 
		while(condition) // the boolean conditions is true will execute player turns and ensuing switch statements
		{
			ui.displayString("\n" +  e.getName());

			switch (ui.getCommand().toLowerCase())
			{
			case "roll": // rolls random dice to move players gamepiece
				DiceRoll();
				ui.displayString(player.prop[e.getPosition()]); // displays the name of property landed on by calling getPosition from player class 
				ui.displayString("price:" + player.proprice[e.getPosition()]); // displays said properties price
				if(e.getPosition() == 0 || e.getPosition() == 1 || e.getPosition() == 2 || e.getPosition() == 3)
				{
					e.passGO(); // adds 200 to the players bank account as they pass go 
				} 
				break;

			case "balance": // displays current players balance
				String numberAsString = Integer.toString(e.getBalance()); // calls getBalance function from players class
				ui.displayString(numberAsString);	// calls balance function form player class
				break;

			case "pay rent":
				String numberAsString1 = Integer.toString(e.payRent()); // calls pay Rent function from player class
				ui.displayString(numberAsString1);
				if(e.getBalance() <= 0)
				{
					for(int p = 0; p < players.size(); p++)
					{
						int temp = players.get(p).player2[0] + players.get(p).player2[1] + players.get(p).player2[2] + players.get(p).player2[3] + players.get(p).player2[4] + players.get(p).player2[5];
						// gets the sum of the value of each players property


						int temp1 = players.get(p).getBalance() + temp;
						String tempA = players.get(p).getName();
						int temp2 = players.get(p+1).getBalance() + (players.get(p+1).player2[0] + players.get(p+1).player2[1] + players.get(p+1).player2[2] + players.get(p+1).player2[3] + players.get(p+1).player2[4] + players.get(p+1).player2[5]);
						// get total of players assets and their balance 
						String tempB = players.get(p+1).getName(); // get players name associated with assets total
						if (temp1 < temp2)
						{
							temp1 = temp2; // compares to find largest 
							tempA = tempB;
						}

						JOptionPane.showMessageDialog(null, "The winner of the game is: " + tempA + " with a winning balance of " + temp1); 	
					}
				}
				break;

			case "buy":
				String numberAsString2 = Integer.toString(e.buyProperty()); // calls buyProperty function player class
				ui.displayString(numberAsString2);
				players.get(p).player1[i] = player.prop[e.getPosition()]; // adds name of property to each players personal array
				players.get(p).player2[i] = player.proprice[e.getPosition()];
				i++;
				k++;
				if(e.getBalance() <= 0)
				{
					for(int p = 0; p < players.size(); p++)
					{
						int temp = players.get(p).player2[0] + players.get(p).player2[1] + players.get(p).player2[2] + players.get(p).player2[3] + players.get(p).player2[4] + players.get(p).player2[5];
						// gets the sum of the value of each players property

						int temp1 = players.get(p).getBalance() + temp;
						String tempA = players.get(p).getName();
						int temp2 = players.get(p+1).getBalance() + (players.get(p+1).player2[0] + players.get(p+1).player2[1] + players.get(p+1).player2[2] + players.get(p+1).player2[3] + players.get(p+1).player2[4] + players.get(p+1).player2[5]);
						// get total of players assets and their balance 
						String tempB = players.get(p+1).getName(); // get players name associated with assets total
						if (temp1 < temp2)
						{
							temp1 = temp2; // compares to find largest 
							tempA = tempB;
						}

						JOptionPane.showMessageDialog(null, "The winner of the game is: " + tempA + " with a winning balance of " + temp1); 	
					}
				}
				break; 

			case "help": // if player requires help remembering commands 
				String validCommands = ">Accepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(validCommands);
				break;

			case "property": // gives players list of properties that are owned 
				int j = 0;
				ui.displayString("Properties owned are:" + "\n");
				while(j != k)
				{
					ui.displayString(players.get(p).player1[j]); // calls player1 array form player class
					j++;
				}
				break;

			case "done": // iterates the players
				p = p + 1;
				if(p == players.size()) // allows player to end turn so next player can begin their turn
				{
					p = 0;	
				}
				players.get(p).move(0);
				try {
					Thread.sleep(500);
				} catch (InterruptedException a)
				{
					System.out.println("Sleep exeception.");
				}
				rolls = 0;
				condition = false; // breaks boolean statement so switch statements can start again
				break;

			case "quit":
				for(int p = 0; p < players.size(); p++)
				{
					int temp = players.get(p).player2[0] + players.get(p).player2[1] + players.get(p).player2[2] + players.get(p).player2[3] + players.get(p).player2[4] + players.get(p).player2[5];
					// gets the sum of the value of each players property

					int temp1 = players.get(p).getBalance() + temp;
					String tempA = players.get(p).getName();
					int temp2 = players.get(p+1).getBalance() + (players.get(p+1).player2[0] + players.get(p+1).player2[1] + players.get(p+1).player2[2] + players.get(p+1).player2[3] + players.get(p+1).player2[4] + players.get(p+1).player2[5]);
					// get total of players assets and their balance 
					String tempB = players.get(p+1).getName(); // get players name associated with assets total
					if (temp1 < temp2)
					{
						temp1 = temp2; // compares to find largest 
						tempA = tempB;
					}

					JOptionPane.showMessageDialog(null, "The winner of the game is: " + tempA + " with a winning balance of " + temp1);
					ui.frame.dispose();
				}
				
			default: // case if a command is entered that is not recognised
				String errorMessage = "ERROR: Invalid command\nAccepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(errorMessage);
			}
		}		
		return;
	}
	public static void main (String args[])
	{
		Monopoly game = new Monopoly(); // launches the game
		return;
	}
}