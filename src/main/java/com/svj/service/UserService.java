package com.svj.service;

import com.svj.entity.User;
import com.svj.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository= repository;
    }

    public User addNewUser(User user){
        return repository.save(user);
    }

    public User getUser(int userId){
        return repository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found with id "+userId));
    }

    public User updateAccountStatus(int userId, double usedAmount){
        User userDetailsFromDB= getUser(userId);
        userDetailsFromDB.setAvailableAmount(userDetailsFromDB.getAvailableAmount()-usedAmount);
        return repository.save(userDetailsFromDB);
    }
}
