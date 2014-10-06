<<<<<<< HEAD
=======
import java.util.Scanner;
import java.util.StringTokenizer;

>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
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
<<<<<<< HEAD
		System.out.println("Postfix::convertToPostfix - START");
		StackInterface<Character> operatorStack = new VectorStack<Character>();
		int characterCount = infix.length();
		StringBuffer postfix = new StringBuffer(characterCount);
		char nextCharacter = ' ';
		System.out.println("Character count: " + characterCount);
		
		for ( int i = 0; i < characterCount; i++ )
		{			
			System.out.println("Postfix::convertToPostfix - for each char - START");
			System.out.println("Character at infix[" + i + "] is " + infix.charAt(i));

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
=======
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
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
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
<<<<<<< HEAD
			
			System.out.println("Postfix::convertToPostfix - for each char - END");
=======
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
		}
		
		System.out.println("Postfix::convertToPostfix - !operatorStack.isEmpty() - START");

		while ( !operatorStack.isEmpty() )
		{
<<<<<<< HEAD
			char topOperator = operatorStack.pop();
=======
			char topOperator = (Character)operatorStack.pop();
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
			postfix.append(topOperator);
		}
		
		System.out.println("Postfix::convertToPostfix - !operatorStack.isEmpty() - END");
		
		System.out.println("Final postfix expression: " + postfix.toString());
		System.out.println("Postfix::convertToPostfix - END");
        return postfix.toString();
	}
	
	public static double evaluatePostfix(String postfix)
	{
<<<<<<< HEAD
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
=======
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
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
	}
}