package calculator;

import java.util.List;
import java.util.Stack;

public class Postfix {

	
	public static String result(List<String> postfix)
	{
		Stack<Double> operands = new Stack<Double>() ; 
		for(int i = 0 ; i<postfix.size() ; i++)
		{
			String symbol = postfix.get(i) ; 
			if(symbol.charAt(0)=='+' || symbol.charAt(0)=='-'||symbol.charAt(0)=='*'||symbol.charAt(0)=='/')
			{
				
				if(symbol.charAt(0)=='-' && operands.size()==1) //-x
				{
					Double t = operands.pop() ; 
					t = t*-1 ; 
					operands.push(t) ; 
					continue ; 
					
				}
				
				Double x = operands.pop() ; 
				Double y =  operands.pop() ; 
				if(symbol.charAt(0)=='+')
				{
					double z = x+y ; 
					operands.push(z)  ;
				}
				else if(symbol.charAt(0)=='-')
				{
					double z = y-x ;  
					operands.push(z)  ;
				}
				else if(symbol.charAt(0)=='*')
				{
					double z = y*x ; 
					operands.push(z)  ;
				}
				else if(symbol.charAt(0)=='/')
				{
					double z = y/x ; 
					operands.push(z)  ;
				}
				
			}
			else
			{
				
				double number = Double.parseDouble(symbol);
                operands.push(number);
			}
			
			
		}
//		String r = operands.pop().toString() ; 
		return(operands.pop().toString()) ; 
	}
}
