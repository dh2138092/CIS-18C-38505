public class TestSort
{
	public static void main(String[] args)
	{
		String[] a = new String[] { "Jay", "Jack", "Robert", "Adam", "Susan", "Eve", "Dylan", "Lauren", "Heather", "Casey" };
		
		SortArray.bubbleSort(a, a.length);
		
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
}