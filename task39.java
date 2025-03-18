// Create the Employee Entity

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private double salary;

  
    public Employee() {}

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
//3. Create the Repository Layer
//The repository provides the data access layer for CRUD operations.

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
//4. Create the Service Layer
//The service layer is responsible for handling business logic.


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create or Update employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

  
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
//5. Create the Controller Layer
//The controller layer exposes RESTful APIs for the client (Postman) to interact with the system.


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create or Update employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            Employee existingEmployee = employee.get();
            existingEmployee.setName(employeeDetails.getName());
            existingEmployee.setPosition(employeeDetails.getPosition());
            existingEmployee.setSalary(employeeDetails.getSalary());
            return ResponseEntity.ok(employeeService.saveEmployee(existingEmployee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
// 6. Application Properties
// For simplicity, let's configure an H2 database (in-memory) in the application.properties file.


spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
7. Main Application Class
java
Copy code
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }
}
// 8. Test the API Using Postman
// Now you can test all the CRUD operations via Postman.

POST /api/employees: To create an employee.

URL: http://localhost:8080/api/employees
Method: POST
Body (JSON):

{
    "name": "John Doe",
    "position": "Software Engineer",
    "salary": 75000
}
GET /api/employees: To get all employees.

URL: http://localhost:8080/api/employees/{id}
Method: PUT

  
{
    "name": "John Doe Updated",
    "position": "Senior Software Engineer",
    "salary": 80000
}
