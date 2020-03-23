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
                break;
            case "Minus":
                setTemp("-");
                break;
            case "Divide":
                setTemp("/");
                break;
            case "Mult":
                setTemp("*");
                break;
            case "Percent":
                setTemp("%");
                break;
            case "Comma":
                setTemp(".");
                break;
            case "Zero":
                setTemp("0");
                break;
            case "One":
                setTemp("1");
                break;
            case "Two":
                setTemp("2");
                break;
            case "Three":
                setTemp("3");
                break;
            case "Four":
                setTemp("4");
                break;
            case "Five":
                setTemp("5");
                break;
            case "Six":
                setTemp("6");
                break;
            case "Seven":
                setTemp("7");
                break;
            case "Eight":
                setTemp("8");
                break;
            case "Nine":
                setTemp("9");
                break;
            case "Delete":
                deleteLastTempSymbol();
                break;
            case "Clear":
                clearTemp();
                break;
            case "Equal":
                calculate();
                break;
        }
    }

    private void setTemp(String tmp){
        temp = temp + tmp;
        viewer.update(temp);
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
    }

    private void calculate(){
        String postFix = polishNotation.infixToPostfix(viewer.getValue());
        double otvet = polishNotation.calculate(postFix);
        int doubleToInt = (int) otvet;
        if(otvet>doubleToInt) {
            viewer.update(String.valueOf(otvet));
            temp = String.valueOf(otvet);
        }else {
            viewer.update(String.valueOf(doubleToInt));
            temp = String.valueOf(doubleToInt);
        }
    }
}
