package com.svj.service;

import com.svj.dto.UserRequestDTO;
import com.svj.dto.UserResponseDTO;
import com.svj.entity.User;
import com.svj.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.svj.utils.AppUtils.mapDTOToEntity;
import static com.svj.utils.AppUtils.mapEntityToDTO;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository){
        this.repository= repository;
    }

    public UserResponseDTO addNewUser(UserRequestDTO userReq){
        User user= mapDTOToEntity(userReq);
        User savedUser = repository.save(user);
        UserResponseDTO responseDTO= mapEntityToDTO(savedUser);
        return responseDTO;
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
