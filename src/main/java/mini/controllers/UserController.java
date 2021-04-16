package mini.controllers;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.models.ApiResponse;
import mini.models.Gender;
import mini.models.User;
import mini.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() throws RegisterUserException {
        List<User> users = registerService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) throws RegisterUserException {
        User user = registerService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/category/{gender}")
    public ResponseEntity<?> getUsersByGender(@PathVariable String gender) throws RegisterUserException {
        List<User> users = registerService.findUserByGender(Gender.MALE);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("users/{name}")
    public ResponseEntity<?> getUsersByEmail(@PathVariable String name) throws RegisterUserException {
        List<User> users = registerService.findUserByFirstNameContaining(name);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserRegisterDTO userDetails, @PathVariable String id) throws RegisterUserException {
        registerService.updateUserById(id, userDetails);
        return new ResponseEntity<>(new ApiResponse(true, "product updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("users")
    public ResponseEntity<?> deleteAllUser(){
        registerService.deleteAllUser();
        return new ResponseEntity<>(new ApiResponse(true, "All user removed successfully"), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) throws RegisterUserException {
        registerService.deleteUserById(id);
        return new ResponseEntity<>(new ApiResponse(true, "user removed successfully"), HttpStatus.OK);

    }
}
