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

    public boolean add (T newEntry)
    {
    	if ( numberOfEntries < DEFAULT_CAPACITY)
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
    public T [] toArray ()
    {
        T [] tempBag = (T []) new Object [numberOfEntries];
        
        for ( int i = 0; i < numberOfEntries; i++ )
        {
        	tempBag[i] = bag[i];
        }
        
    	return tempBag;
    }


    /** Sees whether this bag is full.
    @return true if the bag is full, or false if not */
    public boolean isFull ()
    {
    	return numberOfEntries == DEFAULT_CAPACITY;
    }

    public boolean isEmpty ()
    {
    	return numberOfEntries == 0;
    }
    
    public int getCurrentSize ()
    {
    	return numberOfEntries;
    }
    
    public void clear()
    {
    	numberOfEntries = 0;
    }
    
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
    
    public T remove()
    {
    	
    	return null;
    }
    
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
