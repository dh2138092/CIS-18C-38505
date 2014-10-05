import java.util.Scanner;
import java.util.StringTokenizer;

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
		StackInterface<Character> operatorStack = new VectorStack<Character>();
		char nextCharacter;
		StringTokenizer parser = new StringTokenizer(infix);
		StringBuffer postfix = new StringBuffer(infix.length());
		
		while ( parser.hasMoreTokens() )
		{
			String token = parser.nextToken();
			nextCharacter = token.charAt(0);
			
			switch(nextCharacter)
			{
			case 1 : case 2 : case 3 : case 4 : case 5 : 		
			case 6 : case 7 : case 8 : case 9 : case 0 :
				postfix.append(nextCharacter);
				break;
				
			case '^' :
				operatorStack.push(nextCharacter);
				break;
				
			case '+' : case '-' : case '*' : case '/' :
				while ( !operatorStack.isEmpty() && lowerPrecedence(nextCharacter, operatorStack.peek()) )
				{
					postfix.append(operatorStack.pop());
				}
				operatorStack.push(nextCharacter);
				break;
				
			case '(' :
				operatorStack.push(nextCharacter);
				break;

			case ')' :
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
		}

		while ( !operatorStack.isEmpty() )
		{
			char topOperator = (Character)operatorStack.pop();
			postfix.append(topOperator);
		}
     
        // Return the result (a postfix expression)
        return postfix.toString();
	}
	
	public static double evaluatePostfix(String postfix)
	{
		StackInterface<Double> vals = new VectorStack<Double>();
		StackInterface<String> ops = new VectorStack<String>();
		String s = "";
		Scanner input = new Scanner(postfix);
		
		while ( input.hasNext() )
		{

			s = input.next();
			
			if      (s.equals("("))               ;
            else if (s.equals("+"))    ops.push(s);
            else if (s.equals("-"))    ops.push(s);
            else if (s.equals("*"))    ops.push(s);
            else if (s.equals("/"))    ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
		}
		
		input.close();
		double solution = vals.pop();
		return solution;
	}
}