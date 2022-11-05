package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);

    }

    //para que o Spring considere o path "/{id}" é necessário incluir a anotação @PathVariable
    @GetMapping(value = "/{id}")
    public ResponseEntity<User>  findById(@PathVariable Long id){

        User obj = userService.findById(id);
        // retorno um ResponseEntity.ok() para indicar que teve sucesso
        //e no corpo da requisição que é o .body(obj) eu coloco o obj.
        return ResponseEntity.ok().body(obj);
    }





}
