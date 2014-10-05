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
		return false;
	}
	
	public static double evaluate(String expression)
	{
		Scanner input = new Scanner(expression);
		VectorStack<Double> numbers = new VectorStack<Double>();
		VectorStack<Character> operations = new VectorStack<Character>();
		String next;
		char first;
	}
}
