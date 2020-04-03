package application.dao;

import application.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID s_id = UUID.randomUUID();
        database.put(s_id,new Student(s_id,21,"Yusif","Memmedov","Computer Science"));
    }

    @Override
    public void insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        Student student = database.get(studentId);
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void updateStudentById(UUID studentId, Student updateStudent) {
        database.put(studentId, updateStudent);
    }

    @Override
    public void deleteStudentById(UUID studentId) {
        database.remove(studentId);
    }
}
