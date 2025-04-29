package icet.edu.employee.repository;


import icet.edu.employee.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByName(String name);

    List<EmployeeEntity> findByDepartment(String department);

    boolean existsByEmail(String email);

    List<EmployeeEntity> findAllByOrderByNameAsc();
    List<EmployeeEntity> findAllByOrderByDepartmentAsc();
}
