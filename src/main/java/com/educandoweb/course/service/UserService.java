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

    public void delete (Long id){
        userRepository.deleteById(id);
    }


    public  User update(Long id, User obj){

        User entity= userRepository.getReferenceById(id);//getReferenceById instancia o usuario, mais não vai no BD ainda, ele vai deixar apenas o objeto monitorado pelo o JPA
                                                        //para eu trabalhar com ele , e em seguida eu posso efetuar alguma operação com o BD, melhor que usar o findById
                                                        //o findById necessariamente vai no BD e tras o objeto o getReferenceById só prepara o objeto

        //função criada
        updateData(entity, obj);
        return userRepository.save(entity);



    }

    //atualizar dados
    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }


}
