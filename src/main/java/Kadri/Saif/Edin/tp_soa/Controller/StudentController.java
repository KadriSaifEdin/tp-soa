
package Kadri.Saif.Edin.tp_soa.Controller;

import Kadri.Saif.Edin.tp_soa.Entity.StudentEntity;
import Kadri.Saif.Edin.tp_soa.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    // POST: ajouter un étudiant
    @PostMapping
    public StudentEntity addStudent(
            @RequestBody StudentEntity student) {
        return studentService.addStudent(student);
    }

    // PUT: modifier toutes les informations
    // d'un étudiant
    @PutMapping("/{id}")
    public StudentEntity updateStudent(
            @PathVariable Long id,
            @RequestBody StudentEntity student) {
        return studentService.updateStudent(id, student);
    }

    // PATCH: modifier certains champs
    @PatchMapping("/{id}")
    public StudentEntity patchStudent(
            @PathVariable Long id,
            @RequestBody StudentEntity student) {
        return studentService.patchStudent(id, student);
    }

    // DELETE: supprimer un étudiant
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    // HEAD: mêmes headers que GET, sans body
    @RequestMapping(method = RequestMethod.HEAD)
    public List<StudentEntity> headStudents() {
        return studentService.getAllStudents();
    }
}
