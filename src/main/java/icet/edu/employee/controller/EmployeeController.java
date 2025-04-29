package icet.edu.employee.controller;

import icet.edu.employee.dto.EmployeeDto;
import icet.edu.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.lang.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    final EmployeeService emService;

    @PostMapping("/add-employee")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDto employee){
        emService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created successfully");
    }

    @PutMapping("/update-employee")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody EmployeeDto employee){
        emService.updateEmployee(employee);
        return ResponseEntity.ok("Employee updated successfully");
    }

    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        emService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee deleted successfully");
    }

    @GetMapping("/search-by-id")
    public ResponseEntity<EmployeeDto> searchEmployeeById(@RequestParam(name="query") Long id){
        EmployeeDto result = emService.searchEmployeeById(id);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/search-by-name")
    public ResponseEntity<List<EmployeeDto>> searchEmployeeByName(@RequestParam(name="query") String name){
        return ResponseEntity.ok(emService.searchEmployeeByName(name));
    }


    @GetMapping("/search-by-department")
    public ResponseEntity<List<EmployeeDto>> searchEmployeeByDepartment(@RequestParam(name="query") String department){
        return ResponseEntity.ok(emService.searchEmployeeByDepartment(department));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(emService.getAllEmployee());
    }


    @GetMapping("/sorted-by-name")
    public List<EmployeeDto> getEmployeesSortedByName() {
        return emService.getAllEmployeesSortedByName();
    }


    @GetMapping("/sorted-by-department")
    public List<EmployeeDto> getEmployeesSortedByDepartment() {
        return emService.getAllEmployeesSortedByDepartment();
    }

}
