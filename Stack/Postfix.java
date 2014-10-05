import java.util.StringTokenizer;

public class Postfix
{
	private static boolean isOperator(char c) 
	{
		return c == '+' || c == '-' || 
			   c == '*' || c == '/' || c == '^' || 
			   c == '(' || c == ')';
	}

	private static boolean isSpace(char c) 
	{
		return (c == ' ');
	}

	private static boolean lowerPrecedence(char operator1, char operator2) 
	{
		// Tell whether op1 has lower precedence than op2, where op1 is an
		// operator on the left and op2 is an operator on the right.
		// op1 and op2 are assumed to be operator characters (+,-,*,/,^).
		  
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
		VectorStack operatorStack = new VectorStack();
		char c;
		StringTokenizer parser = new StringTokenizer(infix, "+-*/^() ", true);
		StringBuffer postfix = new StringBuffer(infix.length());
		
		while ( parser.hasMoreTokens() )
		{
			String token = parser.nextToken();
			c = token.charAt(0);
			
			if ( (token.length() == 1) && isOperator(c) )
			{    				
				while ( !operatorStack.isEmpty() && !lowerPrecedence(((String)operatorStack.peek()).charAt(0), c) )
				{
					// Operator on the stack does not have lower precedence, 
					// so it goes before this one
					postfix.append(" ").append((String)operatorStack.pop());
				}
				
				if ( c == ')' ) 
				{
					// Output the remaining operators in the parenthesized part
					String operator = (String)operatorStack.pop();
					
					while ( operator.charAt(0) != '(' ) 
					{
						postfix.append(" ").append(operator);
						operator = (String)operatorStack.pop();  
					}
				}
				else
				{
					// Push this operator onto the stack
					operatorStack.push(token);
				}
			}
			else if ( (token.length() == 1) && isSpace(c) ) 
			{
				// Else if token was a space, 
				// ignore it
				;
			}
			else 
			{
				// Else it is an operand,
				// so append operand to postfix expression
				postfix.append(" ").append(token);  
			}
		}

		while ( !operatorStack.isEmpty() )
		{
			// Output the remaining operators on the stack.
			postfix.append(" ").append((String)operatorStack.pop());
		}
     
        // Return the result (a postfix expression)
        return postfix.toString();
	}
	
	public static int evaluatePostfix()
	{
		return 0;
	}
}