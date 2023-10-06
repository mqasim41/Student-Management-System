package com.SMS;
// blue print for a Student
public class Student {
    private String name;
    private int cmsID;
    Student(String name, int cmsID){
        this.name = name;
        this.cmsID = cmsID;
    }
    public String getName(){return name;}
    public int getCmsId(){return cmsID;}
}
class UGStudent extends Student{
    private int UGsem;
    UGStudent(String name, int cmsID, int UGsem){
        super(name, cmsID);
        this.UGsem = UGsem;
    }
    public int getUGsem(){return UGsem;}
}
class PGStudent extends Student{
    private int PGsem;
    PGStudent(String name, int cmsID, int PGsem){
        super(name, cmsID);
        this.PGsem = PGsem;
    }
    public int getPGsem(){return PGsem;}
}
