package src;

import java.awt.EventQueue;

import javax.swing.JFrame;


/**
 * Class to create and run the Calculator GUI.
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            var frame = new CalcFrame();
            frame.setTitle("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
