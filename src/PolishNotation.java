import java.util.EmptyStackException;
import java.util.Stack;

public class PolishNotation {

    public String infixToPostfix(String inFix){
        System.out.println("Infix: "+inFix);
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < inFix.length(); i++){
            char value = inFix.charAt(i);
            breakPoint:if(value == '-' &&  inFix.length() > 1){
                if(inFix.charAt(i-1) == ')'){
                    postfix += " ";
                }
                if(inFix.charAt(0) == '-'){
                    postfix += value;
                    i++;
                    value = inFix.charAt(i);
                    break breakPoint;
                }else if(!Character.isDigit(inFix.charAt(i-1))){
                    postfix += value;
                    value = inFix.charAt(i-1);
                }
            }
            switch (getPrioritet(value)){
                case 0:
                    for (int x = i; x < inFix.length(); x++) {
                        char symbol = inFix.charAt(x);
                        if(getPrioritet(symbol) == 0) {
                            postfix += symbol;
                            i = x;
                        }else
                            break;
                    }
                    postfix += " ";
                    break;
                case  1:
                    stack.push(value);
                    break;
                case -1:
                    while (stack.size()>0 && stack.peek() != '(') {
                        postfix += " ";
                        postfix += stack.pop();
                    }
                    stack.pop();
                    break;
                case  2:
                case  3:
                    while (stack.size()>0 && getPrioritet(value) <= getPrioritet(stack.peek())) {
                        postfix += " ";
                        postfix += stack.pop();
                    }
                    stack.push(value);
                    break;
            }
        }
        while (!stack.isEmpty()) {
            if(stack.peek() == '('){
                stack.pop();
            }else {
                postfix += " ";
                postfix += stack.pop();
            }
        }
        return postfix;
    }

    private int getPrioritet(char ch){
        switch (ch){
            case ')':
                return -1;
            case '(':
                return 1;
            case '+':
            case '-':
                return 2;
            case '/':
            case '*':
                return 3;
        }
        return 0;
    }

    public Object calculate(String postFix) {
        postFix = postFix.replaceAll(" {3}", " ");
        postFix = postFix.replaceAll(" {2}", " ");
        System.out.println("Postfix: " + postFix);

        Stack<Double> doubleStack = new Stack<>();
        String[] values = postFix.split(" ");
        for(int i = 0; i < values.length; i++){
            String postFixValue = values[i];
            if(isNumeric(postFixValue)) {
                doubleStack.push(Double.valueOf(postFixValue));
            }else {
                try{
                    double a = doubleStack.pop();
                    double b = doubleStack.pop();
                    if(postFixValue.equals("+"))
                        doubleStack.push(a+b);
                    else if(postFixValue.equals("-"))
                        doubleStack.push(b-a);
                    else if(postFixValue.equals("*"))
                        doubleStack.push(a*b);
                    else if(postFixValue.equals("/"))
                        doubleStack.push(b/a);
                }catch (EmptyStackException emptyStackException){
                    System.out.println("Выражение не дополнено!");
                }
            }
        }
        try {
            System.out.println("Answer: "+doubleStack.peek());
            return doubleStack.pop();
        }catch (EmptyStackException emSE){
            return null;
        }
    }

    public boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
