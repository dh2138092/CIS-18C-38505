
public class StockPurchase 
{
	private double pricePerShare;
	
	public StockPurchase (double pricePerShare)
	{
		this.pricePerShare = pricePerShare;
	}
	
	public double getCostPerShare ()
	{
		return this.pricePerShare;
	}
}
