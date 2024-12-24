package com.savior.forohub.services;

import com.savior.forohub.domain.user.SignupRequest;
import com.savior.forohub.domain.user.User;
import com.savior.forohub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return user;
    }

    public void register(SignupRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(request.password());
        userRepository.save(user);
    }
}