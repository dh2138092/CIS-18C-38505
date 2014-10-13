private void insertInOrder (Node nodeToInsert)
{
    T item = nodeToInsert.getData ();
    Node currentNode = firstNode;
    Node previousNode = null;

    // locate insertion point
    while ( (currentNode != null) && (item.compareTo (currentNode.getData ()) > 0) )
    {
        previousNode = currentNode;
        currentNode = currentNode.getNextNode ();
    }

    // make the insertion
    if ( previousNode != null )
    { 
    	// insert between previousNode and currentNode
        previousNode.setNextNode (nodeToInsert);
        nodeToInsert.setNextNode (currentNode);
    }
    else // insert at beginning
    {
        nodeToInsert.setNextNode (firstNode);
        firstNode = nodeToInsert;
    }
}