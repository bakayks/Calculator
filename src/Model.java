public class Model {

    private Viewer viewer;
    private String temp;
    private PolishNotation polishNotation;

    public Model(Viewer viewer){
        this.viewer = viewer;
        polishNotation = new PolishNotation();
        temp = "";
    }

    public void doAction(String command){
        switch(command){
            case "Plus":
                setTemp("+");
                calculate(true);
                break;
            case "Minus":
                setTemp("-");
                calculate(true);
                break;
            case "Divide":
                setTemp("/");
                calculate(true);
                break;
            case "Mult":
                setTemp("*");
                calculate(true);
                break;
            case "Percent":
                setTemp("%");
                calculate(true);
                break;
            case "Comma":
                setTemp(".");
                calculate(true);
                break;
            case "Zero":
                setTemp("0");
                calculate(true);
                break;
            case "One":
                setTemp("1");
                calculate(true);
                break;
            case "Two":
                setTemp("2");
                calculate(true);
                break;
            case "Three":
                setTemp("3");
                calculate(true);
                break;
            case "Four":
                setTemp("4");
                calculate(true);
                break;
            case "Five":
                setTemp("5");
                calculate(true);
                break;
            case "Six":
                setTemp("6");
                calculate(true);
                break;
            case "Seven":
                setTemp("7");
                calculate(true);
                break;
            case "Eight":
                setTemp("8");
                calculate(true);
                break;
            case "Nine":
                setTemp("9");
                calculate(true);
                break;
            case "Delete":
                deleteLastTempSymbol();
                break;
            case "Clear":
                clearTemp();
                break;
            case "Equal":
                calculate(false);
                break;
            case "BracketLeft":
                setTemp("(");
                calculate(true);
                break;
            case "BracketRight":
                setTemp(")");
                calculate(true);
                break;
        }
    }

    private void setTemp(String tmp){
        char value = tmp.charAt(0);
        if(temp.length() == 0) {
            if(value == '-' || value == '(' || Character.isDigit(value)){
                temp += value;
                viewer.update(temp);
            }
            return;
        }else{
            if(Character.isDigit(value)){
                temp += value;
                viewer.update(temp);
                return;
            }else if((value == '/' || value == '*' || value == '+' || value == '-' || value == '(' || value == ')')) {
                if (Character.isDigit(temp.charAt(temp.length() - 1))) {
                    if(value == '('){
                        return;
                    }
                    temp += value;
                    viewer.update(temp);
                }else if (value == '(') {
                    switch (temp.charAt(temp.length() - 1)){
                        case '+':
                        case '/':
                        case '*':
                        case '-':
                            temp += value;
                            viewer.update(temp);
                    }
                }else if(value == ')' && Character.isDigit(temp.charAt(temp.length() - 1))){
                    temp += value;
                    viewer.update(temp);
                }else if (temp.charAt(temp.length() - 1) == '(' & value == '-') {
                    temp += value;
                    viewer.update(temp);
                }else if (temp.charAt(temp.length() - 1) == ')' & (value == '-' || value == '+' || value == '/' || value == '*')) {
                    temp += value;
                    viewer.update(temp);
                }
                return;
            }
        }
        temp += value;
        viewer.update(temp);
    }

    private void deleteLastTempSymbol(){
        if(temp.length()>1) {
            temp = temp.substring(0, temp.length() - 1);
            calculate(true);
            System.out.println("Удаление последнего символа");
        }else {
            temp = "";
            viewer.updateAnswer(temp);
            System.out.println("Нету символов");
        }
        viewer.update(temp);
    }

    private void clearTemp(){
        temp = "";
        viewer.update(temp);
        viewer.updateAnswer(temp);
    }


    private void calculate(boolean isAnswer){
        String postFix = polishNotation.infixToPostfix(temp);
        if(polishNotation.calculate(postFix) != null){
            double otvet = (double) polishNotation.calculate(postFix);
            int doubleToInt = (int) otvet;
            boolean checkDouble = isDouble(doubleToInt, otvet);
            if(checkDouble) {
                if(isAnswer) {
                    viewer.updateAnswer("=" + otvet);
                }else {
                    viewer.update(String.valueOf(otvet));
                    temp = String.valueOf(otvet);
                }
            }else {
                if(isAnswer) {
                    viewer.updateAnswer("=" + doubleToInt);
                }else {
                    viewer.update(String.valueOf(doubleToInt));
                    temp = String.valueOf(doubleToInt);
                }
            }
        }
    }

    private boolean isDouble(int answer, double doubleAnswer){
        double check1 = Math.max(answer, doubleAnswer);
        double check2 = Math.min(answer, doubleAnswer);
        if(check1 > check2){
            return true;
        }
        return false;
    }
}
