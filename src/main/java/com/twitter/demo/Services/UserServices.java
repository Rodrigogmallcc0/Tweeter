package com.twitter.demo.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.demo.entities.User;
import com.twitter.demo.repositories.IUserRepository;

@Service
public class UserServices {
    @Autowired
    private IUserRepository userRepository;

    public ArrayList<User> list() {
        return (ArrayList<User>) userRepository.findAll();

    }

    public User saveUser(User u) {
        return userRepository.save(u);
    }

    public Optional<User> getById(Long user_id) {
        return userRepository.findById(user_id);
    }

    public User update(User request, Long user_id) {
        User user = userRepository.findById(user_id).get();

        user.setUsert_handle(request.getUsert_handle());
        user.setEmail_address(request.getEmail_address());
        user.setFirst_name(request.getFirst_name());
        user.setLast_name(request.getLast_name());
        user.setPhonenumber(request.getPhonenumber());
        user.setPass(request.getPass());
        user.setEstado(request.getEstado());

        return user;

    }

    public Boolean delete(Long user_id) {
        try {
            userRepository.deleteById(user_id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
