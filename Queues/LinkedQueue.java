/**
A class that implements a queue of objects by using
a chain of linked nodes.
*/
public class LinkedQueue < T > implements QueueInterface < T >
{
    private Node firstNode; // references node at front of queue

    private Node lastNode; // references node at back of queue

    public LinkedQueue ()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor


    public void enqueue (T newEntry)
    {
        Node newNode = new Node (newEntry, null);
        if (isEmpty ())
            firstNode = newNode;
        else
            lastNode.setNextNode (newNode);
        lastNode = newNode;
    } // end enqueue


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = firstNode.getData ();
            firstNode = firstNode.getNextNode ();
            if (firstNode == null)
                lastNode = null;
        } // end if
        return front;
    } // end dequeue


    public boolean isEmpty ()
    {
        return (firstNode == null) && (lastNode == null);
    } // end isEmpty


    public void clear ()
    {
        firstNode = null;
        lastNode = null;
    } // end clear


    private class Node
    {
        private T data; // entry in queue
        private Node next; // link to next node

        /*  Constructors and the methods getData, setData, getNextNode, and setNextNode
                are here. */

    } // end Node
} // end LinkedQueue