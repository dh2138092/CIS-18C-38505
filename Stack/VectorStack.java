import java.util.Vector;

public class VectorStack < T > implements StackInterface < T >
{

    private Vector <T> stack; // last element is the top entry in stack

    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    } // end default constructor


    public VectorStack(int initialCapacity)
    {
        stack = new Vector < T > (initialCapacity); // size doubles as needed
    } // end constructor


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
    	
    	if ( ! isEmpty() )
    	{
    		top = stack.lastElement();
    	}
    	
    	return top;
    }
    

    public boolean isEmpty (){ return false;}

    public void clear (){}
    /* Implementations of the stack operations go here. 
    . . .  */

} // end VectorStack