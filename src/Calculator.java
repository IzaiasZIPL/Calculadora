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

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel  = new JLabel(); 
    JPanel displayPanel = new JPanel();

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
    }
}