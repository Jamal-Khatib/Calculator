package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Infix {

	
	public static List<String> infixToPostix(String s)
	{
		Stack<Character> operators = new Stack<Character>() ; 
		List<String> postfix = new ArrayList<String>() ; 
		for(int i = 0 ; i<s.length() ; i++)
		{
			Character symbol = s.charAt(i) ; 
			if(symbol==' ')  continue ; //skip the blank space 
			
			//Parentheses
			else if (symbol=='(') operators.push(symbol) ; 
			else if(symbol ==')')
			{
				while(!operators.empty())
				{
					if(operators.peek()=='(') 
					{
						operators.pop() ; 
						break ; 
					}
					else
						
					{
						String temp = Character.toString(operators.pop()) ; 
						postfix.add(temp) ; 
					}
				}
			}
			//Operators
			else if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/')
				{
					if(operators.empty()) operators.push(symbol) ; 
					else
					{
						while(!operators.empty() && precedence(symbol)<=precedence(operators.peek()))
						{
							postfix.add(Character.toString(operators.pop())) ; 
						}
						operators.push(symbol) ; 
					}
				}
			//Number
			else
			{
				String number= Character.toString(symbol) ; 
				
				int c = i+1 ; 
				while(true)
				{
					if(c<s.length())
					{
						Character next = s.charAt(c) ; 
						if(Character.isDigit(next)||next=='.')
						{
							number+=Character.toString(next) ; 
							i++; 
						}
						else break ; 
						c++ ; 
					}
					else break ; 
						
					
				} 
				postfix.add(number) ; 
			}
			
			
				
			}
				
			while(!operators.empty()) postfix.add(Character.toString(operators.pop())) ; 
			return(postfix) ; 
		} 
	
	
	private static int precedence(char c){
        if(c=='+'|| c=='-') return 1;
        else if(c=='*' || c=='/') return 2;
        else return -1;
    }
}
