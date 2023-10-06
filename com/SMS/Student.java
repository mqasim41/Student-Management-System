package com.SMS;

// Generalized Class for a Student
public class Student {
    private String name;
    private int cmsId;
    Student(String name, int cmsId){
        this.name = name;
        this.cmsId = cmsId;
    }
    public String getName(){return name;}
    public int getCmsId(){return cmsId;}
}

// UG Student
class UGStudent extends Student{
    private int UGsem;
    UGStudent(String name, int cmsId, int UGsem){
        super(name, cmsId);
        this.UGsem = UGsem;
    }
    public int getUGsem(){return UGsem;}
}

// PG Student
class PGStudent extends Student{
    private int PGsem;
    PGStudent(String name, int cmsId, int PGsem){
        super(name, cmsId);
        this.PGsem = PGsem;
    }
    public int getPGsem(){return PGsem;}
}
