public class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public int getCurrentSize() 
	{
		return numberOfEntries;
	}

	public boolean isFull() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean add(T newEntry) 
	{
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		
		firstNode = newNode;
		numberOfEntries++;
		return true;
	}

	public T remove() 
	{
		T result = null;
		
		if ( firstNode != null )
		{
			result = firstNode.data;
			firstNode = firstNode.next; // remove first node from chain
			numberOfEntries--;
		}

		return result;
	}

	public boolean remove(T anEntry)
	{
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		
		if ( nodeN != null )
		{
			nodeN.data = firstNode.data; // replace located entry with entry in first node
			remove(); // remove first node
			result = true;
		}
		
		return result;
	}

	public void clear() 
	{
		while ( !isEmpty() )
		{
			remove();
		}
		
	}
	
	private Node getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while ( !found && (currentNode != null) )
		{
			if ( anEntry.equals(currentNode.data) )
			{
				found = true;
			}
			else
			{
				currentNode = currentNode.next;
			}
		}
		return currentNode;
	}

	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;
		int counter = 0;
		Node currentNode = firstNode;
		
		while ( (counter < numberOfEntries) && (currentNode != null) )
		{
			if ( anEntry.equals(currentNode.data) )
			{
				frequency++;
			}
			
			counter++;
			currentNode = currentNode.next;
		}
		
		return frequency;
	}

	public boolean contains(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while ( !found && (currentNode != null) )
		{
			if (anEntry.equals(currentNode.data))
			{
				found = true;
			}
			else
			{
				currentNode = currentNode.next;
			}
		}
		
		return found;
	}

	public T[] toArray() 
	{
		T[] result = (T[])new Object[numberOfEntries];
		
		int index = 0;
		
		Node currentNode = firstNode;
		while ( (index < numberOfEntries) && (currentNode != null) )
		{
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		
		return result;
	}
	
	class Node
	{
		private T data;
		private Node next;

		private Node(T dataPortion)
		{
			this(dataPortion, null);
		}

		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		}
	}
}