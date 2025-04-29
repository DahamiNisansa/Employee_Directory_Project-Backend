package icet.edu.employee.service.impl;

import icet.edu.employee.Entity.EmployeeEntity;
import icet.edu.employee.dto.EmployeeDto;
import icet.edu.employee.repository.EmployeeRepo;
import icet.edu.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepo emRepo;
    final ModelMapper mapper;

    @Override
    public void addEmployee(EmployeeDto employee) {
        if (emRepo.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        EmployeeEntity employeeEntity = mapper.map(employee, EmployeeEntity.class);
        emRepo.save(employeeEntity);
    }



    @Override
    public void updateEmployee(EmployeeDto employee) {
        EmployeeEntity existing = emRepo.findById(employee.getEId())
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));

        if (!existing.getEmail().equals(employee.getEmail()) &&
                emRepo.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());

        emRepo.save(existing);
    }



    @Override
    public void deleteEmployee(Long id) {
        if (!emRepo.existsById(id)) {
            throw new NoSuchElementException("Employee not found for deletion");
        }
        emRepo.deleteById(id);
    }



    @Override
    public EmployeeDto searchEmployeeById(Long id) {
        //return mapper.map(emRepo.findById(id), EmployeeDto.class);
        EmployeeEntity employee = emRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        return mapper.map(employee, EmployeeDto.class);
    }



    @Override
    public List<EmployeeDto> searchEmployeeByName(String name) {
        List<EmployeeEntity> emByName = emRepo.findByName(name);
        List<EmployeeDto> emListByName = new ArrayList<>();

        emByName.forEach(employeeEntity -> {
            emListByName.add(mapper.map(employeeEntity, EmployeeDto.class));
        });
        return emListByName;
    }



    @Override
    public List<EmployeeDto> searchEmployeeByDepartment(String department) {
        List<EmployeeEntity> emByDepartment = emRepo.findByDepartment(department);
        List<EmployeeDto> emListByDepartment = new ArrayList<>();

        emByDepartment.forEach(employeeEntity -> {
            emListByDepartment.add(mapper.map(employeeEntity, EmployeeDto.class));
        });
        return emListByDepartment;
    }



    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeEntity> all = emRepo.findAll();
        List<EmployeeDto> allEmployee = new ArrayList<>();

        all.forEach(employeeEntity -> {
            allEmployee.add(mapper.map(employeeEntity, EmployeeDto.class));
        });
        return allEmployee;
    }



    //for sorting by name or department
    @Override
    public List<EmployeeDto> getAllEmployeesSortedByName() {
        return emRepo.findAllByOrderByNameAsc()
                .stream()
                .map(emp -> mapper.map(emp, EmployeeDto.class))
                .toList();
    }



    @Override
    public List<EmployeeDto> getAllEmployeesSortedByDepartment() {
        return emRepo.findAllByOrderByDepartmentAsc()
                .stream()
                .map(emp -> mapper.map(emp, EmployeeDto.class))
                .toList();
    }

}
