package icet.edu.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
     private Long EId;
     private String name;
     private String email;
     private String department;
     private LocalDate createdAt;
     private LocalDate updatedAt;
}
