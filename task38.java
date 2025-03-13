//Step 1: Create the User Entity Class


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

   
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
//Step 2: Create the UserRepository Interface
This will allow you to perform CRUD operations on the User entity.import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
}
Step 3: Create the UserService Class
The service layer will handle the business logic.

java
Copy
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
//Step 4: Create the UserController Class
This is the controller class that exposes the endpoint to save the user.



@RestController
public class UserController {

    @Autowired
    private UserService userService;

  
    @PostMapping("/save-user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
//Step 5: Application Properties

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
Testing
To test the endpoint, you can send a POST request to http://localhost:8080/save-user with a JSON body:

json
Copy
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
