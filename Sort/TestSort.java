public class TestSort
{
	public static void main(String[] args)
	{
		SortArray mySort = new SortArray();
		int a[] = {1 , 5, 8, 123, 2, 23, 20};
		
		mySort.selectionSort(a, a.length);
		
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
}