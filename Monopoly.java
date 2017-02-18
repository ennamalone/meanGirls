import java.util.ArrayList;

public class Monopoly
{
	public static final int MAX_NUM_PLAYERS = 6;
	public static final int NUM_SQUARES = 40;
	public static final int rent = 50;
	public static final int price = 450;

	private ArrayList<Player> players = new ArrayList<Player>();
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
		ui.display();
		ui.displayString("ECHO MODE");
		do 
		{
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
				ui.displayString(numberAsString1);	// prints out 1500 in response to balance entered
			}

			if(command.equalsIgnoreCase("buy"))
			{	
				// calls new class money
				String numberAsString2 = Integer.toString(money.buyProperty());
				ui.displayString(numberAsString2);	// prints out 1500 in response to balance entered
			}

			if(command.equalsIgnoreCase("help"))
			{
				String validCommands = ">Accepted commands are: BALANCE, BUY, PAY RENT, HELP, PROPERTY, ROLL";
				ui.displayString(validCommands);
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
