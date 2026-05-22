package com.example.StudentManagementSystem.userrepository;

import com.example.StudentManagementSystem.userentity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
