import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Calculator{
    int boardWidth = 360;
    int boardHeight = 540;

    Color customCastletonGreen = new Color(2, 93, 48);
    Color customDarkGreen = new Color( 0, 47, 25);
    Color customChineseBlack = new Color( 7, 29, 14);
    Color customGray = new Color(212,212,210);

    String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};   

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel  = new JLabel(); 
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

     
    String A = "0";
    String operator = null;
    String B = null;

    Calculator() {
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false); /*Why i cant let this be true? Try change it later */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(customChineseBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN,  80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);  
        displayLabel.setText("0");  
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(customCastletonGreen);
        frame.add(buttonsPanel);


        for (int i = 0; i < buttonValues.length; i++){
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customCastletonGreen));
            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customCastletonGreen);
                button.setForeground(customChineseBlack);
            }
            else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(customDarkGreen);
                button.setForeground(Color.white);
            }
            else{
                button.setBackground(customCastletonGreen);
                button.setForeground(Color.white);
            }
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();
                    if(Arrays.asList(rightSymbols).contains(buttonValue)){ 
                        if (buttonValue == "="){
                            if (A != null) {
                                B = displayLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                if (operator == "+"){
                                    displayLabel.setText(removeZeroDecimal(numA+numB));
                                }
                                else if (operator == "-"){
                                    displayLabel.setText(removeZeroDecimal(numA-numB));
                                }
                                if (operator == "×"){
                                    displayLabel.setText(removeZeroDecimal(numA*numB));
                                }
                                if (operator == "÷"){
                                    displayLabel.setText(removeZeroDecimal(numA/numB));
                                }
                                clearAll();
                            }
                        }
                        else if ("+-×÷".contains(buttonValue)){
                            if (operator == null) {
                                A = displayLabel.getText();
                                displayLabel.setText("0");
                                B = "0";
                            }
                            operator = buttonValue;
                        }
                    }
                    else if (Arrays.asList(topSymbols).contains(buttonValue)){
                        if (buttonValue == "AC") {
                            clearAll();
                            displayLabel.setText("0");
                        }
                        else if (buttonValue == "+/-"){
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay *= -1;
                            displayLabel.setText(Double.toString(numDisplay));

                        }
                        else if (buttonValue == "%"){
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay /= 100;
                            displayLabel.setText(removeZeroDecimal(numDisplay)); 
                        }
                    }
                    else{
                        if (buttonValue == "."){
                            if (!displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                        else if ("0123456789".contains(buttonValue))
                        {
                            if (displayLabel.getText() == "0"){
                                displayLabel.setText(buttonValue);
                            }
                            else{
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                    }
                }
            });
            
        frame.setVisible(true);
        }
    }
    void clearAll() {
        A = "0";
        operator = null;
        B = null;
    }

    String removeZeroDecimal(double numDisplay){
        if (numDisplay % 1 == 0){
            return Integer.toString((int) numDisplay);
        }
        return Double.toString(numDisplay);  
    }
}