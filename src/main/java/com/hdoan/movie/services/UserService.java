package com.hdoan.movie.services;

import com.hdoan.movie.convertor.UserConvertor;
import com.hdoan.movie.entities.User;
import com.hdoan.movie.exceptions.UserExist;
import com.hdoan.movie.repositories.UserRepository;
import com.hdoan.movie.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(UserRequest userRequest) {
        if (userRepository.findByEmailId(userRequest.getEmailId()) != null){
            throw new UserExist();
        }

        User user = UserConvertor.userDtoToUser(userRequest);

        userRepository.save(user);
        return "User Saved Successfully";
    }
}
