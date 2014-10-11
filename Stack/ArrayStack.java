import java.util.Arrays;

public class ArrayStack <T> implements StackInterface <T>
{
    private T[] stack;
    private int topIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    
    public ArrayStack ()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    } 

    public ArrayStack (int initialCapacity)
    {
        @ SuppressWarnings ("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
    }

    public void push(T newEntry)
    {
    	ensureCapacity();
    	topIndex++;
    	stack[topIndex] = newEntry;
    }
    
    private void ensureCapacity()
    {
	    if (topIndex == stack.length - 1)
	    {
	    	stack = Arrays.copyOf(stack,  2 * stack.length);
	    }
    }

    public T pop()
    {
    	T top = null;
    	
    	if (!isEmpty())
    	{
	    	top = stack[topIndex];
	    	stack[topIndex] = null;
	    	topIndex--; 
    	}
    	
    	return top;
    }

    public T peek()
    {
    	T top = null;
    	
    	if(!isEmpty())
    	{
    		top = stack[topIndex];
    	}
    	
    	return top;
    }

    public boolean isEmpty()
    {
    	return topIndex < 0;
    }

    public void clear()
    {
    	while ( !isEmpty() )
    	{
    		pop();
    	}
    }
    
    /** Sorts the first n objects in an array into ascending order.
    @param a an array of Comparable objects
    @param n an integer > 0 */
    public static < T extends Comparable < ? super T >>
    void selectionSort (T[] a, int n)
    {
        for (int index = 0 ; index < n - 1 ; index++)
        {
            int indexOfNextSmallest = getIndexOfSmallest (a, index, n - 1);
            swap (a, index, indexOfNextSmallest);
        }
    }
    
    public static < T extends Comparable < ? super T >>
    void selectionSortRecursive(T[] a, int n)
    {

    }

    /** Finds the index of the smallest value in a portion of an array.
    @param a an array of Comparable objects
    @param first an integer >= 0 and < a.length that is the index of
    the first array entry to consider
    @param last an integer >= first and < a.length that is the
    index of the last array entry to consider
    @return the index of the smallest value among
    a[first], a[first + 1], . . . , a[last] */
    private static < T extends Comparable < ? super T >>
    int getIndexOfSmallest (T [] a, int first, int last)
    {
        T min = a [first];
        int indexOfMin = first;
        
        for (int index = first + 1 ; index <= last ; index++)
        {
            if (a [index].compareTo (min) < 0)
            {
                min = a [index];
                indexOfMin = index;
            }
        }
        
        return indexOfMin;
    }

    /** Swaps the array entries a[i] and a[j].
    @param a an array of objects
    @param i an integer >= 0 and < a.length
    @param j an integer >= 0 and < a.length */
    private static void swap (Object [] a, int i, int j)
    {
        Object temp = a [i];
        a [i] = a [j];
        a [j] = temp;
    }
}