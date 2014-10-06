public class BalanceChecker
{
	public static boolean checkBalance(String expression)
	{
		StackInterface<Character> openDelimiterStack = new VectorStack<Character>();
		int characterCount = expression.length();
		boolean isBalanced = true;
		char nextCharacter = ' ';
		
		for ( int i = 0; isBalanced && (i < characterCount); i++ )
		{
			nextCharacter = expression.charAt(i);
			
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
	
	private static boolean isPaired(char open, char close)
	{
		return (open == '(' && close == ')') ||
		       (open == '[' && close == ']') ||
		       (open == '{' && close == '}');
	}
}