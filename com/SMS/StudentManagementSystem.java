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
    /**
     * Constructor of StudentManagementSystem class. Initialises array of Student objects.
     * Checks for existence of text file for storage.
     * 
     */
    StudentManagementSystem(){
        arrayOfStudents = new Student[NUMBER_STUDENTS];
        try{
            this.file = new Formatter("file.txt");
        } catch(FileNotFoundException exception){
            System.err.println(exception);
        }
    }
    
    /**
     * Add a student to the student record.
     * 
     * @param name
     *            Student name. Does not need to be unique.
     * @param cmsId
     *            Unique ID for identification.
     * @param semNumber
     *            Semester number which student is currently in.
     * @param studentType
     *            Student can be of two types. studentType = 2 means PostGraduate (PG)
     *            and studentType = 1 means UnderGraduate (UG).
     * @return Boolean which indicates whether a student was successfully added or not.
     * @throws OutOfMemoryException
     */
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
    
    /**
     * Delete a student from the student record.
     * 
     * @param cmsId
     *            Unique ID for identification.
     * @return Boolean which indicates whether a student was successfully deleted or not.
     * @throws StudentNotFoundException
     */
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

    /**
     * Check if a student exists in the student record. Throw an exception otherwise.
     * 
     * @param cmsId
     *            Unique ID for identification.
     * @throws StudentNotFoundException
     */
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

    /**
     * Write a student and their ID to a text file.
     */
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
    /**
     * Read from a text file and print the contents to the console.
     * 
     */
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
