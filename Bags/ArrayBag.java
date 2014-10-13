public class ArrayBag < T > implements BagInterface < T >
{
    private final T [] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag ()
    {
        this (DEFAULT_CAPACITY);
    } // end default constructor


    /** Creates an empty bag having a given initial capacity.
    @param capacity the integer capacity desired */

    public ArrayBag (int capacity)
    {
        numberOfEntries = 0;
        // the cast is safe because the new array contains null entries
        @ SuppressWarnings ("unchecked")
        T [] tempBag = (T []) new Object [capacity]; // unchecked cast
        bag = tempBag;
    } // end constructor


    /** Adds a new entry to this bag.
    @param newEntry the object to be added as a new entry
    @return true if the addition is successful, or false if not */
    /* 
     * Algorithm add(newEntry)
     * 	Input newEntry
     * 	Output boolean value
     * 
     * 	if n < DEFAULT_CAPACITY     1 comparison
     * 		bag[n] <- newEntry      2 assignments
     * 		n++                     2 increments
     * 		return true             1 output
     * 	else
     * 		return false            1 output
     * 
     *		O(6), , O(2)
     * */
    
    public boolean add (T newEntry)
    {
    	if ( numberOfEntries < DEFAULT_CAPACITY ) 
    	{
	        bag[numberOfEntries] = newEntry; 
	        numberOfEntries++;
	        return true;
    	}
    	else
    	{
    		return false;
    	}
    }


    /** Retrieves all entries that are in this bag.
    @return a newly allocated array of all the entries in the bag */
    /* 
     * Algorithm toArray()
     * 	Input
     * 	Output tempBag
     * 
     * 	T [] tempBag <- new T[n]    1 assignment
     * 	for i <- 0; i < n; i++		n + 1 comparisons
     * 		tempBag[i] <- bag[i]    n assignments
     * 	return tempBag              1 output
     * 
     * 		1 + (n + 1) + n + 1 = 2n + 3
     * 		O(n)
     * */
    
    public T [] toArray ()
    {
        @SuppressWarnings("unchecked")
		T [] tempBag = (T []) new Object [numberOfEntries];
        
        for ( int i = 0; i < numberOfEntries; i++ )
        {
        	tempBag[i] = bag[i];
        }
        
    	return tempBag;
    }


    /** Sees whether this bag is full.
    @return true if the bag is full, or false if not */
    /*
     * Algorithm isFull()
     * 	Input
     * 	Output n
     * 
     * 	n == DEFAULT_CAPACITY   1 comparison
     * 	return n                1 output
     * 
     * 		O(2)
     */
    public boolean isFull ()
    {
    	return numberOfEntries == DEFAULT_CAPACITY;
    }
    
    /*
     * Algorithm isEmpty()
     * 	Input 
     * 	Output
     * 	
     * 	n == 0      1 comparison
     * 	return n    1 output
     * 
     * 		O(2)
     */
    public boolean isEmpty ()
    {
    	return numberOfEntries == 0;
    }
    
    /*
     * Algorithm getCurrentSize()
     * 	Input 
     * 	Output
     * 	
     * 	return n    1 output
     * 
     * 		O(1)
     */    
    public int getCurrentSize ()
    {
    	return numberOfEntries;
    }
    
    /*
     * Algorithm clear()
     * 	Input 
     * 	Output
     * 	
     * 	n = 0    1 assignment
     * 
     * 		O(1)
     */  
    public void clear()
    {
    	numberOfEntries = 0;
    }
    
    /*
     * Algorithm contains(newEntry)
     * 	Input newEntry
     * 	Output boolean value
     * 
     * 	for i = 0; i < n; i++            n + 1 comparisons
     * 		if bag[i] = newEntry         2n comparisons
     * 			return true				 1 output
     * 	return false                     1 output
     * 
     * 		O(1), , O(n)
     */      
    public boolean contains(T newEntry)
    {
    	for (int i = 0; i < numberOfEntries; i++ )
    	{
    		if ( bag[i].equals(newEntry) )
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    /*
     * Algorithm getFrequencyOf(newEntry)
     * 	Input newEntry
     * 	Output count
     * 
     * 	count = 0                 1 assignment
     * 	for i = 0; i < n; i++     n + 1 comparisons
     * 		if bag[i] = newEntry  n comparisons
     * 			count++           2n assignments
     * 	return count              1 output
     * 
     * 		O(n)
     */
    public int getFrequencyOf(T newEntry)
    {
    	int count = 0;
    	
    	for ( int i = 0; i < numberOfEntries; i++ )
    	{
    		if (bag[i].equals(newEntry))
    		{
    			count++;
    		}
    	}
    	
    	return count;
    }
    
    /*
     * Algorithm remove()
     * 	Input
     * 	Output
     */
    public T remove()
    {
    	
    	return null;
    }
    
    /* 
     * Algorithm remove(newEntry)
     * 	Input newEntry
     * 	Output boolean value
     * 
     * 	if contains(anEntry)                                        1 comparison + 1 function
     * 		index <- findIndex(anEntry)                             1 assignment + 1 function
     * 		for i = index; i < DEFAULT_CAPACITY && i < n - 2; i++  
     * 			bag[i] <- bag[i + 1]
     * 		n--                                                     2 assignments
     * 		return true											    1 output
     * 	return false                                                1 output
     * */
    public boolean remove (T anEntry)
    {
    	if ( contains(anEntry) )
    	{
    		int index = findIndex(anEntry);
    		for ( int i = index; i < DEFAULT_CAPACITY - 2 && i < numberOfEntries - 2; i++ )
    		{
    			bag[i] = bag[i + 1];
    		}
    		
    		numberOfEntries--;
    		return true;
    	}
    	
    	return false;
    }
    
    /* 
     * Algorithm findIndex(anEntry)
     * 	Input anEntry
     * 	Output -1 or index i
     * 
     * 	for i = 0; i < n; i++     n + 1 comparisons
     * 		if bag[i] = anEntry
     * 			return i
     * 	return -1
     * */
    private int findIndex(T anEntry)
    {
    	for (int i = 0; i < numberOfEntries; i++)
    	{
    		if ( bag[i].equals(anEntry) )
    		{
    			return i;
    		}
    	}
    	
    	return -1;
    }
    // Similar partial definitions are here for the remaining methods
    //    declared in BagInterface. 
    //  ...
    
}