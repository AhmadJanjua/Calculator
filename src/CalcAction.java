package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener class that deals with the logic of the inputs
 */
public class CalcAction implements ActionListener {
    // Current inputs and the previous input (if exists)
    String prevNum = "", currNum = "";
    String operation = "";
    // Tracks if decimal has been used
    boolean usedDec = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        String t = e.getActionCommand();
        switch(t) {
            //Create the current number
            case "0":
            case "1":
            case "2": 
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                currNum += t;
                CalcFrame.setText(currNum);
                break;
            // Add function for operator
            case "x":
            case "+":
            case "-":
            case "÷":
                if(operation.equals(""))
                    operation = t;
                if(!currNum.equals("") && !currNum.equals(".")) {
                    if(prevNum.equals("")) {
                        prevNum = currNum;
                        currNum = "";
                        operation = t;
                        CalcFrame.setText(currNum);
                    }
                    else {
                        try {
                            prevNum = String.valueOf(compute());
                            currNum = "";
                            operation = t;
                            CalcFrame.setText(prevNum);
                        } catch (ArithmeticException g) {
                            reset();
                            CalcFrame.setText("Cannot divide by zero!");
                        }

                    }
                }
                break;
            // Functionality for changing the sign of the number
            case "+/-":
                if(currNum.equals("")) {
                    currNum += "-";
                    CalcFrame.setText(currNum);
                } 
                else if(currNum.charAt(0) == '-') {
                    currNum = currNum.substring(1);
                }
                else {
                    currNum = "-" + currNum;
                }
                CalcFrame.setText(currNum);
                break;
            // Finding the solution to the equation.
            case "=":
                if(!currNum.equals("") && !currNum.equals(".") && !prevNum.equals("")) {
                    try {
                        String temp = String.valueOf(compute());
                        reset();
                        CalcFrame.setText(temp);
                    } catch (ArithmeticException g) {
                        reset();
                        CalcFrame.setText("Cannot divide by zero!");
                    }
                    
                }
                break;
            // Reset calculator
            case "C":
                reset();
                break;
            // Add decimal only once
            case ".":
                if(!usedDec)
                    currNum += t;
                usedDec = true;
                CalcFrame.setText(currNum);
                break;
        }
        
    }
    // Helper function to do the addition as well as send exception for illegal arithmatic
    private double compute() throws ArithmeticException{
        double firstNum = Double.parseDouble(prevNum);
        double secNum = Double.parseDouble(currNum);
        double results = 0;
        switch(operation) {
            case "+":
                results = firstNum + secNum;
                break;
            case "-":
                results = firstNum - secNum;
                break;
            case "x":
                results = firstNum * secNum;
                break;
            case "÷":
                results = firstNum/secNum;
                if(Double.isInfinite(results))
                    throw new ArithmeticException("Cannot Divide By Zero!");  
        }
        return results;
    }

    // Helper function to reset the Calculator
    private void reset() {
        prevNum = currNum = operation = "";
        usedDec = false;
        CalcFrame.setText("");
    }

}
