package application.dao;

import application.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    void insertNewStudent(UUID studentId, Student student);
    Student selectStudentById(UUID studentId);
    List<Student> selectAllStudent();
    void updateStudentById(UUID studentId, Student updateStudent);
    void deleteStudentById(UUID studentId);

}
