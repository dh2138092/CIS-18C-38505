/**
A class that implements a queue of objects by using
a two-part circular chain of linked nodes
*/
public class TwoPartCircularLinkedQueue < T > implements QueueInterface < T >
{
    private Node queueNode; // references first node in queue
    private Node freeNode; // references node after back of queue
    
    public TwoPartCircularLinkedQueue ()
    {
        freeNode = new Node (null, null);
        freeNode.setNextNode (freeNode);
        queueNode = freeNode;
    } // end default constructor


    public void enqueue (T newEntry)
    {
        freeNode.setData (newEntry);
        if (isChainFull ())
        {
            // allocate a new node and insert it after the node that
            // freeNode references
            Node newNode = new Node (null, freeNode.getNextNode ());
            freeNode.setNextNode (newNode);
        } // end if
        freeNode = freeNode.getNextNode ();
    } // end enqueue


    public T getFront ()
    {
        T front = null;
        if (!isEmpty ())
            front = queueNode.getData ();
        return front;
    } // end getFront


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = queueNode.getData ();
            queueNode.setData (null);
            queueNode = queueNode.getNextNode ();
        } // end if
        return front;
    } // end dequeue


    public boolean isEmpty ()
    {
        return queueNode == freeNode;
    } // end isEmpty


    private boolean isChainFull ()
    {
        return queueNode == freeNode.getNextNode ();
    } // end isChainFull


    private class Node
    {
        private T data; // queue entry
        private Node next; // link to next node
        /*Constructors and the methods getData, setData, getNextNode, and setNextNode
        are here.
        . . .  */
    } // end Node
    
} // end TwoPartCircularLinkedQueue