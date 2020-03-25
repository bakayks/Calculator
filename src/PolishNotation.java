import java.util.EmptyStackException;
import java.util.Stack;

public class PolishNotation {

    public String infixToPostfix(String inFix){
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < inFix.length(); i++){
            char c = inFix.charAt(i);
            switch (getPrioritet(c)){
                case 0:
                    for (int x = i; x < inFix.length(); x++) {
                        if(getPrioritet(inFix.charAt(x))==0) {
                            postfix += inFix.charAt(x);
                            i = x;
                        }else
                            break;
                    }
                    postfix += " ";
                    break;
                case  1:
                    stack.push(c);
                    break;
                case -1:
                    while (stack.size()>0 && stack.peek() != '(')
                        postfix += stack.pop();
                    stack.pop();
                    break;
                case  2:
                case  3:
                    while (stack.size()>0 && getPrioritet(c) <= getPrioritet(stack.peek()))
                        postfix += stack.pop();
                    stack.push(c);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            if(stack.peek() == '(')
                break;
            postfix += stack.pop();
        }
        return postfix;
    }

    private int getPrioritet(char ch){
        if(ch == ')')
            return -1;
        else if(ch == '(')
            return 1;
        else if(ch == '+' | ch == '-')
            return 2;
        else if(ch == '/' | ch == '*')
            return 3;
        return 0;
    }

    public double calculate(String postFix) {
        Stack<Double> doubleStack = new Stack<>();
        for(int i = 0; i < postFix.length(); i++){
            char postFixChar = postFix.charAt(i);
            String doub = "";
            if(Character.isDigit(postFixChar)) {
                doub += postFixChar;
                for (int x = i + 1; x < postFix.length(); x++) {
                    if (Character.isDigit(postFix.charAt(x))) {
                        doub += postFix.charAt(x);
                        i = x;
                    } else {
                        break;
                    }
                }
                doubleStack.push(Double.valueOf(doub));
            }else if(postFixChar != ' '){
                try{
                    double a = doubleStack.pop();
                    double b = doubleStack.pop();
                    if(postFixChar == '+')
                        doubleStack.push(a+b);
                    else if(postFixChar == '-')
                        doubleStack.push(b-a);
                    else if(postFixChar == '*')
                        doubleStack.push(a*b);
                    else if(postFixChar == '/')
                        doubleStack.push(b/a);
                }catch (EmptyStackException emptyStackException){
                    System.out.println("Стек пуст!");
                }
            }

        }
        if(!doubleStack.isEmpty())
            return doubleStack.pop();
        else
            return 0;
    }
}
