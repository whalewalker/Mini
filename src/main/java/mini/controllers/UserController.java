package mini.controllers;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.models.ApiResponse;
import mini.models.Gender;
import mini.models.User;
import mini.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value =  "get/users")
    public ResponseEntity<?> getAllUsers() throws RegisterUserException {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) throws RegisterUserException {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/category/{gender}")
    public ResponseEntity<?> getUsersByGender(@PathVariable String gender) throws RegisterUserException {
        List<User> users = userService.findUserByGender(Gender.MALE);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("users/{name}")
    public ResponseEntity<?> getUsersByEmail(@PathVariable String name) throws RegisterUserException {
        List<User> users = userService.findUserByFirstNameContaining(name);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserRegisterDTO userDetails, @PathVariable String id) throws RegisterUserException {
        User user = userService.updateUserById(id, userDetails);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/users")
    public ResponseEntity<?> deleteAllUser(){
        userService.deleteAllUser();
        return new ResponseEntity<>(new ApiResponse(true, "All user removed successfully"), HttpStatus.OK);
    }

    @DeleteMapping("delete/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) throws RegisterUserException {
        userService.deleteUserById(id);
        return new ResponseEntity<>(new ApiResponse(true, "user removed successfully"), HttpStatus.OK);
    }
}
