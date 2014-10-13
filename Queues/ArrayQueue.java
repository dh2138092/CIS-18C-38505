/**
A class that implements a queue of objects by using an array.
*/
public class ArrayQueue < T > implements QueueInterface < T >
{
    private T [] queue; // circular array of queue entries and one unused
    // location

    private int frontIndex;
    private int backIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public ArrayQueue ()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    } // end default constructor


    public ArrayQueue (int initialCapacity)
    {
        // the cast is safe because the new array contains null entries
        @ SuppressWarnings ("unchecked")
            T [] tempQueue = (T []) new Object [initialCapacity + 1];
        queue = tempQueue;
        frontIndex = 0;
        backIndex = initialCapacity;
    } // end constructor


    public void enqueue (T newEntry)
    {
        ensureCapacity ();
        backIndex = (backIndex + 1) % queue.length;
        queue [backIndex] = newEntry;
    } // end enqueue


    public T getFront ()
    {
        T front = null;
        if (!isEmpty ())
            front = queue [frontIndex];
        return front;
    } // end getFront


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = queue [frontIndex];
            queue [frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
        } // end if
        return front;
    } // end dequeue


    // Doubles the size of the array queue if it is full
    private void ensureCapacity ()
    {
        if (frontIndex == ((backIndex + 2) % queue.length)) // if array is full,
        { // double size of array
            T [] oldQueue = queue;
            int oldSize = oldQueue.length;
            // the cast is safe because the new array contains null entries
            @ SuppressWarnings ("unchecked")
                T [] tempQueue = (T []) new Object [2 * oldSize];
            queue = tempQueue;
            for (int index = 0 ; index < oldSize - 1 ; index++)
            {
                queue [index] = oldQueue [frontIndex];
                frontIndex = (frontIndex + 1) % oldSize;
            } // end for
            frontIndex = 0;
            backIndex = oldSize - 2;
        } // end if
    } // end ensureCapacity


    public boolean isEmpty ()
    {
        return frontIndex == ((backIndex + 1) % queue.length);
    } // end isEmpty
    
} // end ArrayQueue