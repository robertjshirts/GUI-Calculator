/**
 * @author rshirts
 * @createdOn 2/20/2023 at 1:00 PM
 * @projectName Calculator v2
 * @packageName com.calculator.controllers;
 */
package com.calculator.controllers;

import com.calculator.models.Calculator;
import com.calculator.models.MathOperators;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController implements ActionListener {
    private JLabel label;
    private final int BUTTON_WIDTH = 45;
    private final int BUTTON_HEIGHT = 45;

    public void run() {
        //create JPanel (the window)
        JFrame frame = new JFrame();
        //create JFrame (everything in the window)
        JPanel panel = new JPanel();
        //set some important things
        frame.setSize(350,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator :)");
        frame.add(panel);

        panel.setLayout(null);

        //create a JLabel, or the text box
        label = new JLabel("0");
        //Give it a right text alignment
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        //define where it will be and how big it will be
        label.setBounds(10,20,145, 25);
        //add it to the layout
        panel.add(label);

        //create new button
        JButton zero = new JButton("0");
        //set the position and the size of the button
        zero.setBounds(60, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
        //add a listener
        zero.addActionListener(this);
        //add the button to the layout
        panel.add(zero);
        //rinse repeat for all the other buttons

        JButton one = new JButton("1");
        one.setBounds(10, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
        one.addActionListener(this);
        panel.add(one);

        JButton two = new JButton("2");
        two.setBounds(60, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
        two.addActionListener(this);
        panel.add(two);

        JButton three = new JButton("3");
        three.setBounds(110, 150, BUTTON_WIDTH, BUTTON_HEIGHT);
        three.addActionListener(this);
        panel.add(three);

        JButton four = new JButton("4");
        four.setBounds(10, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        four.addActionListener(this);
        panel.add(four);

        JButton five = new JButton("5");
        five.setBounds(60, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        five.addActionListener(this);
        panel.add(five);

        JButton six = new JButton("6");
        six.setBounds(110, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        six.addActionListener(this);
        panel.add(six);

        JButton seven = new JButton("7");
        seven.setBounds(10, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
        seven.addActionListener(this);
        panel.add(seven);

        JButton eight = new JButton("8");
        eight.setBounds(60, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
        eight.addActionListener(this);
        panel.add(eight);

        JButton nine = new JButton("9");
        nine.setBounds(110, 50, BUTTON_WIDTH, BUTTON_HEIGHT);
        nine.addActionListener(this);
        panel.add(nine);

        JButton backspace = new JButton("Back");
        backspace.setMargin(new Insets(0,0,0,0));
        backspace.setBounds(165, 20, BUTTON_WIDTH, 25);
        backspace.addActionListener(this);
        panel.add(backspace);

        JButton add = new JButton("+");
        add.setBounds(165, 50, BUTTON_WIDTH, 25);
        add.addActionListener(this);
        panel.add(add);

        JButton sub = new JButton("-");
        sub.setBounds(165, 80, BUTTON_WIDTH, 25);
        sub.addActionListener(this);
        panel.add(sub);

        JButton mul = new JButton("*");
        mul.setBounds(165, 110, BUTTON_WIDTH, 25);
        mul.addActionListener(this);
        panel.add(mul);

        JButton div = new JButton("/");
        div.setBounds(165, 140, BUTTON_WIDTH, 25);
        div.addActionListener(this);
        panel.add(div);

        JButton mod = new JButton("%");
        mod.setBounds(165, 170, BUTTON_WIDTH, 25);
        mod.addActionListener(this);
        panel.add(mod);

        JButton equals = new JButton("=");
        equals.setBounds(165, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
        equals.addActionListener(this);
        panel.add(equals);

        JButton ans = new JButton("Ans");
        ans.setMargin(new Insets(0,0,0,0));
        ans.setBounds(110, 200, BUTTON_WIDTH, BUTTON_HEIGHT);
        ans.addActionListener(this);
        panel.add(ans);
        //that's a lot of buttons

        //after adding everything to the frame, we need to make it visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //when a button is pressed, the event listener calls this function
        String command = e.getActionCommand();
        System.out.println(command);
        //we can get the ActionCommand and use a switch case to decide which function to call
        //from the Calculator class
        switch (command) {
            case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" ->
                    label.setText(Calculator.addNumber(Integer.parseInt(command)) + "");
            case "Back" -> label.setText(Calculator.removeNumber() + "");
            case "+" -> label.setText(Calculator.setOperator(MathOperators.ADD) + "");
            case "-" -> label.setText(Calculator.setOperator(MathOperators.SUBTRACT) + "");
            case "*" -> label.setText(Calculator.setOperator(MathOperators.MULTIPLY) + "");
            case "/" -> label.setText(Calculator.setOperator(MathOperators.DIVIDE) + "");
            case "%" -> label.setText(Calculator.setOperator(MathOperators.MODULUS) + "");
            case "Ans" -> label.setText(Calculator.getAns() + "");
            default -> label.setText(Calculator.doOperation() + "");
        }
    }
}
