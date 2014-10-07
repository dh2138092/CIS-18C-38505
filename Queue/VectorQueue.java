import java.util.Vector;
/**
A class that implements a queue of objects by using a vector.
*/
public class VectorQueue < T > implements QueueInterface < T >
{
    private Vector < T > queue; // queues front entry is first in the vector

    public VectorQueue ()
    {
        queue = new Vector < T > (); // vector doubles in size if necessary
    } // end default constructor


    public VectorQueue (int initialCapacity)
    {
        queue = new Vector < T > (initialCapacity);
    } // end constructor


    public void enqueue (T newEntry)
    {
        queue.add (newEntry);
    } // end enqueue


    public T getFront ()
    {
        T front = null;
        if (!isEmpty ())
            front = queue.get (0);
        return front;
    } // end getFront


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
            front = queue.remove (0);
        return front;
    } // end dequeue


    public boolean isEmpty ()
    {
        return queue.isEmpty ();
    } // end isEmpty


    public void clear ()
    {
        queue.clear ();
    } // end clear
    
} // end VectorQueue