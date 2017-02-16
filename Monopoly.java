import java.util.ArrayList;

public class Monopoly {

	public static final int MAX_NUM_PLAYERS = 6;
	public static final int NUM_SQUARES = 40;
	
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Money money = new Money();
	private UI ui = new UI(players);
	
	Monopoly () {
		for (int p=0; p<MAX_NUM_PLAYERS; p++) {
			players.add(new Player());
		}		
		ui.display();
		return;
	}
	
	private void tour () {
		ui.displayString("TOUR MODE");
		for (int p=0; p<MAX_NUM_PLAYERS; p++) {
			for (int i=0; i<NUM_SQUARES; i++) {
				players.get(p).move(+1);
				ui.display();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep exeception.");
				} 
			}
		}
		return;
	}
	
	private void echo () {
		String command;
		ui.display();
		ui.displayString("ECHO MODE");
		do {
			command = ui.getCommand();
			ui.displayString(command);
			if(command.equals("balance"))
				{	
					 // calls new class money
					String numberAsString = Integer.toString(money.getBalance());
					System.out.println(money.getBalance());
					ui.displayString(numberAsString);	// prints out 1500 in response to balance entered
				}
		} 
		while (!command.equals("quit"));
		return;
	}
	
	public static void main (String args[]) {	
		Monopoly game = new Monopoly();		
		//game.tour();
		game.echo();
		return;
	}
}