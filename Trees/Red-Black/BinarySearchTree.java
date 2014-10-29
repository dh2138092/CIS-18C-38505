
	

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove minimum item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * Insert into the tree.
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert(AnyType x)
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree..
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove(AnyType x)
    {
    	BinaryNode n = find(x, root);
    	
    	if (n == null)
    		return;
    	
    	removeNode(x, n);
    }
    
    protected void removeNode(AnyType x, BinaryNode n)
    {
       if (n.left != null && n.right != null)
       {
          // same in BST, swap with findMax(n.left) or findMin(n.right)
    	   root = remove(x, root);
       } 
       else if (n.left != null && n.right == null)
       {
          n.left.parent = n.parent;
          if (n.color == BinaryNode.Color.BLACK)
          {
             if (n.left.color == BinaryNode.Color.RED)
                n.left.color = BinaryNode.Color.BLACK;
             else
                del_recolor_1(n.left);
          }
       }
       else if (n.left == null && n.right != null)
       {
          n.right.parent = n.parent;
          if (n.color == BinaryNode.Color.BLACK)
          {
             if (n.right.color == BinaryNode.Color.RED)
                n.right.color = BinaryNode.Color.BLACK;
             else
                del_recolor_1(n.right);
          }
       }
       
       delete_leaf(n);
    }

    /**
     * Remove minimum item from the tree.
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin( )
    {
        root = removeMin( root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        return elementAt( findMin( root ) );
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item or null if empty.
     */
    public AnyType findMax( )
    {
        return elementAt( findMax( root ) );
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public AnyType find(AnyType x)
    {
        return elementAt(find(x, root));
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Internal method to get element field.
     * @param t the node.
     */
    private AnyType elementAt( BinaryNode<AnyType> t )
    {
        return t == null ? null : t.element;
    }
    
    /** Recursively search the tree for the target */
    private BinaryNode search(BinaryNode<AnyType> curr, AnyType target)
    {
    	if (curr != null)
    	{
    		if (target == curr.element)
    			return curr;
    		else
    		{
    			search(curr.left, target);
    			search(curr.right, target);
    		}
    	}
    	
    	return null;
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    protected BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            t = new BinaryNode<AnyType>( x );
        else if( x.compareTo( t.element ) < 0 )
            t.left = insert( x, t.left );
        else if( x.compareTo( t.element ) > 0 )
            t.right = insert( x, t.right );
        else
        {
            System.out.println("Duplicate Item Exception: "+ x.toString( ) );  // Duplicate
            return t;
        }
        
        ins_recolor_1(t);
        
        return t;
    }
    
    protected void ins_recolor_1 ( BinaryNode n )
    {
       if( n.parent == null)
       {
          n.color = BinaryNode.Color.BLACK;
       }
       else
       {
          ins_recolor_2( n );
       }
    }

    protected void ins_recolor_2 ( BinaryNode n )
    {
       if( n.parent.color == BinaryNode.Color.BLACK )
          return; // Tree is valid
       else
          ins_recolor_3( n );
    }
    
    protected void ins_recolor_3 ( BinaryNode n )
    {
       BinaryNode u = BinaryNode.uncle( n );
       if ( u != null) 
       {
          if (u.color == BinaryNode.Color.RED)
          {  
             n.parent.color = BinaryNode.Color.BLACK;
             u.color = BinaryNode.Color.BLACK;
             BinaryNode g = BinaryNode.grandparent( n );
             g.color = BinaryNode.Color.RED;
             ins_recolor_1( g );
          }
       }
       else
       {
          ins_recolor_4( n );
       }
    }

    protected void ins_recolor_4 ( BinaryNode n )
    {
       BinaryNode g = BinaryNode.grandparent( n );
       if (n == n.parent.right && n.parent == g.left)
       {
          rotate_left( n.parent );
          n = n.left;
       }
       else if (n == n.parent.left && n.parent == g.right)
       {
          rotate_right( n.parent );
          n = n.right;
       }
       ins_recolor_5 ( n );
    }

    protected void ins_recolor_5 ( BinaryNode n )
    {
       BinaryNode g = BinaryNode.grandparent( n );

       n.parent.color = BinaryNode.Color.BLACK;
       g.color = BinaryNode.Color.RED;

       if (n == n.parent.left)
       {
          rotate_right( g );
       }
       else
       {
          rotate_left( g );
       }
    }

    protected void rotate_right ( BinaryNode n )
    {
       BinaryNode l = n.left;
       l.parent = n.parent;
       n.left = l.right;
       l.right = n;

       if (n == root)
       {
         root = l;
       }
    }
    
    protected void rotate_left ( BinaryNode n )
    {
       BinaryNode r = n.right;
       r.parent = n.parent;
       n.right = r.left;
       r.left = n;

       if (n == root)
       {
         root = r;
       }
    }
    
    protected void delete_leaf (BinaryNode n)
    {
       if (n.parent != null)
       {
         if (n == n.parent.left)
         {
            n.parent.left = null;
         }
         else if (n == n.parent.right)
         {
            n.parent.right = null;
         }
       }
       
       n = null;
    }
       
    protected void del_recolor_1(BinaryNode n)
    {
       if( n.parent != null)
       {
          del_recolor_2( n );
       }
    }

    protected void del_recolor_2(BinaryNode n)
    {
       BinaryNode s = BinaryNode.sibling( n );
       if (s.color == BinaryNode.Color.RED)
       {
          n.parent.color = BinaryNode.Color.RED;
          s.color = BinaryNode.Color.BLACK;
          if (n == n.parent.left)
             rotate_left(n.parent);
          else
             rotate_right(n.parent);
       }
       del_recolor_3(n);
    }
    
    void del_recolor_3(BinaryNode n)
    {
       BinaryNode s = BinaryNode.sibling( n );
       if( n.parent.color == BinaryNode.Color.BLACK && 
           s.color == BinaryNode.Color.BLACK &&
           s.left.color == BinaryNode.Color.BLACK &&
           s.right.color == BinaryNode.Color.BLACK )
       {
          s.color = BinaryNode.Color.RED;
          del_recolor_1( n.parent );
       }
       else
          del_recolor_4( n );
    }
    
    void del_recolor_4 ( BinaryNode n )
    {
       BinaryNode s = BinaryNode.sibling( n );
       if (n.parent.color == BinaryNode.Color.RED && 
           s.color == BinaryNode.Color.BLACK &&
           s.left.color == BinaryNode.Color.BLACK &&
           s.right.color == BinaryNode.Color.BLACK )
       {
          s.color = BinaryNode.Color.RED;
          n.parent.color = BinaryNode.Color.BLACK;
       }
       else
          del_recolor_5( n );
    }
    
    protected void del_recolor_5(BinaryNode n)
    {
       BinaryNode s = BinaryNode.sibling( n );
       if (s.color == BinaryNode.Color.BLACK)
       {
          if (n == n.parent.left &&
              s.right.color == BinaryNode.Color.BLACK &&
              s.left.color == BinaryNode.Color.RED)
          {
             s.color = BinaryNode.Color.RED;
             s.left.color = BinaryNode.Color.BLACK;
             rotate_right( s );
          }
          else if (n == n.parent.right &&
                   s.left.color == BinaryNode.Color.BLACK &&
                   s.right.color == BinaryNode.Color.RED ) 
          {
             s.color = BinaryNode.Color.RED;
             s.right.color = BinaryNode.Color.BLACK;
             rotate_left( s );
          }
       }
       del_recolor_6( n );
    }
    
    void del_recolor_6 ( BinaryNode n )
    {
       BinaryNode s = BinaryNode.sibling( n );
       s.color = n.parent.color;
       n.parent.color = BinaryNode.Color.BLACK;
       if( n == n.parent.left )
       {
           s.right.color = BinaryNode.Color.BLACK;
           rotate_left( n.parent );
       }
       else
       {
           s.left.color = BinaryNode.Color.BLACK;
           rotate_right( n.parent );
       }
    }
    
    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if ( t == null )
        	System.out.println("Item Not Found Exception: "+ x.toString( ) );  // Not found
        if ( x.compareTo( t.element ) < 0 )
            t.left = remove( x, t.left );
        else if ( x.compareTo( t.element ) > 0 )
            t.right = remove( x, t.right );
        else if ( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = removeMin( t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        
        return t;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if t is empty.
     */
    protected BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t )
    {
        if( t == null )
        {
        	System.out.println("ItemNot Found Exception: ");
        	return null;
        }
        else if( t.left != null )
        {
            t.left = removeMin( t.left );
            return t;
        }
       
        return t.right;
    }    

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.left != null )
                t = t.left;

        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t )
    {
        while( t != null )
        {
            if( x.compareTo( t.element ) < 0 )
                t = t.left;
            else if( x.compareTo( t.element ) > 0 )
                t = t.right;
            else
                return t;    // Match
        }
        
        return null;         // Not found
    }

      /** The tree root. */
    protected BinaryNode<AnyType> root;

    /*
    // Test program
    public static void main( String [ ] args )
    {
        BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
        final int NUMS = 4000;
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
            t.insert( i );

        for( int i = 1; i < NUMS; i += 2 )
            t.remove( i );

        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i += 2 )
             if( t.find( i ) != i )
                 System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i += 2 )
            if( t.find( i ) != null )
                System.out.println( "Find error2!" );
    }
    */
	

    private void preOrder()
    {
    	preOrder(root, "");
    }
    
    private void inOrder()
    {
    	inOrder(root, "");
    }
    
    private void postOrder()
    {
    	postOrder(root, "");
    }
    
    private void preOrder(BinaryNode<AnyType> t, String tab)
    {
    	if(t==null)
    		return;
    	System.out.println(tab + t.element.toString() + tab);
    	preOrder(t.left,  "\t" + tab );
    	preOrder(t.right,  "\t" + tab);
    }
    
    private void inOrder(BinaryNode<AnyType> t, String tab)
    {
    	if(t==null)
    		return;
    	inOrder(t.left,  "\t" + tab);
    	System.out.println(tab +  t.element.toString());
    	inOrder(t.right,  "\t" + tab);
    }
    
    private void postOrder(BinaryNode<AnyType> t, String tab)
    {
    	if(t==null)
    		return;
    	postOrder(t.left,  "\t" + tab);
    	postOrder(t.right,  "\t" + tab);
    	System.out.println(  tab + t.element.toString() );
    }
    
	public void printOrders ( BinarySearchTree tree ) 
	{
		System.out.println("Preorder = ");
		tree.preOrder ( );
		System.out.println("Inorder = ");
		tree.inOrder ( );
		System.out.println("Postorder = ");
		tree.postOrder ( );
	  
	}
	
	public static void main( String [ ] args )
	{
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		for (int i = 0; i < 10; i++)
		{
			tree.insert(i);
		}
		
		tree.printOrders(tree);
		
		/*
		String A = "Aliens";
		String B = "Clerks";
		String C = "Die Hard";
		String D = "Enemy of the State";
		String E = "Gladiator";
		String F = "Happy Gilmore";
		String G = "Kill Bill Volume 1";
		String H = "Kill Bill Volume 2";
		String I = "Matrix";
		String J = "Meet the Parents";
		String K = "Pirates of the Caribbean";
		String L = "Silence of the Lambs";
		String M = "Spaceballs";
		String N = "Star Wars";
		String O = "Terminator";
		String P = "The Lord of the Rings";
		String Q = "The Usual Suspects";
		String R = "Top Gun";
		
		//------------------------------------------------------------------------
		// Extra Credit Testing
		BinarySearchTree<String> tree3 = new BinarySearchTree<String>( );
		tree3.insert ( C );
		tree3.insert ( O );
		tree3.insert ( G );
		tree3.insert ( K );
		tree3.insert ( P );
		tree3.insert ( N );
		tree3.insert ( E );
		tree3.insert ( I );
		tree3.insert ( B );
		tree3.insert ( Q );
		tree3.insert ( L );
		tree3.insert ( D );
		tree3.insert ( A );
		tree3.insert ( M );
		tree3.insert ( F );
		tree3.insert ( R );
		tree3.insert ( J );
		tree3.insert ( H );
		System.out.println("EC test 1");
		tree3.remove ( K );
		tree3.printOrders ( tree3 );
		System.out.println("----------------------------------------------------");
		System.out.println("EC test 2");
		tree3.remove ( D );
		tree3.printOrders ( tree3 );
		System.out.println("----------------------------------------------------");
		System.out.println("EC test 3");
		tree3.remove ( A );
		tree3.printOrders ( tree3 );
		System.out.println("----------------------------------------------------");
		System.out.println("EC test 4");
		tree3.remove ( G );
		tree3.printOrders ( tree3 );
		System.out.println("----------------------------------------------------");
		System.out.println("EC test 5");
		tree3.remove ( I );
		tree3.remove ( M );
		tree3.remove ( B );
		tree3.remove ( E );
		tree3.printOrders ( tree3 );
		System.out.println("----------------------------------------------------");
		*/
	}

}