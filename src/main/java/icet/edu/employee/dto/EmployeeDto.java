package icet.edu.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
     private Long EId;
     private String name;
     private String email;
     private String department;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;
}
