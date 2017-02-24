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
	public int getBalance1 () 
	{
		return balance;
	}
	public int getBalance2 () 
	{
		return balance;
	}
	public int getBalance3 () 
	{
		return balance;
	}
	public int getBalance4 () 
	{
		return balance;
	}
	public int getBalance5 () 
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