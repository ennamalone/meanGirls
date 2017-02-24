public class Money
{
	
	public int balance;
	
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
		balance = balance - Monopoly.price;
		return balance;
	}
	
	public int payRent()
	{
		balance = balance - Monopoly.rent;
		return balance;
	}
}