package com.SMS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame  implements ActionListener {

    JLabel labelProgram, labelFunctionality;
    JButton buttonAdd, buttonDelete, buttonSearch, buttonUG, buttonPG, enterButton;
    JTextField tfName, tfCMS, tfSem;
    StudentManagementSystem sms;
    JOptionPane optionPane;
    int value = 0;
    boolean addButtonClicked = false;
    boolean deleteButtonClicked = false;
    boolean searchButtonClicked = false;

    // constructor
    public GUI() {
        sms = new StudentManagementSystem();
        setLayout(new FlowLayout());
        // adding the label
        labelProgram = new JLabel("           Which Program you want to access?                    ");
        add(labelProgram);

        buttonUG = new JButton("UG");
        buttonPG = new JButton("PG");
        add(buttonUG);
        add(buttonPG);
        labelFunctionality = new JLabel("     Which functionality you want to use?       ");
        add(labelFunctionality);
        labelFunctionality.setVisible(false);


        // adding the buttons
        buttonAdd = new JButton("Add");
        buttonDelete = new JButton("Delete");
        buttonSearch = new JButton("Search");
        buttonUG.addActionListener(this);
        buttonPG.addActionListener(this);
        add(buttonAdd);
        add(buttonDelete);
        add(buttonSearch);
        buttonAdd.setVisible(false);
        buttonDelete.setVisible(false);
        buttonSearch.setVisible(false);
        buttonAdd.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonSearch.addActionListener(this);
        // adding the text field
        tfName = new JTextField(20);
        tfName.setBounds(80, 100, 150, 50);
        tfName.setText("Enter Name here");
        tfCMS = new JTextField(20);
        tfCMS.setBounds(80, 150, 150, 50);
        tfCMS.setText("Enter CMS ID here");
        tfSem = new JTextField(20);
        tfSem.setBounds(80, 200, 150, 50);
        tfSem.setText("Enter semester here");
        tfName.setVisible(false);
        tfCMS.setVisible(false);
        tfSem.setVisible(false);
        add(tfName);
        add(tfCMS);
        add(tfSem);

        enterButton = new JButton("Submit");
        add(enterButton);
        enterButton.setVisible(false);
        enterButton.addActionListener(this);
    }

    // main method with proper signature that begins the execution of program
    public static void main(String... args) {
        GUI gui = new GUI();
        gui.setSize(320, 320);
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);

    }// END MAIN METHOD

    // give implementation to the abstract method of ActionListener interface
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == enterButton && searchButtonClicked) {
            try {
                String c = tfCMS.getText();
                int cms = Integer.parseInt(c);
                sms.searchStudent(cms);
                JOptionPane.showMessageDialog(new JFrame(), "Student Found Successfully");
            } catch (StudentManagmentException exception) {
                JOptionPane.showMessageDialog(new JFrame(), exception.toString());

            }

        }if (e.getSource() == enterButton && deleteButtonClicked) {
            try {
                String c = tfCMS.getText();
                int cms = Integer.parseInt(c);
                boolean returnValue = sms.deleteStudent(cms);
                if (returnValue) {
                    JOptionPane.showMessageDialog(new JFrame(), "Student Deleted Successfully");
                }
            } catch (StudentManagmentException exception) {
                JOptionPane.showMessageDialog(new JFrame(), exception.toString());

            }
        }  if (e.getSource() == enterButton && addButtonClicked) {
            try {
                String name = tfName.getText();
                String c = tfCMS.getText();
                String s = tfSem.getText();
                int cms = Integer.parseInt(c);
                int sem = Integer.parseInt(s);
                boolean returnValue = sms.addRecord(name, cms, sem, value);
                if (returnValue) {
                    JOptionPane.showMessageDialog(new JFrame(), "Student Added Successfully");


                }
            } catch (StudentManagmentException exception) {
                JOptionPane.showMessageDialog(new JFrame(), exception.toString());
            }
        } else if (e.getSource() == buttonUG || e.getSource() == buttonPG) {
            if (e.getSource() == buttonUG) {
                value = 1;
            } else {
                value = 2;
            }
            labelFunctionality.setVisible(true);
            buttonAdd.setVisible(true);
            buttonDelete.setVisible(true);
            buttonSearch.setVisible(true);
        } else if (e.getSource() == buttonAdd) {
            tfCMS.setVisible(false);
            enterButton.setVisible(false);
            tfName.setVisible(true);
            tfCMS.setVisible(true);
            tfSem.setVisible(true);
            enterButton.setVisible(true);
            addButtonClicked = true;
        } else if (e.getSource() == buttonDelete) {
            tfName.setVisible(false);
            tfSem.setVisible(false);
            tfCMS.setVisible(true);
            tfCMS.setText("Enter CMS id here");
            enterButton.setVisible(true);
            deleteButtonClicked = true;
        } else if (e.getSource() == buttonSearch) {
            tfName.setVisible(false);
            tfSem.setVisible(false);
            tfCMS.setVisible(true);
            tfSem.setText("Enter semester number");
            enterButton.setVisible(true);
            searchButtonClicked = true;
        }
    }
}// end GUI class



