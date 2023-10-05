package com.SMS;
import java.util.Scanner;
// main class to check the functionality of Student Management System
public class Main {
    public static void main(String ... args){
        /** instantiate the Student Management system class that initializes the array of length 10*/
        StudentManagementSystem sms = new StudentManagementSystem();
        /** run the loop infinitely till the user says to exit it */
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("What operation you want to perform:" +
                    "\n---1. add student" +
                    "\n---2. delete student" +
                    "\n---3. search student " +
                    "\n---4. exit");
            int option; // stores the different options the user selects
            try {   // try catch to cater the exception thrown when the correct input not entered; on values other than 1,2,3,4
                option = sc.nextInt();  // ask the user for one of the four options
                if (option == 4) {
                    System.out.println("Program ended successfully");
                    sms.writeToFile();
                    System.out.println("Do you want to read the file? enter yes/no ");
                    if((sc.next().toLowerCase()).equals("yes")){
                        sms.readFromFile();
                        break;
                    }else
                        break;
                }
                if (option == 1) {  // code for adding record

                    try {
                        System.out.println("Which student you want to store in record? " +
                                "\n*enter 1 for UG " +
                                "\n*enter 2 for PG");      // does not take values other than 1 or 2
                        int input = sc.nextInt();
                        if (input == 1) {
                            try {
                                System.out.println("Enter name, CMS, semester");
                                boolean returnValue = sms.addRecord(sc.next(), sc.nextInt(), sc.nextInt(), 1);
                                if (returnValue) {
                                    System.out.println("UG Student added sucessfully");
                                }

                            } catch (OutOfMemoryException e) {    // catch exception from addRecord
                                System.out.println(e);
                            }

                        } else if (input == 2) {
                            try {
                                System.out.println("Enter name, CMS, semester");
                                boolean returnValue = sms.addRecord(sc.next(), sc.nextInt(), sc.nextInt(), 2);
                                if (returnValue) {
                                    System.out.println("PG Student added successfully");
                                }
                            } catch (OutOfMemoryException e) {    // catch exception from addRecord
                                System.out.println(e);
                            }
                        }
                    } catch (Exception e) {    // catch the exception thrown when the correct option for the student not selected// value other than 1 or 2
                        System.out.println(e);
                    }
                } else if (option == 2) {       // code for deleting the record

                    try {
                        System.out.println("Enter CMS ID for deleting the student");
                        int id = sc.nextInt();  // input the id
                        // match the student information based on the id
                        boolean returnValue = sms.deleteStudent(id);
                        if (returnValue) {
                            System.out.println("Student deleted successfully at CMS ID " + id);
                        }
                    } catch (StudentNotFoundException e) {    // catch exception from deleteStudent
                        System.out.println(e);
                    }
                } else if (option == 3) {      // search the student
                    try {
                        System.out.println("Enter CMS id for searching the student ");
                        int id = sc.nextInt();  // input the id
                        // match the information based on student id
                        sms.searchStudent(id);
                    } catch (StudentNotFoundException e) {
                        System.out.println(e);
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("\n");
        }// end while loop
    }// end main method
}
