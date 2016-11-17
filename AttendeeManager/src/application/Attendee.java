package application;

import java.util.Date;

public class Attendee {

    private Date date;
    private String name;
    private String program;
    private Integer grade;
    private String alergies;
    private String email;
    private Integer phoneNum;
    private String motivation;
    private String member;

    public Attendee(Date date, String name, String program, Integer grade, String alergies, String mail, Integer phoneNum, String motivation, String member) {
        
        this.date = date;
        this.name = name;
        this.program = program;
        this.grade = grade;
        this.alergies = alergies;
        this.email = mail;
        this.phoneNum = phoneNum;
        this.motivation = motivation;
        this.member = member;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Integer phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Attendee{" + "date=" + date + ", name=" + name + ", program=" + program + ", grade=" + grade + ", alergies=" + alergies + ", mail=" + email + ", phoneNum=" + phoneNum + ", motivation=" + motivation + ", member=" + member + '}';
    }

    

}