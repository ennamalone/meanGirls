import java.util.ArrayList;
import java.util.Random;

public class Monopoly {


	public static final int NUM_SQUARES = 40;
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int rent = 50;
	public static final int price = 450;


	private ArrayList<Player> players = new ArrayList<Player>();
	private UI ui = new UI(players);
	int playerIndex = -1;
	String temp = new String();
	String command;
	String pnums;
	Money money = new Money();

	Monopoly () {

		for (int p=0; p < MAX_NUM_PLAYERS; p++) {

			ui.displayString("Please enter the player name for player " + (p+1) + ", or to finish enter done.");

			temp = ui.getCommand();

			if(temp.toLowerCase().equals("done")){

				ui.displayString(temp);
				break;

			}
			else
			{

				players.add(new Player(temp));
				ui.displayString(players.get(p).getName() + " is player " + (p+1) + ".");
				playerIndex++;

			}

		}

		do
		{
			ui.displayString("\n" + "\n" +  players.get(0).getName());
			command = ui.getCommand();
			ui.displayString(command);

			if(command.equalsIgnoreCase("balance")) // works no matter what case is used when typing the word
			{
				// calls new class money
				String numberAsString = Integer.toString(money.getBalance());
				ui.displayString(numberAsString);	// prints out 1500 in response to balance entered
			}

			if(command.equalsIgnoreCase("pay rent"))
			{
				// calls new class money
				String numberAsString1 = Integer.toString(money.payRent());
				ui.displayString(numberAsString1);
			}

			if(command.equalsIgnoreCase("buy"))
			{
				// calls new class money
				String numberAsString2 = Integer.toString(money.buyProperty());
				ui.displayString(numberAsString2);
			}

			if(command.equalsIgnoreCase("help"))
			{
				String validCommands = ">Accepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(validCommands);
			}

			if(!command.equalsIgnoreCase("help") || !command.equalsIgnoreCase("buy") || !command.equalsIgnoreCase("pay rent") || !command.equalsIgnoreCase("balance") || !command.equalsIgnoreCase("roll") || !command.equalsIgnoreCase("property"))
			{
				String errorMessage = "ERROR: Invalid command\nAccepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(errorMessage);
			}
		}
		while (!command.equals("quit"));

		ui.display();

		return;

	}

	public void whoFirst() {

		int diceA, diceB;
		int[] resArr = new int[6];
		Random diceRoll = new Random();

		for(int a = 0; a <= players.size(); a++)
		{

			diceA = diceRoll.nextInt(6);
			diceB = diceRoll.nextInt(6);
			resArr[a] = diceA + diceB;

		}

	}

	private void DiceRoll () {

		int rolls = 0;

		if((ui.getCommand().toLowerCase().equals("roll"))&&(rolls<1))
		{
			Random diceRoll = new Random();
			int dice1;
			int dice2;
			int diceTotal;


			dice1 = diceRoll.nextInt(6);
			dice2 = diceRoll.nextInt(6);

			ui.displayString("Your rolled dice are " + dice1 + " and " + dice2 + ".");

			diceTotal = dice1 + dice2;
			rolls++;

			if(dice1 == dice2)
			{

				rolls--;

			}

			for (int p=0; p<playerIndex; p++) {
				for (int i=0; i<diceTotal; i++) {
					players.get(p).move(+1);
					ui.display();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println("Sleep exeception.");
					}
				}
			}

		}
		else if((ui.getCommand().toLowerCase().equals("roll"))&&(rolls>1))
		{

			ui.displayString("You cannot roll until your next turn.");


		}

		return;
	}

	public void playerTurns(int i){

		if(i == (players.size()-1)){

			i = 0;

		}

		i++;
		playerTurns(i);

		return;

	}



	public static void main (String args[]) {
		Monopoly game = new Monopoly();
		return;
	}
}
