package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Component
public class StudentRepository {

    Map<String,Student> studentMap = new HashMap<>();
    Map<String,Teacher> teacherMap = new HashMap<>();
    Map<Student,Teacher> studentTeacherMap = new HashMap<>();

    public void studentDetails(Student student){
        studentMap.put(student.getName(),student);
    }

    public void teacherDetails(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void studentTeacherPair(String student, String teacher){
        studentTeacherMap.put(studentMap.get(student),teacherMap.get(teacher));
    }

    public Student getStudent(String student){
        return studentMap.get(student);
    }

    public Teacher getTeacher(String teacher){
        return teacherMap.get(teacher);
    }

    public List<String > getListOfStudents(String teacher){   //List of All Students Name By Teacher Name
        List<String> listOfStudents = new ArrayList<>();
        for(Student s: studentTeacherMap.keySet()){
            if(studentTeacherMap.get(s).getName().equals(teacher))
                listOfStudents.add(s.getName());
        }
        return listOfStudents;
    }

    public List<String > getAllStudentsAdded(){                    //List of All the Students Added.
        List<String> listOfAllStudents = new ArrayList<>();
        for(Student s: studentMap.values()){
            listOfAllStudents.add(s.getName());
        }
        return listOfAllStudents;
    }

    public void deleteTeacherAndStudents(String teacher){    //Delete Teacher and All of their Students from DB

        teacherMap.remove(teacher);

        List<Student> studentName = new ArrayList<>();

        for(Student s: studentTeacherMap.keySet()){
            if(studentTeacherMap.get(s).getName().equals(teacher)) {
                studentName.add(s);
            }
        }

        for(Student i: studentName){
            studentMap.remove(i.getName());
            studentTeacherMap.remove(i);

        }

//        for(Student s: studentTeacherMap.keySet()){
//            if(studentTeacherMap.get(s).getName().equals(teacher)) {
//                studentMap.remove(s.getName());
//            }
//        }



//        for(Student s: studentTeacherMap.keySet()){
//
//            if(studentTeacherMap.get(s).getName().equals(teacher)) {
//                studentTeacherMap.remove(s);
//            }
//        }


    }

    public void deleteAllfromTeacher(){                    //Delete All the Teachers and their Students from DB

        for(Student s: studentTeacherMap.keySet()){
            studentMap.remove(s.getName());
        }

        teacherMap.clear();
        studentTeacherMap.clear();

    }


}
