package com.example.springjpa.User;

import com.example.springjpa.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    protected void saveUser(){

        User user = User.builder().
                email("joel@gmail.com").
                telephone(9898323342L).
                profile(
                       Profile.builder()
                               .address("Somewhere in the world").
                               first_name("Joel").
                               last_name("Itty").
                               gender("male").
                               build()
                ).
                build();

        userRepository.save(user);
    }

    protected void saveUser(User user){
        userRepository.save(user);
    }

    protected List<User> getUser(String email){
        return userRepository.findByEmail(email);
    }
}
