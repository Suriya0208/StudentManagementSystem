package com.example.StudentManagementSystem.usercontroller;

import com.example.StudentManagementSystem.exception.ResourceNotFoundException;
import com.example.StudentManagementSystem.userentity.UserEntity;
import com.example.StudentManagementSystem.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/details")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getAllStudent(){
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity addStudent(@RequestBody UserEntity userEntity){
      return userRepository.save(userEntity);

    }
    
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable int id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with this id: " + id));
    }
}
