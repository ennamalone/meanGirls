
public class Money
{
	
	private int balance;
	
	Money () 
	{
		balance = 1500;
		return;
	}
	
	public int getBalance () 
	{
		return balance;
	}
	
	public int buyProperty()
	{
		return balance - Monopoly.price;
	}
	
	public int payRent()
	{
		return balance - Monopoly.rent;
	}
}