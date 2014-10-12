public class SortArray
{
    /** Sorts the first n objects in an array into ascending order.
    @param a an array of Comparable objects
    @param n an integer > 0 */
    public static <T extends Comparable <? super T>>
    void selectionSort (T[] a, int numOfEntries)
    {
        for (int index = 0 ; index < numOfEntries - 1 ; index++)
        {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, numOfEntries - 1);
            swap(a, index, indexOfNextSmallest);
        }
    }
    
    /** Sorts the array entries a[first] through a[last] recursively. 
    @param a an array of Comparable objects
    @param first an integer >= 0
    @param last an integer > first*/ 
    public static <T extends Comparable <? super T>>
    void selectionSort(T[] a, int first, int last)
    {
    	if (first < last)
    	{
    		int indexOfNextSmallest = getIndexOfSmallest(a, first, last - 1);
    		swap(a, first, indexOfNextSmallest);
    		selectionSort(a, first + 1, last);
    	}
    }
    
    public static < T extends Comparable < ? super T >>
    void bubbleSort(T[] a, int n)
    {
    	for (int i = 0; i < n - 1; i++)
    	{
    		for (int j = 0; j < n - 1; j++)
    		{
    			int indexOfSmallest = getIndexOfSmallest(a, i, j + 1);
    			swap(a, i, indexOfSmallest);
    		}
    	}
    }

    /** Finds the index of the smallest value in a portion of an array.
    @param a an array of Comparable objects
    @param first an integer >= 0 and < a.length that is the index of
    the first array entry to consider
    @param last an integer >= first and < a.length that is the
    index of the last array entry to consider
    @return the index of the smallest value among
    a[first], a[first + 1], . . . , a[last] */
    private static <T extends Comparable <? super T>>
    int getIndexOfSmallest (T[] a, int first, int last)
    {
        T min = a[first];
        int indexOfMin = first;
        
        for (int index = first + 1 ; index <= last ; index++)
        {
            if (a[index].compareTo(min) < 0)
            {
                min = a[index];
                indexOfMin = index;
            }
        }
        
        return indexOfMin;
    }

    /** Swaps the array entries a[i] and a[j].
    @param a an array of objects
    @param i an integer >= 0 and < a.length
    @param j an integer >= 0 and < a.length */
    private static void swap (Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}