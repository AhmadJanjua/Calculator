package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class that deals with the logic of the inputs
 */
public class CalcAction implements ActionListener {
    // Current inputs and the previous input (if exists)
    String prevNum = "", currNum = "";
    // Tracks if decimal has been used
    boolean usedDec = false;

    // Logic is not done; Framework is setup
    @Override
    public void actionPerformed(ActionEvent e) {
        String t = e.getActionCommand();
        switch(t) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                currNum += t;
                CalcFrame.setText(currNum);
                break;
            case "x":
                break;
            case "÷":
                break;
            case "+":
                break;
            case "-":
                break;
            case "=":
                break;

            case "c":
                prevNum = currNum = "";
                usedDec = false;
                CalcFrame.setText("");
                break;

            case ".":
                if(!usedDec)
                    currNum += t;
                usedDec = true;
                CalcFrame.setText(currNum);
                break;
        }
        
    }

}
