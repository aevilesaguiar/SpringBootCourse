package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @GetMapping
    public ResponseEntity<User> findAll(){

        User u = new User(1L,"Maria","maria@mail.com","1199999-5656","a12345");
        return ResponseEntity.ok().body(u);

    }


}
