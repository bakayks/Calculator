public class Model {

    private Viewer viewer;
    private String temp;
    private String answer;
    private PolishNotation polishNotation;

    public Model(Viewer viewer){
        this.viewer = viewer;
        polishNotation = new PolishNotation();
        temp = "";
        answer = "";
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
                calculate(true);
                break;
            case "Clear":
                clearTemp();
                break;
            case "Equal":
                calculate(false);
                break;
        }
    }

    private void setTemp(String tmp){
        int tempLength = temp.length();
        boolean tmpIsOperator = false;
        if(tmp.equals("/") | tmp.equals("*") | tmp.equals("+") | tmp.equals("-") | tmp.equals("%")){
            tmpIsOperator = true;
        }
        if(tempLength == 0 & !tmpIsOperator) {
            temp = temp + tmp;
            viewer.update(temp);
            return;
        }
        char lastSymbol = temp.charAt(tempLength - 1);
        if((lastSymbol == '/' | lastSymbol == '*' | lastSymbol == '+' | lastSymbol == '-' | lastSymbol == '%') & tmpIsOperator){
            temp = temp.substring(0, tempLength-1) + tmp;
            viewer.update(temp);
        }else {
            temp = temp + tmp;
            viewer.update(temp);
        }
    }

    private void deleteLastTempSymbol(){
        if(temp.length()>0) {
            temp = temp.substring(0, temp.length() - 1);
            System.out.println("Удаление последнего символа");
        }else
            System.out.println("Нету символов");
        viewer.update(temp);
    }

    private void clearTemp(){
        temp = "";
        viewer.update(temp);
        viewer.updateAnswer(temp);
    }

    private void calculate(boolean isAnswer){
        String postFix = polishNotation.infixToPostfix(viewer.getValue());
        double otvet = polishNotation.calculate(postFix);
        int doubleToInt = (int) otvet;
        if(otvet != 0){
            if(otvet>doubleToInt) {
                if(isAnswer) {
                    viewer.updateAnswer(String.valueOf(otvet));
                    answer = String.valueOf(otvet);
                }else {
                    viewer.update(String.valueOf(otvet));
                    temp = String.valueOf(otvet);
                }
            }else {
                if(isAnswer) {
                    viewer.updateAnswer(String.valueOf(doubleToInt));
                    answer = String.valueOf(doubleToInt);
                }else {
                    viewer.update(String.valueOf(doubleToInt));
                    temp = String.valueOf(doubleToInt);
                }
            }
        }
    }
}
