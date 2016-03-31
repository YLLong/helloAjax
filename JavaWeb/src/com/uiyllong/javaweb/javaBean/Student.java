package com.uiyllong.javaweb.javaBean;

/**
 * Created by YLL on 2016/3/10.
 */
public class Student {

    private String studentNo;
    private String studentName;
    private String sex;
    private String birthday;
    private String nativ;
    private String nation;
    private String classNo;

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativ() {
        return nativ;
    }

    public void setNativ(String nativ) {
        this.nativ = nativ;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Student(String studentNo, String studentName, String sex, String birthday, String nativ, String nation, String classNo) {
        super();
        this.studentName = studentName;
        this.birthday = birthday;
        this.classNo = classNo;
        this.nation = nation;
        this.nativ = nativ;
        this.sex = sex;
        this.studentNo = studentNo;
    }

    public Student() {
    }
}
