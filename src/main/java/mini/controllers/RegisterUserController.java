package mini.controllers;

import mini.dtos.UserRegisterDTO;
import mini.exceptions.RegisterUserException;
import mini.models.ApiResponse;
import mini.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegisterUserController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody UserRegisterDTO userRegisterDTO){
        try {
            registerService.registerUser(userRegisterDTO);
        } catch (RegisterUserException e) {
            e.getMessage();
        }
        return new ResponseEntity<>(new ApiResponse(true, "Product created successfully"), HttpStatus.CREATED);
    }
}
