package application.source;


import application.model.Student;
import application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentSource {

    private final StudentService studentService;

    @Autowired
    public StudentSource(StudentService studentService) {
        this.studentService = studentService;
    }


    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }




    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student getStudent(@PathVariable("studentId") UUID studentId){
        return studentService.getStudentById(studentId);
    }




    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String insertStudent(@RequestBody Student student){
        studentService.persistNewStudent(UUID.randomUUID(),student);
        return "Added is successfully";
    }





    @PostMapping("/update/{studentId}")
    public String updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student student){
        studentService.updateStudentById(studentId,student);
        return "Updated is successfully";
    }







    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public String deleteStudent(@PathVariable("studentId") UUID studentId){
        studentService.deleteStudentById(studentId);
        return "Deleted is successfully";
    }


}
