public void insertionSort ()
{
    // if zero or one item is in the chain, there is nothing to do
    if ( length > 1 )
    {
        assert firstNode != null;
        // break chain into 2 pieces: sorted and unsorted
        Node unsortedPart = firstNode.getNextNode ();
        assert unsortedPart != null;
        firstNode.setNextNode (null);
        
        while ( unsortedPart != null )
        {
            Node nodeToInsert = unsortedPart;
            unsortedPart = unsortedPart.getNextNode ();
            insertInOrder (nodeToInsert);
        }
    }
}