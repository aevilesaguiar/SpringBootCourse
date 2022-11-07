package com.educandoweb.course.service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //dependencia
    @Autowired
    private UserRepository userRepository;

    public List<User>  findAll(){

        return  userRepository.findAll();
    }

    public  User findById(Long id){
        Optional<User> obj =userRepository.findById(id);
        return obj.get();//a operação get retorna um obj tipo user que estiver do Optional

    }

    //inserir no BD um novo objeto do tipo User
    public User insert(User obj){
       return userRepository.save(obj);
    }



}
