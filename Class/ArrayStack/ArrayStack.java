public class ArrayStack < T > implements StackInterface < T >
{
    private T [] stack;
    
    private int topIndex;
    
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    
    public ArrayStack ()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    } 

    public ArrayStack (int initialCapacity)
    {
        @ SuppressWarnings ("unchecked")
        T [] tempStack = (T []) new Object [initialCapacity];
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
	    if ( topIndex == stack.length - 1 )
	    {
	    	stack = Arrays.copyT top = null;
	    	if(!isEmpty())
	    	{
	    	top = stack[topIndex];
	    	stack[topIndex] = null;
	    	topIndex--; 
	    	} // end if
	    	returntop;T top = null;
	    	if(!isEmpty())
	    	{
	    	top = stack[topIndex];
	    	stack[topIndex] = null;
	    	topIndex--; 
	    	} // end if
	    	returntop;Of(stack, 2 * stack.length);
	    }
    }

    public T pop()
    {
    	T top = null;
    	
    	if ( !isEmpty() )
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
    	
    	if( !isEmpty() )
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
}