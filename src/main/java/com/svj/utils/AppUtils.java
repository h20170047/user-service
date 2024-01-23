package com.svj.utils;

import com.svj.dto.UserRequestDTO;
import com.svj.dto.UserResponseDTO;
import com.svj.entity.User;

public class AppUtils {

    public static User mapDTOToEntity(UserRequestDTO dto){
        return new User(-1, dto.getName(), dto.getEmail(), dto.getPaymentMethod(), dto.getSrcAccount(), dto.getAvailableAmount());
    }

    public static UserResponseDTO mapEntityToDTO(User entity){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(entity.getId());
        userResponseDTO.setName(entity.getName());
        userResponseDTO.setEmail(entity.getEmail());
        userResponseDTO.setPaymentMethod(entity.getPaymentMethod());
        userResponseDTO.setSrcAccount(entity.getSrcAccount());
        userResponseDTO.setAvailableAmount(entity.getAvailableAmount());
        return userResponseDTO;
    }
}
