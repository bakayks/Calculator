
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Viewer {

    private JTextField textField;
    private JTextField answer;
    private Controller controller;

    public Viewer() {
        Model model = new Model(this);
        controller = new Controller(model);
        textField = new JTextField();
        textField.setBorder(null);
        textField.setFont(new java.awt.Font("Alergia", java.awt.Font.BOLD, 25));
        textField.setForeground(java.awt.Color.magenta);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBounds(50, 10, 230, 47);

        answer = new JTextField();
        answer.setFont(new java.awt.Font("Alergia", java.awt.Font.BOLD, 20));
        answer.setBorder(null);
        answer.setForeground(java.awt.Color.magenta);
        answer.setHorizontalAlignment(JTextField.RIGHT);
        answer.setBounds(50, 55, 230, 35);

        JPanel panel = getCenterJPanel();
        panel.setBounds(0, 0, 350, 400);

        JFrame frame = new JFrame("Calculator MVC");
        frame.setSize(400, 420);
        frame.setLocation(100, 50);
        frame.setLayout(null);
        frame.add(textField);
        frame.add(answer);
        frame.add(panel);
        frame.setVisible(true);
    }

    private JPanel getCenterJPanel() {
        JButton buttonDelete = new JButton("<--");
        buttonDelete.setBounds(290, 50, 50, 50);
        buttonDelete.addActionListener(controller);
        buttonDelete.setActionCommand("Delete");

        JButton buttonClear = new JButton("C");
        buttonClear.setBounds(290, 110, 50, 50);
        buttonClear.addActionListener(controller);
        buttonClear.setActionCommand("Clear");

        JButton buttonSeven = new JButton("7");
        buttonSeven.setBounds(50, 110, 50, 50);
        buttonSeven.setForeground(java.awt.Color.magenta);
        buttonSeven.addActionListener(controller);
        buttonSeven.setActionCommand("Seven");

        JButton buttonEight = new JButton("8");
        buttonEight.setBounds(110, 110, 50, 50);
        buttonEight.setForeground(java.awt.Color.magenta);
        buttonEight.addActionListener(controller);
        buttonEight.setActionCommand("Eight");

        JButton buttonNine = new JButton("9");
        buttonNine.setBounds(170, 110, 50, 50);
        buttonNine.setForeground(java.awt.Color.magenta);
        buttonNine.addActionListener(controller);
        buttonNine.setActionCommand("Nine");

        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(230, 110, 50, 50);
        buttonDivide.addActionListener(controller);
        buttonDivide.setActionCommand("Divide");

        JButton buttonFour = new JButton("4");
        buttonFour.setBounds(50, 170, 50, 50);
        buttonFour.setForeground(java.awt.Color.magenta);
        buttonFour.addActionListener(controller);
        buttonFour.setActionCommand("Four");

        JButton buttonFive = new JButton("5");
        buttonFive.setBounds(110, 170, 50, 50);
        buttonFive.setForeground(java.awt.Color.magenta);
        buttonFive.addActionListener(controller);
        buttonFive.setActionCommand("Five");

        JButton buttonSix = new JButton("6");
        buttonSix.setBounds(170, 170, 50, 50);
        buttonSix.setForeground(java.awt.Color.magenta);
        buttonSix.addActionListener(controller);
        buttonSix.setActionCommand("Six");

        JButton buttonMultiplication = new JButton("*");
        buttonMultiplication.setBounds(230, 170, 50, 50);
        buttonMultiplication.addActionListener(controller);
        buttonMultiplication.setActionCommand("Mult");

        JButton buttonPlus = new JButton("+");
        buttonPlus.setBounds(290, 170, 50, 50);
        buttonPlus.addActionListener(controller);
        buttonPlus.setActionCommand("Plus");

        JButton buttonOne = new JButton("1");
        buttonOne.setBounds(50, 230, 50, 50);
        buttonOne.setForeground(java.awt.Color.magenta);
        buttonOne.addActionListener(controller);
        buttonOne.setActionCommand("One");

        JButton buttonTwo = new JButton("2");
        buttonTwo.setBounds(110, 230, 50, 50);
        buttonTwo.setForeground(java.awt.Color.magenta);
        buttonTwo.addActionListener(controller);
        buttonTwo.setActionCommand("Two");

        JButton buttonThree = new JButton("3");
        buttonThree.setBounds(170, 230, 50, 50);
        buttonThree.setForeground(java.awt.Color.magenta);
        buttonThree.addActionListener(controller);
        buttonThree.setActionCommand("Three");

        JButton buttonZero = new JButton("0");
        buttonZero.setBounds(50, 290, 110, 50);
        buttonZero.setForeground(java.awt.Color.magenta);
        buttonZero.addActionListener(controller);
        buttonZero.setActionCommand("Zero");

        JButton buttonComma = new JButton(",");
        buttonComma.setBounds(170, 290, 50, 50);
        buttonComma.addActionListener(controller);
        buttonComma.setActionCommand("Comma");

        JButton buttonMinus = new JButton("-");
        buttonMinus.setBounds(230, 230, 50, 50);
        buttonMinus.addActionListener(controller);
        buttonMinus.setActionCommand("Minus");

        JButton buttonEqually = new JButton("=");
        buttonEqually.setBounds(290, 230, 50, 50);
        buttonEqually.addActionListener(controller);
        buttonEqually.setActionCommand("Equal");

        JButton buttonLeftBracket = new JButton("(");
        buttonLeftBracket.setBounds(230, 290, 50, 50);
        buttonLeftBracket.addActionListener(controller);
        buttonLeftBracket.setActionCommand("BracketLeft");

        JButton buttonRightBracket = new JButton(")");
        buttonRightBracket.setBounds(290, 290, 50, 50);
        buttonRightBracket.addActionListener(controller);
        buttonRightBracket.setActionCommand("BracketRight");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(buttonDelete);

        panel.add(buttonSeven);
        panel.add(buttonEight);
        panel.add(buttonNine);
        panel.add(buttonDivide);

        panel.add(buttonLeftBracket);
        panel.add(buttonRightBracket);

        panel.add(buttonFour);
        panel.add(buttonFive);
        panel.add(buttonSix);
        panel.add(buttonMultiplication);

        panel.add(buttonOne);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        panel.add(buttonMinus);
        panel.add(buttonEqually);

        panel.add(buttonZero);
        panel.add(buttonComma);
        panel.add(buttonPlus);
        panel.add(buttonClear);
        return panel;
    }

    public void update(String value) {
        textField.setText(value);
    }

    public String getValue() {
        return textField.getText();
    }

    public void updateAnswer(String value) {
        answer.setText(value);
    }

}

