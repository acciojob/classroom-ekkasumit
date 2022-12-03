package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.studentDetails(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.teacherDetails(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.studentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String student){
        return studentRepository.getStudent(student);
    }

    public Teacher getTeacherByName(String teacher){
        return studentRepository.getTeacher(teacher);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return studentRepository.getListOfStudents(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudentsAdded();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacherAndStudents(teacher);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllfromTeacher();
    }



}
