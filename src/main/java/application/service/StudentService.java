package application.service;

import application.dao.StudentDao;
import application.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void persistNewStudent(UUID studentId, Student student){
        UUID studentUId = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentUId);
        studentDao.insertNewStudent(studentUId,student);
    }

    public Student getStudentById(UUID studentId){
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudent(){
        return studentDao.selectAllStudent();
    }

    public void updateStudentById(UUID studentId, Student updateStudent){
        updateStudent.setId(studentId);
         studentDao.updateStudentById(studentId,updateStudent);
    }

    public void deleteStudentById(UUID studentId){
        studentDao.deleteStudentById(studentId);
    }
}
