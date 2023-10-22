package com.SMS;

// generalized Class for a Student
public class Student {
    
    private String name;
    private int cmsId;
    /**
     * Student class Constructor.
     * 
     * @param name
     *            Student name. Does not need to be unique.
     * @param cmsId
     *            Unique ID for identification.
     *  
     */
    Student(String name, int cmsId){
        this.name = name;
        this.cmsId = cmsId;
    }
    /**
     * Getter method for the name of the student.
     * 
     * @return name of the student.
     *            
     */
    public String getName(){return name;}
     /**
     * Getter method for the CmsID of the student.
     * 
     * @return unique ID of the student
     *            
     */
    public int getCmsId(){return cmsId;}
}

// UG Student
class UGStudent extends Student{
    private int UGsem;
    /**
     * UGStudent class Constructor.
     * 
     * @param name
     *            Student name. Does not need to be unique.
     * @param cmsId
     *            Unique ID for identification of the student.
     * @param UGsem
     *            Semester number of the student.
     *  
     */
    UGStudent(String name, int cmsId, int UGsem){
        super(name, cmsId);
        this.UGsem = UGsem;
    }
     /**
     * Getter method for the semester number of the student.
     * 
     * @return semester number of the student
     *            
     */
    public int getUGsem(){return UGsem;}
}

// PG Student
class PGStudent extends Student{
    private int PGsem;
    /**
     * PGStudent class Constructor.
     * 
     * @param name
     *            Student name. Does not need to be unique.
     * @param cmsId
     *            Unique ID for identification of the student.
     * @param UGsem
     *            Semester number of the student.
     *  
     */
    PGStudent(String name, int cmsId, int PGsem){
        super(name, cmsId);
        this.PGsem = PGsem;
    }
    /**
     * Getter method for the semester number of the student.
     * 
     * @return semester number of the student
     *            
     */
    public int getPGsem(){return PGsem;}
}
