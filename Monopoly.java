import java.util.ArrayList;

public class Monopoly
{
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int NUM_SQUARES = 40;
	public static final int rent = 50;
	public static final int price = 450;

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<String> players1 = new ArrayList<String>(); // used to add player names 
	
	private Money money = new Money();
	private UI ui = new UI(players);
	private

	Monopoly() 
	{
		for (int p=0; p<MAX_NUM_PLAYERS; p++) 
		{
			players.add(new Player());
		}		
		ui.display();
		return;
	}

	private void tour()
	{
		ui.displayString("TOUR MODE");
		for (int p=0; p<MAX_NUM_PLAYERS; p++) 
		{
			for (int i=0; i<NUM_SQUARES; i++) 
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
		return;
	}

	private void echo()
	{
		String command;
		String pnums;
		ui.display();
		ui.displayString("Please enter player 1s name"); // sets up arraylist
		pnums = ui.getCommand();
		
			players1.add(0, pnums);
			ui.displayString("player 1 is: " +players1.get(0)); // insert snarky brian comment about obvious
			ui.displayString("Please enter next players name");
			pnums = ui.getCommand();
			players1.add(1, pnums);
			ui.displayString("player 2 is: " +players1.get(1));
			ui.displayString("Please enter next players name");
			pnums = ui.getCommand();
			players1.add(2, pnums);
			ui.displayString("player 3 is: " +players1.get(2));
			ui.displayString("Please enter next players name");
			pnums = ui.getCommand();
			players1.add(3, pnums);
			ui.displayString("player 4 is: " +players1.get(3));
			
			
		do
		{
			ui.displayString("\n" + "\n" +  players1.get(0));
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
		return;
	}

	public static void main (String args[])
	{	
		Monopoly game = new Monopoly();		
//		game.tour();
		game.echo();
		return;
	}
}