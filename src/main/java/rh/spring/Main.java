package rh.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import rh.spring.models.NewUserRequest;
import rh.spring.models.UserModel;
import rh.spring.repositories.UserRepository;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/users")
public class Main {

    private final UserRepository userRepository;

    public Main(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public void addNewUser(@RequestBody NewUserRequest newUserRequest) {
        UserModel newUser = new UserModel();
        newUser.setFirstName(newUserRequest.getFirstName());
        newUser.setLastName(newUserRequest.getLastName());
        newUser.setEmail(newUserRequest.getEmail());
        newUser.setBalance(newUserRequest.getBalance());
        userRepository.save(newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Integer id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Integer id, @RequestBody NewUserRequest newUserRequest) {
        UserModel user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "User not found";
        }
        user.setFirstName(newUserRequest.getFirstName());
        user.setLastName(newUserRequest.getLastName());
        user.setEmail(newUserRequest.getEmail());
        user.setBalance(newUserRequest.getBalance());
        userRepository.save(user);
        return "User updated";
    }

}

