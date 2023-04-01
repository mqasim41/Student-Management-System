package com.SMS;
import java.io.FileNotFoundException;
import java.util.Formatter; // formatter class allows us to read and write in the file
import java.io.File;
import java.util.Scanner;

/** adding the two methods  to read and write in the managment class */
public class StudentManagementSystem {
    /** attributes */
    private Scanner sc;
    private Formatter file;
    static int numberOfStudents = 0; // store the total number of students in management system
    private Student arrayOfStudents[];  // declare array o students
    /** constructor to initialzie the array of 10 students once the class is instantiated */
    StudentManagementSystem(){
        arrayOfStudents = new Student[10];
        try{
            this.file = new Formatter("file.txt");
        } catch(FileNotFoundException exception){
            System.err.println(exception);
        }

    }
    // add the student to record and throw exception if enough soace not available
    public boolean addRecord(String name, int CMSID, int sem, int i) throws StudentManagmentException{
        if(numberOfStudents >= 10){
            throw new StudentManagmentException("No More space available");
        }else{
            // store the student as per the last parameter received in the method
            if(i == 1){
                arrayOfStudents[numberOfStudents] = new UGStudent(name, CMSID, sem);
                numberOfStudents += 1;
            }else if (i == 2){
                arrayOfStudents[numberOfStudents] = new PGStudent(name, CMSID, sem);
                numberOfStudents += 1;
            }
        }
        return true;    // to show that student added successfully
    }
    // delete the student from record and throw exception if the student does not exist
    public boolean deleteStudent(int CMSID) throws StudentManagmentException{
        boolean bool = false;
        // loop over the array to find the CMS ID --- student searched on basis of cms id
        for(int i = 0; i < arrayOfStudents.length; i++){
            if(arrayOfStudents[i] != null) {
                if (arrayOfStudents[i].getCMSID() == CMSID) {
                    arrayOfStudents[i] = null;
                    numberOfStudents -= 1;
                    for(int j = i; j < 9; j++){
                        arrayOfStudents[j] = arrayOfStudents[j + 1];
                    }
                    bool = true;
                    break;
                }
            }
        }if (!bool){    // if student not found
            throw new StudentManagmentException("Student Not Found");
        }
        return true;
    }
    public void searchStudent(int CMSID) throws StudentManagmentException{
        boolean bool = false;
        // loop over the array to find the CMS ID --- student searched on basis of cms id
        for (int i = 0; i < 1; i++){
            if(arrayOfStudents[i] != null) {
                if (arrayOfStudents[i].getCMSID() == CMSID) {
                    System.out.println("Student found at index " + i);
                    bool = true;
                    break;
                }
            }
        }if(!bool){ // if student not found
            throw new StudentManagmentException("Student not Found ");
        }
    }// end searchStudent method

    /** methods to read and write in the file */
    public void writeToFile(){
        for (int i = 0; i < arrayOfStudents.length; i++) {
            if (arrayOfStudents[i] == null) {
                continue;
            } else {
                file.format("%s %d \n", arrayOfStudents[i].getName(), arrayOfStudents[i].getCMSID());
            }
        }// end for loop
        file.close();   // close the file
    }// end writeToFile() method
    public void readFromFile(){
        try {
            sc = new Scanner(new File("file.txt"));
        }catch(FileNotFoundException exception){
            System.err.println(exception);
        }
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }
}// end class
