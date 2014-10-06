import java.util.Scanner;

public class EvaluateExpression 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		String expression = "";
		double solution = 0;
		
		System.out.println("Please type an arithmetic epxression");
		System.out.println("unsigned numbers and the operators + - * /.");
		System.out.println("THe expression must by full paranthesized");
		
		do
		{
			System.out.print("Your expression: ");
			expression = stdin.nextLine();
			
			try
			{
				solution = evaluate(expression);
				System.out.println("The value is " + solution);
			}
			catch (Exception e)
			{
				System.out.println("Error." + e.toString());
			}
		} 
		while (query(stdin, "Another expression?"));
	}
	
	public static boolean query(Scanner input, String prompt)
	{
		String answer;
		
		System.out.print(prompt + " [Y or N]: ");
		answer = input.nextLine( ).toUpperCase( );
		
		while (!answer.startsWith("Y") && !answer.startsWith("N"))
		{
			System.out.print("Invalid response. Please type Y or N: ");
			answer = input.nextLine( ).toUpperCase( );
		}
		
		return answer.startsWith("Y");
	}
	
	public static double evaluate(String infix)
	{
<<<<<<< HEAD
		System.out.println(infix);
		BalanceChecker balanceChecker = new BalanceChecker();
		Postfix postfix = new Postfix();
		String expression = "";
		double solution = 0;
		
		if ( true /*balanceChecker.checkBalance(infix)*/ )
		{
			expression = postfix.convertToPostfix(infix);
			solution = postfix.evaluatePostfix(expression);
			
		}
		else
		{
			System.out.println("Parentheses are unblanced! Try again...");
			return 0;
		}
=======
		BalanceChecker balanceChecker = new BalanceChecker();
		Postfix postfix = new Postfix();
		String postfixExpression = "";
		double solution = 0;
		
		if ( balanceChecker.checkBalance(expression) )
		{
			postfixExpression = postfix.convertToPostfix(expression);
			solution = postfix.evaluatePostfix(postfixExpression);
			
		}
>>>>>>> 7701477e5aae03de2b61d56b9138020143ae46ad
		
		return solution;
	}
}
