package com.adv.stack.assignment;

import java.util.Stack;

/*Problem Description
        An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, /. Each string may be an integer or an operator.

        Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.



        Problem Constraints
        1 <= N <= 105



        Input Format
        The only argument given is string array A.



        Output Format
        Return the value of arithmetic expression formed using reverse Polish Notation.



        Example Input
        Input 1:
        A =   ["2", "1", "+", "3", "*"]
        Input 2:
        A = ["4", "13", "5", "/", "+"]


        Example Output
        Output 1:
        9
        Output 2:
        6


        Example Explanation
        Explaination 1:
        starting from backside:
        * : () * ()
        3 : () * (3)
        + : (() + ()) * (3)
        1 : (() + (1)) * (3)
        2 : ((2) + (1)) * (3)
        ((2) + (1)) * (3) = 9
        Explaination 2:
        starting from backside:
        + : () + ()
        / : () + (() / ())
        5 : () + (() / (5))
        13 : () + ((13) / (5))
        4 : (4) + ((13) / (5))
        (4) + ((13) / (5)) = 6*/
public class EvaluateExpression {
    public static void main(String[] args) {
        String[] A = {"-1"};
        evalRPN(A);

    }
    public static int evalRPN(String[] A) {
        Stack<String> stack = new Stack<>();
        for(String str : A) {
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("*")){
                stack.push(str);
            }else {
                if(stack.isEmpty()) return -1;
                String op2 = stack.pop();
                String op1 = stack.pop();
                if(str.equals("+"))
                    stack.push(String.valueOf(Integer.valueOf(op1) +  Integer.valueOf(op2)));
                else if(str.equals("-"))
                    stack.push(String.valueOf(Integer.valueOf(op1) -  Integer.valueOf(op2)));
                else if(str.equals("*"))
                    stack.push(String.valueOf(Integer.valueOf(op1) *  Integer.valueOf(op2)));
                else stack.push(String.valueOf(Integer.valueOf(op1) /  Integer.valueOf(op2)));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
