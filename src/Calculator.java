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

    Calculator() {
        frame.setVisible(true);
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
            buttonsPanel.add(button);
        }
    }
}