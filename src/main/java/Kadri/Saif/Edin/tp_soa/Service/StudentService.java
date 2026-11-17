
package Kadri.Saif.Edin.tp_soa.Service;

import Kadri.Saif.Edin.tp_soa.Entity.StudentEntity;
import Kadri.Saif.Edin.tp_soa.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET: récupérer tous les étudiants
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET: récupérer un étudiant par son ID
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
    }

    // POST: ajouter un étudiant
    public StudentEntity addStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    // PUT: modifier toutes les informations de l'étudiant
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        StudentEntity existing = getStudentById(id);

        existing.setNom(student.getNom());
        existing.setPrenom(student.getPrenom());
        existing.setAge(student.getAge());

        return studentRepository.save(existing);
    }

    // PATCH: modifier uniquement les champs fournis
    public StudentEntity patchStudent(Long id, StudentEntity student) {
        StudentEntity existing = getStudentById(id);

        if (student.getNom() != null) {
            existing.setNom(student.getNom());
        }

        if (student.getPrenom() != null) {
            existing.setPrenom(student.getPrenom());
        }

        if (student.getAge() != null) {
            existing.setAge(student.getAge());
        }

        return studentRepository.save(existing);
    }

    // DELETE: supprimer un étudiant
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }

        studentRepository.deleteById(id);
    }
}
