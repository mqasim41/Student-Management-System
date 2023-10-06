package com.SMS;
import java.io.FileNotFoundException;
import java.util.Formatter; 
import java.io.File;
import java.util.Scanner;


public class StudentManagementSystem {
    
    private Scanner sc;
    private Formatter file;
    static int numberOfStudents = 0; 
    final int NUMBER_STUDENTS = 10;
    private Student arrayOfStudents[];  

    StudentManagementSystem(){
        arrayOfStudents = new Student[NUMBER_STUDENTS];
        try{
            this.file = new Formatter("file.txt");
        } catch(FileNotFoundException exception){
            System.err.println(exception);
        }
    }
    
    // add the student to record and throw exception if enough space not available
    public boolean addRecord(String name, int cmsId, int semNumber, int studentType) throws OutOfMemoryException{
        final int UG_TYPE_STUDENT_ID = 1;
        final int PG_TYPE_STUDENT_ID = 2;
        boolean studentAdded = true; 
        if(numberOfStudents >= 10){
            throw new OutOfMemoryException("No More memory available");
        } else {
            if (studentType == UG_TYPE_STUDENT_ID){
                arrayOfStudents[numberOfStudents] = new UGStudent(name, cmsId, semNumber);
                numberOfStudents += 1;
            } else if (studentType == PG_TYPE_STUDENT_ID){
                arrayOfStudents[numberOfStudents] = new PGStudent(name, cmsId, semNumber);
                numberOfStudents += 1;
            }
        }
        return studentAdded;    
    }
    
    // delete the student from record and throw exception if the student does not exist
    public boolean deleteStudent(int cmsId) throws StudentNotFoundException{
        boolean studentDeleted = false;
        for(int studentNumber = 0; studentNumber < arrayOfStudents.length; studentNumber++){
            if(arrayOfStudents[studentNumber] != null) {
                if (arrayOfStudents[studentNumber].getCmsId() == cmsId) {
                    arrayOfStudents[studentNumber] = null;
                    numberOfStudents -= 1;
                    for(int shiftStudentsArrayFromIndex = studentNumber; shiftStudentsArrayFromIndex < NUMBER_STUDENTS -1; shiftStudentsArrayFromIndex++){
                        arrayOfStudents[shiftStudentsArrayFromIndex] = arrayOfStudents[shiftStudentsArrayFromIndex + 1];
                    }
                    studentDeleted = true;
                    break;
                }
            }
        } if (!studentDeleted){    
            throw new StudentNotFoundException("Student Not Found");
        }
        return studentDeleted;
    }

    // Search for student details and throw exception if student not found
    public void searchStudent(int cmsId) throws StudentNotFoundException{
        boolean studentFound = false;
        
        for (int studentNumber = 0; studentNumber < 1; studentNumber++){
            if(arrayOfStudents[studentNumber] != null) {
                if (arrayOfStudents[studentNumber].getCmsId() == cmsId) {
                    System.out.println("Student found at student arrayindex " + studentNumber);
                    studentFound = true;
                    break;
                }
            }
        } if (!studentFound){ // if student not found
            throw new StudentNotFoundException("Student not Found ");
        }
    }

    // methods to read and write in the file
    public void writeToFile(){
        for (int studentNumber = 0; studentNumber < arrayOfStudents.length; studentNumber++) {
            if (arrayOfStudents[studentNumber] == null) {
                continue;
            } else {
                file.format("%s %d \n", arrayOfStudents[studentNumber].getName(), arrayOfStudents[studentNumber].getCmsId());
            }
        }
        file.close();   
    }

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
}
