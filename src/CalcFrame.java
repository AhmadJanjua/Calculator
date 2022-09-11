package src;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcFrame extends JFrame {

    // Fields
    private static JTextField screen = new JTextField();

    // Sets up the frame, buttons and subframes
    public CalcFrame() {

        var action = new CalcAction();
        JPanel borderPanel, gridPanel;
        
        // Derive font
        var font = screen.getFont().deriveFont(Font.PLAIN, 25f);
        
        //Set window size
        setSize(500,400);

        // Set up grid to hold all the buttons
        gridPanel = new JPanel(new GridLayout(3,6));

        // Create all number buttons and add action listeners
        JButton numButtons[] = new JButton[10];
        for(int i = 0; i<10; i++) {
            numButtons[i] = new CalcButton( String.valueOf(i), action);
        }

        // Create all operation buttons and action listeners
        var multB = new CalcButton( "x", action);
        var divB = new CalcButton( "÷",  action);
        var addB = new CalcButton( "+",  action);
        var subB = new CalcButton( "-",  action);
        var equB = new CalcButton( "=",  action);
        var clrB = new CalcButton( "C",  action);
        var decB = new CalcButton( ".",  action);

        var blank = new JButton();
        blank.setBackground(Color.GRAY);
        blank.setEnabled(false);

        // Add buttons to the gridPanel
        gridPanel.add(numButtons[7]);
        gridPanel.add(numButtons[8]);
        gridPanel.add(numButtons[9]);
        gridPanel.add(addB);
        gridPanel.add(subB);
        gridPanel.add(clrB);
        gridPanel.add(numButtons[4]);
        gridPanel.add(numButtons[5]);
        gridPanel.add(numButtons[6]);
        gridPanel.add(multB);
        gridPanel.add(divB);
        gridPanel.add(decB);
        gridPanel.add(numButtons[1]);
        gridPanel.add(numButtons[2]);
        gridPanel.add(numButtons[3]);
        gridPanel.add(numButtons[0]);
        gridPanel.add(blank);
        gridPanel.add(equB);
        
        

        // Format the screen
        screen.setFont(font);
        screen.setForeground(Color.WHITE);
        screen.setBackground(Color.BLACK);
        screen.setEditable(false);
        screen.setText("");

        // Add screen and buttons to border layout
        borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(gridPanel, BorderLayout.CENTER);
        borderPanel.add(screen, BorderLayout.NORTH);
        
        // Add outter frame to the main JFrame
        add(borderPanel);
    }

    //Setter for modifying text on the screen
    public static void setText(String t) {
        screen.setText(t);
    }
}

class CalcButton extends JButton {

    public CalcButton(String text, CalcAction action) {
        super(text);
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLUE);
        addActionListener(action);
    }
}