package com.epam.services;

import com.epam.forms.UserForm;
import com.epam.models.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public interface UserService extends UserDetailsService {

    UserModel findByEmail(String email);
    UserModel save(UserForm signup);
}
