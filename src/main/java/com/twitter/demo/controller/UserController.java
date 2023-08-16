package com.twitter.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.demo.Services.UserServices;
import com.twitter.demo.entities.User;

@RestController
@RequestMapping("/usercontroller")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserServices uServices;

    // Get all users from the database and return as a JSON array of objects with
    // user details
    @GetMapping(value = "/getusers")
    public ArrayList<User> getAllUsers() {
        System.out.println("Getting All Users");
        return this.uServices.list();
    }

    @PostMapping(value = "/save", produces = "application/json")
    public User saveUser(@RequestBody User user) {
        return this.uServices.saveUser(user);
    }

    @GetMapping(path = "/{user_id}")
    public Optional<User> findbyid(@PathVariable("user_id") Long user_id) {

        return this.uServices.getById(user_id);
    }

    @PutMapping(path = "/update/{user_id}")
    public User update(@RequestBody User request, @PathVariable("user_id") Long user_id) {
        return this.uServices.update(request, user_id);

    }

    @DeleteMapping(path = "delete/{user_id}")
    public String delete(@PathVariable("user_id") Long user_id) {
        boolean ok = this.uServices.delete(user_id);
        if (ok) {
            return "Usuario con id" + user_id + " fue borrado";
        } else {
            return ("No se pudo eliminar el usuario con ID: " + user_id);
        }
    }

}
