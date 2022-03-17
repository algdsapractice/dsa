package stack;


import java.util.Scanner;
import java.util.Stack;

public class MathExpression
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
//		String a="";
//		while(!sc.hasNext(";"))
//		{String s=sc.nextLine();
//		a=a+s;
//		}
        String a=sc.next();
        double out=calculation(a);
        System.out.format("%.3f", out);
    }
    public static double calculation(String a)
    {
        Stack<Double> values=new Stack<Double>();
        Stack<Character> operations=new Stack<Character>();
        for(int i=0;i<a.length()-1;i++)
        {
            if(a.charAt(i)>='0'&&a.charAt(i)<='9')
            {
                String add="";
                while(i<a.length()-1&&a.charAt(i)>='0'&&a.charAt(i)<='9')

                    add=add+a.charAt(i++);
                values.push(Double.parseDouble(add));
                i--;
            }
            else if(a.charAt(i)=='(')
                operations.push(a.charAt(i));
            else if(a.charAt(i)==')')
            {
                while(operations.peek()!='(')
                    values.push(calculate(operations.pop(),values.pop(),values.pop()));
                operations.pop();
            }
            else if(a.charAt(i)=='+'||a.charAt(i)=='-'||a.charAt(i)=='*'||a.charAt(i)=='/'||a.charAt(i)=='^')
            {
                while(!operations.empty()&&check(a.charAt(i),operations.peek()))
                    values.push(calculate(operations.pop(),values.pop(),values.pop()));
                operations.push(a.charAt(i));
            }
        }
        while (!operations.empty())
            values.push(calculate(operations.pop(), values.pop(), values.pop()));


        return values.pop();
    }
    public static double calculate(char op,double b,double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);
        }
        return 0;
    }
    public static boolean check(char op1,char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        if ((op1 == '^') && (op2 == '+' || op2 == '-'))
            return false;
        if ((op1 == '^') && (op2 == '*' || op2 == '/'))
            return false;
        if(op1=='^'&&op2=='^')
            return true;
        else
            return true;
    }
}