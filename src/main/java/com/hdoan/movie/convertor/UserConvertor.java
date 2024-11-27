package com.hdoan.movie.convertor;

import com.hdoan.movie.entities.User;
import com.hdoan.movie.request.UserRequest;

public class UserConvertor {

    public static User userDtoToUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .mobileNo(userRequest.getMobileNo())
                .emailId(userRequest.getEmailId())
                .roles(userRequest.getRoles())
                .build();
        return user;
    }

}
