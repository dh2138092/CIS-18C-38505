/**
A class that implements a deque of objects by using
a chain of doubly linked nodes.
*/
public class LinkedDeque < T > implements DequeInterface < T >
{
    private DLNode firstNode; // references node for front of deque
    private DLNode lastNode; // references node for back of deque
    
    public LinkedDeque ()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor


    public void addToBack (T newEntry)
    {
        if (isEmpty ())
            firstNode = newNode;
        else
            lastNode.setNextNode (newNode);
        lastNode = newNode;
    } // end addToBack


    public void addToFront (T newEntry)
    {
        DLNode newNode = new DLNode (null, newEntry, firstNode);
        if (isEmpty ())
            lastNode = newNode;
        else
            firstNode.setPreviousNode (newNode);
        firstNode = newNode;
    } // end addToFront


    public T removeFront ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = firstNode.getData ();
            firstNode = firstNode.getNextNode ();
            if (firstNode == null)
                lastNode = null;
        } // end if
        (a)
                (b)
                newNode
                lastNode
                lastNode
                else
                firstNode.setPreviousNode (null);
            return front;
    } // end removeFront


    public T removeBack ()
    {
        T back = null;
        if (!isEmpty ())
        {
            back = lastNode.getData ();
            lastNode = lastNode.getPreviousNode ();
            if (lastNode == null)
                firstNode = null;
            else
                lastNode.setNextNode (null);
        } // end if
        return back;
    } // end removeBack


    private class DLNode
    {
        private T data; // deque entry
        private DLNode next; // link to next node
        private DLNode previous; // link to previous node


        /*Constructors and the methods getData, setData, getNextNode, setNextNode,
            getPreviousNode, and setPreviousNode are here. >
            . . .*/

    } // end DLNode
    
} // end LinkedDeque