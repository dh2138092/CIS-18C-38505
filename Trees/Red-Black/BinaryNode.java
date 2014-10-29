// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of this package.

class BinaryNode<AnyType extends Comparable>
{
        // Constructor
    BinaryNode( AnyType theElement )
    {
        element = theElement;
        left = right = parent = null;
        color = Color.RED;
    }
    
    public enum Color
    {
    	RED, BLACK
    }
    
    public static BinaryNode grandparent(BinaryNode n)
    {
    	if (n != null)
    	{
    		if (n.parent != null)
    		{
    			return n.parent.parent;
    		}
    	}
    	
    	return null;
    }
    public static BinaryNode uncle(BinaryNode n)
    {
    	BinaryNode g = grandparent(n);
    	if (g == null)
    		return null;
    	if (n.parent == g.left)
    		return g.right;
    	else
    		return g.left;
    }
    
    public static BinaryNode sibling(BinaryNode n)
    {
    	if (n.parent == null)
    	{
    		return null;
    	}
    	
    	if (n == n.parent.left)
    	{
    		return n.parent.right;
    	}
    	else
    	{
    		return n.parent.left;
    	}
    }

      // Data; accessible by other package routines
    AnyType             element;  // The data in the node
    BinaryNode<AnyType> left;     // Left child
    BinaryNode<AnyType> right;    // Right child
    BinaryNode<AnyType> parent;
    Color color;
}