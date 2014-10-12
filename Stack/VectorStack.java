import java.util.Vector;

public class VectorStack < T extends Comparable < ? super T >> implements StackInterface < T >
{
    private Vector <T> stack;

    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    }


    public VectorStack(int initialCapacity)
    {
        stack = new Vector <T> (initialCapacity);
    }


    public void push(T newEntry)
    {
    	stack.add(newEntry);
    }
    

    public T pop()
    { 
    	T top = null;
    	
    	if ( !isEmpty() )
    	{
    		top = stack.remove(stack.size() - 1);
    	}
    	
    	return top;
    }
    

    public T peek()
    {
    	T top = null;
    	
    	if ( !isEmpty() )
    	{
    		top = stack.lastElement();
    	}
    	
    	return top;
    }
    

    public boolean isEmpty ()
    { 
    	return stack.isEmpty(); 
    }

    public void clear ()
    {
    	stack.clear();
    }
    
    public static < T extends Comparable < ? super T >> void bubbleSort()
    {
    	
    }
    
    public static < T extends Comparable < ? super T >> void bubbleSortRecursive()
    {
    	
    }
    
    public static < T extends Comparable < ? super T >> void selectionSort(T[] a, int n)
    {
        for ( int index = 0 ; index < n - 1 ; index++ )
        {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap (a, index, indexOfNextSmallest);
        }
    }

    private static < T extends Comparable < ? super T >> int getIndexOfSmallest(T [] a, int first, int last)
    {
        T min = a [first];
        int indexOfMin = first;
        for ( int index = first + 1 ; index <= last ; index++ )
        {
            if ( a[index].compareTo(min) < 0 )
            {
                min = a [index];
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }

    private static void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static < T extends Comparable < ? super T >> void selectionSortRecursive(T[] a, int startIndex)
    {
    	if ( startIndex >= a.length - 1)
    	{
    		return;
    	}
    	
    	int minimumIndex = startIndex;
    	
        for ( int index = startIndex + 1; index < a.length; index++ )
        {
            if ( a[index] < a[minimumIndex] )
            {
            	minimumIndex = index;
            }
        }
        swap (a, startIndex, minimumIndex);
        selectionSortRecursive(a, startIndex + 1);
    }
}