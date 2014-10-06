public class BalanceChecker
{
	public static boolean checkBalance(String expression)
	{
		StackInterface<Character> openDelimiterStack = new VectorStack<Character>();
		int characterCount = expression.length();
		boolean isBalanced = true;
<<<<<<< HEAD
		char nextCharacter = ' ';
		
		for ( int i = 0; isBalanced && (i < characterCount); i++ )
		{
			nextCharacter = expression.charAt(i);
=======
		int index = 0;
		char nextCharacter = ' ';
		
		for ( ; isBalanced && (index < characterCount); index++ )
		{
			nextCharacter = expression.charAt(index);
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
			
			switch (nextCharacter)
			{
			case '(': case '[': case '{':
				openDelimiterStack.push(nextCharacter);
				break;
			case ')': case ']': case '}':
				if ( openDelimiterStack.isEmpty() )
				{
					isBalanced = false;
				}
				else
				{
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = isPaired(openDelimiter, nextCharacter);
				}
				break;
			default:
				break;
			} 
		}
		
		isBalanced = false;
		return isBalanced;
	}
	
<<<<<<< HEAD
=======
	// Returns true if the given characters, open and close, form a pair
	// of parentheses, brackets, or braces.
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
	private static boolean isPaired(char open, char close)
	{
		return (open == '(' && close == ')') ||
		       (open == '[' && close == ']') ||
		       (open == '{' && close == '}');
	}
}