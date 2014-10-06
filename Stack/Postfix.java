public class Postfix
{
	private static boolean lowerPrecedence(char operator1, char operator2) 
	{ 
		switch (operator1)
		{
		case '+': case '-':
			return !(operator2 == '+' || operator2 == '-');
			
		case '*': case '/':
			return operator2 == '^' || operator2 == '(';
			
		case '^':
			return operator2 == '(';
			
		case '(': 
			return true;
			
		default:
			return false;
		}
	}
	
	public static String convertToPostfix(String infix)
	{
		//System.out.println("Postfix::convertToPostfix - START");
		StackInterface<Character> operatorStack = new VectorStack<Character>();
		int characterCount = infix.length();
		StringBuffer postfix = new StringBuffer(characterCount);
		char nextCharacter = ' ';
		System.out.println("Character count: " + characterCount);
		
		for ( int i = 0; i < characterCount; i++ )
		{			
			//System.out.println("Postfix::convertToPostfix - for each char - START");
			System.out.println("infix[" + i + "]: " + infix.charAt(i));

			nextCharacter = infix.charAt(i);
			
			switch(nextCharacter)
			{
			case '1' : case '2' : case '3' : case '4' : case '5' : 		
			case '6' : case '7' : case '8' : case '9' : case '0' :
				postfix.append(nextCharacter);
				break;
				
			case '^' :
				operatorStack.push(nextCharacter);
				break;
				
			case '+' : case '-' : case '*' : case '/' :
				/*while ( !operatorStack.isEmpty() && lowerPrecedence(nextCharacter, operatorStack.peek()) )
				{
					postfix.append(operatorStack.pop());
				}*/
				operatorStack.push(nextCharacter);
				break;
				
			case '(' : case '[' : case '{' :
				operatorStack.push(nextCharacter);
				break;

			case ')' : case ']' : case '}' :
				char topOperator = operatorStack.pop();
				while ( topOperator != '(' )
				{
					postfix.append(topOperator);
					topOperator = (Character)operatorStack.pop();
				}
				break;
				
				default:
					break;
			}
			
			//System.out.println("Postfix::convertToPostfix - for each char - END");
		}
		
		//System.out.println("Postfix::convertToPostfix - !operatorStack.isEmpty() - START");

		while ( !operatorStack.isEmpty() )
		{
			char topOperator = operatorStack.pop();
			postfix.append(topOperator);
		}
		
		//System.out.println("Postfix::convertToPostfix - !operatorStack.isEmpty() - END");
		
		System.out.println("Final postfix expression: " + postfix.toString());
		//System.out.println("Postfix::convertToPostfix - END");
        return postfix.toString();
	}
	
	public static double evaluatePostfix(String postfix)
	{
		StackInterface<Double> valueStack = new VectorStack<Double>();
		int characterCount = postfix.length();
		char nextCharacter = ' ';
		double number = 0;
		double operandTwo = 0;
		double operandOne = 0;
		double result = 0;
		
		for ( int i = 0; i < characterCount; i++ )
		{
			nextCharacter = postfix.charAt(i);
			
			switch(nextCharacter)
			{
			case '1' : case '2' : case '3' : case '4' : case '5' :
			case '6' : case '7' : case '8' : case '9' : case '0' :
				number = Character.getNumericValue(nextCharacter);
				valueStack.push(number);
				break;
				
			case '+' : case '-' : case '*' : case '/' : case '^' :
				operandTwo = valueStack.pop();
				operandOne = valueStack.pop();
				switch(nextCharacter)
				{
				case '+' :
				    result = operandOne + operandTwo;
					break;
				case '-' :
					result = operandOne - operandTwo;
					break;
					
				case '*' :
					result = operandOne * operandTwo;
					break;
					
				case '/' :
					result = operandOne / operandTwo;
					break;
					
				case '^':
					result = Math.pow(operandOne, operandTwo);
					break;
					
					default: break;
				}
				valueStack.push(result);
				break;
				
			default: break;
			}
		}
		
		return valueStack.peek();
	}
}