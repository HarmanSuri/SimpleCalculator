/*  Class SimpleCalculator
    Author: Harman Suri
    Oct 28, 2020
    Description:    Inherits from JFrame so it is a JFrame. Creates a usable
                    calculator with a working GUI.
    Data:           clearDisp, opClicked, finalAnswer, operation, brdButtons, fntDisp,
                    fntNum, fntOperation, pnlNumbers, pnlOperations, btnNums[],
                    btnEquals, btnDot, btnPlus, btnMinus, btnDivide, btnMultiply,
                    btnClearAll, btnClearDisp, btnOff, txtDisplay
    Methods:        ExerciseTwo                     - class constructor, draws GUI
                    actionPreformed (ActionEvent e) - listens to see if any buttons in the GUI have been pressed
                    boolean hasDot (String input)   - takes in a string and returns a boolean based on the
                                                      number of dots it contains
                    main (String[] args)            - creates a new ExerciseTwo object

 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.File;
import java.io.IOException;

public class SimpleCalculator extends JFrame implements ActionListener {

    // declares a boolean to see if the display should be cleared and if an operation has been clicked
    private boolean clearDisp, opClicked;
    // declares a double to hold the final answer of the calculations
    private double finalAnswer;
    // declares a char to hold what operation is to be done
    private char operation;

    // declare a border for the buttons
    Border brdButtons;

    // declare font objects for the different texts in the calculator
    Font fntDisp, fntNum, fntOperation;

    // declares panels to hold the numbers, and operations
    JPanel pnlNumbers, pnlOperations;

    // declares a button array for the numbers
    JButton[] btnNums;
    // declares buttons for the operations, and other functions
    JButton btnEquals, btnDot, btnPlus, btnMinus, btnDivide, btnMultiply, btnClearAll, btnClearDisp, btnOff;

    // declares a text field for the display
    JTextField txtDisplay;


    public SimpleCalculator() throws IOException, FontFormatException {
        super("SimpleCalculator");  // Set the frame's name

        // creates the two booleans and double needed for calculations
        clearDisp = false;
        opClicked = false;
        finalAnswer = 0;

        // makes sure that when the frame is closed the program ends
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creates the a dark gray line border with a thickness of 3
        brdButtons = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

        // creates the font for the display by accessing a downloaded ttf file
        fntDisp = Font.createFont(Font.TRUETYPE_FONT, new File("src/digital-7.ttf"));
        fntDisp = fntDisp.deriveFont(Font.BOLD, 60);

        // creates the font for the numbers and operations
        fntNum = new Font("Agency FB", Font.BOLD, 40);
        fntOperation = new Font("Agency FB", Font.BOLD, 35);

        // creates the panels for the numbers and display
        pnlNumbers = new JPanel();
        pnlOperations = new JPanel();

        // creates the button array for the numbers
        btnNums = new JButton[10];

        // loops from 0 to the length of the button array
        for (int i = 0; i < btnNums.length; i++) {
            // creates each JButton in the array using the i as the text in the button
            // various properties of the button are set too
            btnNums[i] = new JButton(Integer.toString(i));
            btnNums[i].setFont(fntNum);
            btnNums[i].addActionListener(this);
            btnNums[i].setBackground(Color.BLACK);
            btnNums[i].setForeground(Color.WHITE);
            btnNums[i].setBorder(brdButtons);
        }

        // creates the equals button
        // various properties of the button are set too
        btnEquals = new JButton("=");
        btnEquals.setFont(fntNum);
        btnEquals.addActionListener(this);
        btnEquals.setBackground(Color.BLACK);
        btnEquals.setForeground(Color.WHITE);
        btnEquals.setBorder(brdButtons);

        // creates the button for the decimal point
        // various properties of the button are set too
        btnDot = new JButton(".");
        btnDot.setFont(fntNum);
        btnDot.addActionListener(this);
        btnDot.setBackground(Color.BLACK);
        btnDot.setForeground(Color.WHITE);
        btnDot.setBorder(brdButtons);

        // creates the plus button
        // various properties of the button are set too
        btnPlus = new JButton("+");
        btnPlus.setFont(fntOperation);
        btnPlus.addActionListener(this);
        btnPlus.setBackground(Color.BLACK);
        btnPlus.setForeground(Color.WHITE);
        btnPlus.setBorder(brdButtons);

        // creates the minus button
        // various properties of the button are set too
        btnMinus = new JButton("-");
        btnMinus.setFont(fntOperation);
        btnMinus.addActionListener(this);
        btnMinus.setBackground(Color.BLACK);
        btnMinus.setForeground(Color.WHITE);
        btnMinus.setBorder(brdButtons);

        // creates the divide button
        // various properties of the button are set too
        btnDivide = new JButton("÷");
        btnDivide.setFont(fntOperation);
        btnDivide.addActionListener(this);
        btnDivide.setBackground(Color.BLACK);
        btnDivide.setForeground(Color.WHITE);
        btnDivide.setBorder(brdButtons);

        // creates the multiply button
        // various properties of the button are set too
        btnMultiply = new JButton("x");
        btnMultiply.setFont(fntOperation);
        btnMultiply.addActionListener(this);
        btnMultiply.setBackground(Color.BLACK);
        btnMultiply.setForeground(Color.WHITE);
        btnMultiply.setBorder(brdButtons);

        // creates the clear all button
        // various properties of the button are set too
        btnClearAll = new JButton("AC");
        btnClearAll.setFont(fntOperation);
        btnClearAll.addActionListener(this);
        btnClearAll.setBackground(Color.BLACK);
        btnClearAll.setForeground(Color.WHITE);
        btnClearAll.setBorder(brdButtons);

        // creates the clear display button
        // various properties of the button are set too
        btnClearDisp = new JButton("CE");
        btnClearDisp.setFont(fntOperation);
        btnClearDisp.addActionListener(this);
        btnClearDisp.setBackground(Color.BLACK);
        btnClearDisp.setForeground(Color.WHITE);
        btnClearDisp.setBorder(brdButtons);

        // creates the off button
        // various properties of the button are set too
        btnOff = new JButton("OFF");
        btnOff.setFont(fntOperation);
        btnOff.addActionListener(this);
        btnOff.setBackground(Color.BLACK);
        btnOff.setForeground(Color.WHITE);
        btnOff.setBorder(brdButtons);

        // creates the text field for the display, the default value is 0
        // various properties of the text field are set too
        txtDisplay = new JTextField("0");
        txtDisplay.setFont(fntDisp);
        // the text is aligned to the right
        txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
        // the text field is made uneditable
        txtDisplay.setEditable(false);
        txtDisplay.setBackground(new Color(176, 224, 130));

        // the layout of the content pane is set to a border layout
        getContentPane().setLayout(new BorderLayout());

        // the layout of the numbers panel is set to a grid layout
        pnlNumbers.setLayout(new GridLayout(4, 3));
        // the number buttons are added to the numbers panel in the order they appear on a calcultor
        pnlNumbers.add(btnNums[7]);
        pnlNumbers.add(btnNums[8]);
        pnlNumbers.add(btnNums[9]);
        pnlNumbers.add(btnNums[4]);
        pnlNumbers.add(btnNums[5]);
        pnlNumbers.add(btnNums[6]);
        pnlNumbers.add(btnNums[1]);
        pnlNumbers.add(btnNums[2]);
        pnlNumbers.add(btnNums[3]);
        pnlNumbers.add(btnNums[0]);
        // the equals button and dot button are added to the numbers panel
        pnlNumbers.add(btnEquals);
        pnlNumbers.add(btnDot);

        // the layout of the operations panel is set to a grid layout
        pnlOperations.setLayout(new GridLayout(7, 1));
        // each operation button is added to the operations panel
        pnlOperations.add(btnPlus);
        pnlOperations.add(btnMinus);
        pnlOperations.add(btnDivide);
        pnlOperations.add(btnMultiply);
        // the clear all, clear display and off button are added to the operation panel
        pnlOperations.add(btnClearAll);
        pnlOperations.add(btnClearDisp);
        pnlOperations.add(btnOff);

        // sets the preferred size of the display text so it looks bigger
        txtDisplay.setPreferredSize(new Dimension(500, 100));

        // the text field and each panel is added to the content pane
        // first txtDisplay to the north
        // second pnlNumbers to the center
        // third pnlOperations to the east
        getContentPane().add(txtDisplay, BorderLayout.NORTH);
        getContentPane().add(pnlNumbers, BorderLayout.CENTER);
        getContentPane().add(pnlOperations, BorderLayout.EAST);
        getContentPane().setBackground(Color.DARK_GRAY);

        setSize(500, 500);     // Set the frame's size
        setVisible(true);                // Show the frame
    }

    /*
        actionPerformed listens to button clicks
     */
    public void actionPerformed(ActionEvent e) {
        // a string to hold the text in the text field
        String line = txtDisplay.getText();

        // if button 0 is clicked
        if (e.getSource() == btnNums[0]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 0 and clearDisp is set to false
                line = "0";
                clearDisp = false;
            }
            else {
                // otherwise 0 is added to line
                line += "0";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 1 is clicked
        else if (e.getSource() == btnNums[1]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 1 and clearDisp is set to false
                line = "1";
                clearDisp = false;
            }
            else {
                // otherwise 1 is added to line
                line += "1";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 2 is clicked
        else if (e.getSource() == btnNums[2]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 2 and clearDisp is set to false
                line = "2";
                clearDisp = false;
            }
            else {
                // otherwise 2 is added to line
                line += "2";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 3 is clicked
        else if (e.getSource() == btnNums[3]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 3 and clearDisp is set to false
                line = "3";
                clearDisp = false;
            }
            else {
                // otherwise 3 is added to line
                line += "3";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 4 is clicked
        else if (e.getSource() == btnNums[4]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 4 and clearDisp is set to false
                line = "4";
                clearDisp = false;
            }
            else {
                // otherwise 4 is added to line
                line += "4";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 5 is clicked
        else if (e.getSource() == btnNums[5]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 5 and clearDisp is set to false
                line = "5";
                clearDisp = false;
            }
            else {
                // otherwise 5 is added to line
                line += "5";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 6 is clicked
        else if (e.getSource() == btnNums[6]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 6 and clearDisp is set to false
                line = "6";
                clearDisp = false;
            }
            else {
                // otherwise 6 is added to line
                line += "6";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 7 is clicked
        else if (e.getSource() == btnNums[7]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 7 and clearDisp is set to false
                line = "7";
                clearDisp = false;
            }
            else {
                // otherwise 7 is added to line
                line += "7";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 8 is clicked
        else if (e.getSource() == btnNums[8]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 8 and clearDisp is set to false
                line = "8";
                clearDisp = false;
            }
            else {
                // otherwise 8 is added to line
                line += "8";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if button 9 is clicked
        else if (e.getSource() == btnNums[9]) {
            // if line is just 0 or clearDisp is true
            if (line.equalsIgnoreCase("0")  || clearDisp){
                // then line is equal to 9 and clearDisp is set to false
                line = "9";
                clearDisp = false;
            }
            else {
                // otherwise 9 is added to line
                line += "9";
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if the plus button is clicked
        else if (e.getSource() == btnPlus) {
            // if opClicked is true
            // this if is done to avoid resetting finalAnswer
            if (opClicked) {
                // final answer is equal to itself plus answer
                finalAnswer += Double.parseDouble(line);
            }
            else {
                // otherwise opClicked is set to true and final answer is equal to the numerical value of line
                opClicked = true;
                finalAnswer = Double.parseDouble(line);
            }
            // operation is equal to +
            operation = '+';
            // clear display is equal to true
            clearDisp = true;
        }
        // if the minus button is clicked
        else if (e.getSource() == btnMinus) {
            // if opClicked is true
            // this if is done to avoid resetting finalAnswer
            // for subtraction specifically it avoids finalAnswer equaling the postive value of the number being subtracted
            if (opClicked) {
                // final answer is equal to itself minus answer
                finalAnswer -= Double.parseDouble(line);
            }
            else {
                // otherwise opClicked is set to true and final answer is equal to the numerical value of line
                opClicked = true;
                finalAnswer = Double.parseDouble(line);
            }
            // operation is equal to -
            operation = '-';
            // clear display is equal to true
            clearDisp = true;
        }
        // if the divide button is clicked
        else if (e.getSource() == btnDivide) {
            // if opClicked is true
            // this if is done to avoid resetting finalAnswer
            // for division specifically it avoids dividing 0 (the initial value of finalAnswer)
            if (opClicked) {
                // final answer is equal to itself divided by answer
                finalAnswer /= Double.parseDouble(line);
            }
            else {
                // otherwise opClicked is set to true and final answer is equal to the numerical value of line
                opClicked = true;
                finalAnswer = Double.parseDouble(line);
            }
            // operation is equal to /
            operation = '/';
            // clear display is equal to true
            clearDisp = true;
        }
        // if the multiply button is clicked
        else if (e.getSource() == btnMultiply) {
            // if opClicked is true
            // this if is done to avoid resetting finalAnswer
            // for multiplication specifically it avoids multiplying with 0 (the initial value of finalAnswer)
            if (opClicked) {
                // final answer is equal to itself times answer
                finalAnswer *= Double.parseDouble(line);
            }
            else {
                // otherwise opClicked is set to true and final answer is equal to the numerical value of line
                opClicked = true;
                finalAnswer = Double.parseDouble(line);
            }
            // operation is equal to *
            operation = '*';
            // clear display is equal to true
            clearDisp = true;
        }
        // if the equals button is clicked
        else if (e.getSource() == btnEquals) {
            // if operation is equal to +
            if (operation == '+') {
                // then final answer is equal to itself plus answer
                finalAnswer += Double.parseDouble(line);
            }
            // if operation is equal to -
            else if (operation == '-') {
                // then final answer is equal to itself minus answer
                finalAnswer -= Double.parseDouble(line);
            }
            // if operation is equal to /
            else if (operation == '/') {
                // then final answer is equal to itself divided by answer
                finalAnswer /= Double.parseDouble(line);
            }
            // if operation is equal to *
            else if (operation == '*') {
                // then final answer is equal to itself times answer
                finalAnswer *= Double.parseDouble(line);
            }
            else {
                // if no operation has been clicked final answer is equal to answer
                finalAnswer = Double.parseDouble(line);
            }

            // opClicked is set to false
            opClicked = false;
            // the text of the txtDisplay is set to final answer
            txtDisplay.setText(String.valueOf(finalAnswer));
            // final answer is 0
            finalAnswer = 0;
            // clear display is equal to true
            clearDisp = true;
        }
        // if the dot button is clicked
        else if (e.getSource() == btnDot) {
            // if the return of hasDot is false
            if (!hasDot(line))
            {
                // if line is just 0 or clearDisp is true
                if (line.equalsIgnoreCase("0") || clearDisp) {
                    // then line is equal to 0. and clearDisp is set to false
                    line = "0.";
                    clearDisp = false;
                } else {
                    // otherwise a . is added to line
                    line += ".";
                }
            }
            // the text in the text field is set to line
            txtDisplay.setText(line);
        }
        // if the clear all button is clicked
        else if (e.getSource() == btnClearAll) {
            // the text field is set to 0
            txtDisplay.setText("0");
            // final answer is set to 0
            finalAnswer = 0;
            // opClicked is set to false
            opClicked = false;
        }
        // if the clear display button is clicked
        else if (e.getSource() == btnClearDisp) {
            // the text field is set to 0
            txtDisplay.setText("0");
        }
        // if the off button is clicked
        else if (e.getSource() == btnOff) {
            // the program is ended
            System.exit(0);
        }
    }

    /*
        hasDot checks if the given string has any periods/decimal points in it.
        A boolean is returned depending on how many were found.
     */
    public boolean hasDot (String input) {
        // dotCount will hold the number of dots found
        int dotCount = 0;

        // loops from 0 to the length of input
        for (int i = 0; i < input.length(); i ++) {
            // if a . is found at i then dotCount is incremented by one
            if (input.charAt(i) == '.') {
                dotCount ++;
            }
        }

        // returns true if dotCount is or is greater than one
        return dotCount >= 1;
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        new SimpleCalculator();     // Create a ExerciseTwo frame
    }
}
