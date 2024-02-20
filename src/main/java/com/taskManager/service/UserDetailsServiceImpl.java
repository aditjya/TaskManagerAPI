package com.taskManager.service;

import com.taskManager.configuration.UserDetailsConfig;
import com.taskManager.model.User;
import com.taskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.taskManager.model.User.*;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public static User getUser() {
        return  new User();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByusername(username);
        return user.map(UserDetailsConfig::new)
                .orElseThrow(()-> new UsernameNotFoundException("username not found"+username));



    }

    public String addUser(User user){
         User.setUsername(userName);
        User.setPassword(PasswordEncoder.Encode(user.getPassword()));
        userRepository.save(User);
        return "User Added";
    }





}
