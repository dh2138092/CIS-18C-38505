public class TestSort
{
	public static void main(String[] args)
	{
		String[] a = new String[] { "Jay", "Jack", "Zeek", "Robert", "Adam", "Susan", "Eve", "Dylan", "Lauren", "Heather", "Casey" };
		
		SortArray.bubbleSort(a, 0, a.length);
		
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
}