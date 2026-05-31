/*
			             A Solution for Polish notation
 */ 
//----------------------------------------------------------------------

public class PolishConverter
{   public void Polish(String P, String Q) throws Exception
	{	boolean debug = false;
		Stack<String> stck = new NodeStack<String>();
		
		stck.push("(");
		Q = Q + ")";
		
		int indx = 0;
		while (!stck.isEmpty())
		{
			String chr = Q.substring(indx,indx+1);
			indx++;
			
			if (isOperand(chr))
			{
				P = P + chr;
			}else if (isLeftParenthesis(chr))
			{
				stck.push("(");
			}else if (isOperator(chr))
			{
				while (precedence(stck.top()) > precedence(chr))
				{
					P = P + stck.pop();
				}
				stck.push(chr);
				
			}else if (isRightParenthesis(chr))
			{ 
				while (isOperator(stck.top()))
				{
					P = P + stck.pop();	
				}
				if (stck.top().equals("("))					
				{
					stck.pop();
				}
			}
			else {
				// error
			}
		}
		System.out.println("=====================================================================");
		System.out.println("Expression in infix notation : "+Q.substring(0,Q.length()-1));
		System.out.println("Expression has been converted to Polish notation : "+P);
		System.out.println("=====================================================================");
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
        PolishConverter objct = new PolishConverter();
		String expressionInfix, expressionPolishNotation;
//		System.out.print("Enter the algebraic expression in infix form >> ");
		expressionInfix = "A+(B*C-(D/E^F)*G)*H";
		expressionPolishNotation = "";
		objct.Polish(expressionPolishNotation,expressionInfix);
  }
}
