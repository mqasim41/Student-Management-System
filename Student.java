package com.SMS;
// blue print for a Student
public class Student {
    private String name;
    private int CMSID;
    Student(String name, int CMSID){
        this.name = name;
        this.CMSID = CMSID;
    }
    public String getName(){return name;}
    public int getCMSID(){return CMSID;}
}
class UGStudent extends Student{
    private int UGsem;
    UGStudent(String name, int CMSID, int UGsem){
        super(name, CMSID);
        this.UGsem = UGsem;
    }
    public int getUGsem(){return UGsem;}
}
class PGStudent extends Student{
    private int PGsem;
    PGStudent(String name, int CMSID, int PGsem){
        super(name, CMSID);
        this.PGsem = PGsem;
    }
    public int getPGsem(){return PGsem;}
}
