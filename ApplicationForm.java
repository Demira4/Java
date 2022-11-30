package lessEight;


import lessEight.Listener.ButtonListener;
import lessEight.Listener.ClearFieldButtonListener;
import lessEight.component.DigitButton;
import lessEight.component.OperatorButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class ApplicationForm extends JFrame {
   private JTextField inputField;
    private BigDecimal result;
    private String lastCommand;
    private boolean start;

    public ApplicationForm(String title) { //рисуем главную форму, на которой все будет находиться
        super(title);
        setBounds(200,300,250,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setJMenuBar(createMenu());
        setLayout(new BorderLayout());
        add (createTopPanel(), BorderLayout.NORTH );
        add (createCenterPanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    private JPanel createCenterPanel() { //рисуем на главной форме 2 формы с цифрами и операторами
        ActionListener buttonListener = new ButtonListener(inputField);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add (createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add (createOperatorPanel(buttonListener), BorderLayout.EAST);
        return centerPanel;
    }

    private JPanel createOperatorPanel(ActionListener buttonListener) { //панель с операторами
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        ActionListener command = new CommandAction();
        JButton plus = new OperatorButton("+");
        plus.addActionListener(command);
        panel.add(plus);

        JButton minus = new OperatorButton("-");
        minus.addActionListener(command);
        panel.add(minus);

        JButton multiply = new OperatorButton("*");
        multiply.addActionListener(command);
        panel.add(multiply);

        JButton divide = new OperatorButton("/");
        divide.addActionListener(command);
        panel.add(divide);

        return panel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) { // панель с цифрами, =, С
        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4,3));
        ActionListener insert = new InsertAction();

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i==9) ? "0": String.valueOf (i+1);
            JButton btn = new DigitButton(buttonTitle);
            btn.addActionListener(insert);
            digitsPanel.add(btn);

        }

        JButton calc = new OperatorButton("=");
        ActionListener command = new CommandAction();
        calc.addActionListener(command);
        digitsPanel.add(calc);
        JButton c = new OperatorButton("C");
        c.addActionListener(new ClearFieldButtonListener(inputField));
        digitsPanel.add(c);
        return digitsPanel;
    }

    private JPanel createTopPanel() { // форма, где выводим информацию
        result = BigDecimal.ZERO;
        lastCommand = "=";
        start = true;
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("TimesRoman", Font.ITALIC,25));
        inputField.setMargin(new Insets(5,0,5,0));
        inputField.setBackground(new Color(23, 148, 153));

        return top;
    }

    private JMenuBar createMenu() { // меню на главной форме
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuFile.add(exit);
        menuBar.add(menuFile);
        menuBar.add(new JMenu("Help"));
        menuBar.add(new JMenu("About"));

        return menuBar;

    }
    private class InsertAction implements ActionListener { // слушатель формы вывода информации цифр
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                inputField.setText("");
                start = false;
            }
            inputField.setText(inputField.getText() + input); // выводим текст, пока не получим оператор
        }
    }

    private class CommandAction implements ActionListener { // слушатель формы вывода информации операторов
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
           // if (start) {
//                if (command.equals("-")) {
//                    inputField.setText(command);
//                    start = false;
//                } else lastCommand = command;
 //           } else {
                calculate(new BigDecimal(inputField.getText()));
                lastCommand = command;
                start = true;
 //           }
        }
    }

    public void calculate(BigDecimal x) { //математические операции (подсмотрела в интернете)
        if (lastCommand.equals("+")) result = result.add(x);
        else if (lastCommand.equals("-")) result = result.subtract(x);
        else if (lastCommand.equals("*")) result = result.multiply(x);
        else if (lastCommand.equals("/")) result = result.divide(x);
        else if (lastCommand.equals("=")) result = x;
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }
        inputField.setText(result.toString());
    }
}
