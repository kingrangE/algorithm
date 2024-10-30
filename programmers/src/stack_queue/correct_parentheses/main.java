package stack_queue.correct_parentheses;

import java.util.*;

public class main {
    public static void main(String[] args) {
        String s ="(())()";
        String s2 = "()()";
        String s3= "(()(";
        System.out.println(solution(s3));
    }
    static boolean solution(String s) {
        if (s.charAt(0) == ')') return false;
        String[] arrayStr = s.split("");
        Stack<String> stack = new Stack<>();

        try{
            for(String str : arrayStr) {
                if(str.equals("(")) {
                    stack.push(str);
                }
                else if(str.equals(")")) {
                    stack.pop();
                }
            }
        }catch(Exception e){
            return false;
        }


        return stack.isEmpty();
    }
}
