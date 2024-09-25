package com.ravionics.internship.service;

import com.ravionics.internship.exception.UnAuthorizedAccessException;
import com.ravionics.internship.models.User;
import com.ravionics.internship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String userName, String password) {
        User user = userRepository.getByUsernameAndPassword(userName, password);
        if(user==null)
            throw new UnAuthorizedAccessException(userName,"Username or password does not match");
        return user;
    }
}
