public class Main{
    public static void main(String[] args) {
//        Viewer viewer = new Viewer();
        PolishNotation polishNotation = new PolishNotation();
        String otvet = polishNotation.infixToPostfix("5*(-5*3)-3");
        polishNotation.calculate(otvet);
    }

}


