package com.ravionics.internship.rest;

import com.ravionics.internship.exception.UnAuthorizedAccessException;
import com.ravionics.internship.models.ErrorResponse;
import com.ravionics.internship.models.User;
import com.ravionics.internship.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginService {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public User login(String username, String password){
        return userService.authenticate(username, password);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnAuthorizedAccessException.class)
    public ErrorResponse handleUnAuthorizedAccess(UnAuthorizedAccessException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setErrorMessage(e.getMessage());
        errorResponse.setUserName(e.getUserName());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return errorResponse;
    }
}
