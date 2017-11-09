import java.util.*;

/**
 * A program for converting infix expressions to prefix and postfix notation,
 * as well as solving the expressions.
 */
public class ExpressionConverter
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Enter an infix expression, or type 'exit' to exit: ");
		String input = scanner.nextLine();

		while(!input.toLowerCase().trim().equals("exit"))
		{
			try
			{
				InfixExpression expression = new InfixExpression(input);
				String prefixNotation = expression.toPrefixNotation();
				String postfixNotation = expression.toPostfixNotation();
				String solution = expression.solve();
        	
				System.out.println();
				System.out.println("Prefix notation:\t" + prefixNotation);
				System.out.println("Postfix notation:\t" + postfixNotation);
				System.out.println("Solution:\t\t" + solution);
			} catch(Exception ex)
			{
				System.out.println("Error! Invalid expression.");
			}
			
			System.out.print("\n" + "Enter an infix expression, or type 'exit' to exit: ");
			input = scanner.nextLine();
		}
	}
}
