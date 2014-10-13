/*
	Author: Dylan House
	Class: CIS-18C-38505
	School: Norco College, Norco, CA
*/

import java.util.Scanner;

public class EvaluateExpression 
{
	public static void main(String[] args) 
	{
		Scanner stdin = new Scanner(System.in);
		String expression = "";
		double solution = 0;
		
		System.out.println("Please type an arithmetic epxression");
		System.out.println("unsigned, single digit whole numbers and the operators + - * /.");
		
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
		BalanceChecker balanceChecker = new BalanceChecker();
		Postfix postfix = new Postfix();
		String expression = "";
		double solution = 0.0;
		
		System.out.println(infix);		
		boolean balanced = balanceChecker.checkBalance(infix);
		
		if ( balanced )
		{
			expression = postfix.convertToPostfix(infix);
			solution = postfix.evaluatePostfix(expression);
			return solution;
		}
		else
		{
			System.out.println("Unbalanced expression {[()]}. Try again...");
			return -1;
		}
	}
}
