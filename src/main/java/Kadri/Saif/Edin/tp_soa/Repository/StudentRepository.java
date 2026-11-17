package Kadri.Saif.Edin.tp_soa.Repository;

import Kadri.Saif.Edin.tp_soa.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}

