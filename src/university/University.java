package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int  getStudentCount(){
        return this.students.size();
    }

    public  String registerStudent(Student student){
        if(this.students.size()+1<=this.capacity){
            if(!this.students.contains(student)) {
                this.students.add(student);
                return "Added student" + " " + student.getFirstName() + " " + student.getLastName();
            }else{
                return "Student is already in the university";
            }
        }else{
            return "No seats in the university";
        }
    }

    public  String dismissStudent(Student student){
        if(this.students.contains(student)){
            this.students.remove(student);
            return "Removed student" + " " + student.getFirstName() + " " + student.getLastName();
        }else{
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : this.students) {
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }

    public  String  getStatistics(){
        StringBuilder sb = new StringBuilder();
        for (Student student : this.students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s", student.getFirstName(), student.getLastName(), student.getBestSubject()));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }





}
