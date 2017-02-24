
public class Player { // moves player pieces around the board
	
	private int position;
	private int balance = 1500;
	private String name = new String();
	property properties = new property();
	
	

	Player (String userName) {
		position = 0;
		name = userName;
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
	public int getBalance () 
	{
		return balance;
	}
	
	public int buyProperty()
	{
		balance = balance - properties.proprice[getPosition()];
		return balance;
	}
	
	public int payRent()
	{
		balance = balance - Monopoly.rent;
		return balance;
	}
	
	public int passGO()
	{
		balance = balance + 200;
		return balance;
	}

	
}
