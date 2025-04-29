package icet.edu.employee.service;

import icet.edu.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void addEmployee(EmployeeDto employee);

    void updateEmployee(EmployeeDto employee);

    void deleteEmployee(Long id);

    List<EmployeeDto>  searchEmployeeByName(String name);

    List<EmployeeDto> searchEmployeeByDepartment(String department);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto searchEmployeeById(Long id);

    List<EmployeeDto> getAllEmployeesSortedByName();

    List<EmployeeDto> getAllEmployeesSortedByDepartment();

}
