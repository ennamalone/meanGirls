
public class Player { // moves player pieces around the board
	
	private int position;
	private String name = new String();
	private Money money = new Money();
	
	Player (String userName) {
		position = 0;
		return;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void move (int squares) 
	{
		position = position + squares;
		if (position < 0) 
		{
			position = position + Monopoly.NUM_SQUARES;
		} else if (position >= Monopoly.NUM_SQUARES) 
		{
			position = position % Monopoly.NUM_SQUARES;
		}
		return;
	}
	
	public int getPosition () 
	{
		return position;
	}

	public int getBalance() 
	{
		return money.getBalance(); //////
	}

	
	
}
