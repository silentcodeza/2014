/*
				A Solution for Polish notation With Explanation of steps
 */ 
//---------------------------------------------------------------------------------

public class PolishConverterWE
{   public void Polish(String P, String Q) throws Exception
	{	boolean debug = true;
		Stack<String> stck = new NodeStack<String>();
		
		stck.push("(");
		Q = Q + ")";
		
		int indx = 0;
		while (!stck.isEmpty())
		{	if (debug)
			{	System.out.println("Q ------> "+Q);
				System.out.println("P ------> "+P);
				System.out.println("stck ---> "+stck);
				System.out.println("-------------------- ");
			}
		
			String chr = Q.substring(indx,indx+1);
			indx++;
			
			if (isOperand(chr)){
				if (debug)
				{	System.out.println(chr+" is an operand");
					System.out.println("So add "+chr+" to P");
				}
				P = P + chr;
			}else if (isLeftParenthesis(chr)){
				stck.push("(");
				if (debug)
				{	System.out.println(chr+" is a left parenthesis");
					System.out.println("So push ( onto stack");
				}
			}else if (isOperator(chr))
			{	if (debug)
				{	System.out.println(chr+" is an operator");
				}
				
				while (precedence(stck.top()) > precedence(chr))
				{	if (debug)
					{	System.out.println("character "+stck.top()+" on stack is an operator and its precedence is higher than "+chr);
						System.out.println("Pop "+stck.top()+" from stack");
					}
					P = P + stck.pop();
				}
				if (debug)
				{	System.out.println("push "+chr+" to stack");
				}					
				stck.push(chr);
				
			}else if (isRightParenthesis(chr))
			{ 
				if (debug)
				{	System.out.println("a right parenthesis encountered in algebraic expression ");
				}
				
				while (isOperator(stck.top()))
				{
					if (debug)
					{	System.out.println("  an operator, i.e. "+stck.top()+" on stack, so remove it from stack");
					}

					P = P + stck.pop();	
				}
				if (stck.top().equals("("))					
				{	if (debug)
					{	System.out.println("  a left parenthesis found on stack, so remove it");
					}
					
					stck.pop();
				}
			}
			else {
				// error
			}
		}
		if (debug)
		{	System.out.println("=====================================================================");
			System.out.println("Expression in infix notation : "+Q.substring(0,Q.length()-1));
			System.out.println("Expression has been converted to Polish notation : "+P);
			System.out.println("=====================================================================");
		}
	}
	
	public boolean isLeftParenthesis(String strng)
	{	return strng.equals("(");
	}
	
	public boolean isRightParenthesis(String op)
	{	return op.equals(")");
	}
	
	public boolean isOperator(String op)
	{	if (op.equals("^") || op.equals("*") || op.equals("/") || op.equals("+") || op.equals("-") )
			return true;
		else 
			return false;
	}
	
	public boolean isOperand(String chr)
	{	if (isOperator(chr) || isLeftParenthesis(chr) || isRightParenthesis(chr))
			return false;
		else
			return true;
	}
	
	public int precedence(String op)
	{	if ( op.equals("+") || (op.equals("-")))
			return 1;
		else if ( op.equals("*") || (op.equals("/")))
			return 2;
		else if (op.equals("^"))
			return 3;
		else 
			return 0;
	}
		
    public static void main (String[] args) throws Exception
    {   
        PolishConverterWE objct = new PolishConverterWE();
		String expressionInfix, expressionPolishNotation;
		//		System.out.print("Enter the algebraic expression in infix form >> ");
		expressionInfix = "A+(B*C-(D/E^F)*G)*H";
		expressionPolishNotation = "";
		objct.Polish(expressionPolishNotation,expressionInfix);
	}
}
