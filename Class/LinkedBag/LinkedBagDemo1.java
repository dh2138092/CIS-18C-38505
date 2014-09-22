public class LinkedBagDemo1
{
	public static void main(String[] args) 
	{
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new LinkedBag<String>();
		testIsEmpty(aBag, true);
		displayBag(aBag);
		
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
		testIsFull(aBag, false);
	}
	
    // Tests the method add.
    private static void testAdd (BagInterface < String > aBag, String [] content)
    {
        System.out.print ("Adding to the bag: ");
        for (int index = 0 ; index < content.length ; index++)
        {
            aBag.add (content [index]);
            System.out.print (content [index] + " ");
        } // end for
        System.out.println ();
        displayBag (aBag);
    } // end testAdd


    // Tests the method isFull.
    // correctResult indicates what isFull should return.
    private static void testIsFull (BagInterface < String > aBag, boolean correctResult)
    {
        System.out.print ("\nTesting the method isFull with ");
        if (correctResult)
            System.out.println ("a full bag:");
        else
            System.out.println ("a bag that is not full:");
        System.out.print ("isFull finds the bag ");
        if (correctResult && aBag.isFull ())
            System.out.println ("full: OK.");
        else if (correctResult)
            System.out.println ("not full, but it is full: ERROR.");
        else if (!correctResult && aBag.isFull ())
            System.out.println ("full, but it is not full: ERROR.");
        else
            System.out.println ("not full: OK.");
    } // end testIsFull
    
    // Tests the method isEmpty.
    // correctResult indicates what isFull should return.
    private static void testIsEmpty (BagInterface < String > aBag, boolean correctResult)
    {
        System.out.print ("\nTesting the method isEmpty with ");
        if (correctResult)
            System.out.println ("a empty bag:");
        else
            System.out.println ("a bag that is not empty:");
        System.out.print ("isEmpty finds the bag ");
        if (correctResult && aBag.isEmpty ())
            System.out.println ("empty: OK.");
        else if (correctResult)
            System.out.println ("not empty, but it is empty: ERROR.");
        else if (!correctResult && aBag.isEmpty ())
            System.out.println ("empty, but it is not empty: ERROR.");
        else
            System.out.println ("not empty: OK.");
    } // end testIsEmpty


    // Tests the method toArray while displaying the bag.
    private static void displayBag (BagInterface < String > aBag)
    {
        System.out.println ("The bag contains the following string(s):");
        Object [] bagArray = aBag.toArray ();
        for (int index = 0 ; index < bagArray.length ; index++)
        {
            System.out.print (bagArray [index] + " ");
        } // end for
        System.out.println ();
    } // end displayBag
}