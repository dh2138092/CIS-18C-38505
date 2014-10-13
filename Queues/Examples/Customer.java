
public class Customer 
{
	
	int clock; 
	int transactionTime;
	int numberOfArrivals;
	
	public  Customer (int clock, int transactionTime, int numberOfArrivals)
	{
		this.clock = clock;
		this.transactionTime = transactionTime;
		this.numberOfArrivals = numberOfArrivals;
	}
	
	public int getTransactionTime()
	{
		return transactionTime;
	}
	
	public int getArrivalTime()
	{
		return clock;
	}
	
	public int getCustomerNumber()
	{
		return numberOfArrivals;
	}
}
