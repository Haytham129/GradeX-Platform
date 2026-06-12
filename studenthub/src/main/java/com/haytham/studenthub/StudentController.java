package com.haytham.studenthub;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentRepository repo;

@GetMapping
public List<Student> getAll(){
    return repo.findAll();
}
@PostMapping
public Student addStudent(@RequestBody Student student){

    student.calculateGpa(student.getPoints(), student.getHours());


    return repo.save(student);


}
// مسح كل الطلاب من السجل
    @DeleteMapping
    public void deleteAllStudents() {
        repo.deleteAll();
    }
}
