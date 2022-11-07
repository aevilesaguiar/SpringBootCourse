package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    //GET recuperar dados do BD

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

    //para dizer que o objeto User obj do parametro abaixo, vai chegar no modo json na hora de fazer requisição
    //e esse json vai ser desserializado para um objeto User eu uso a anottation @RequestBody
    //@RequestBody nos permite recuperar o corpo da solicitação.
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj=userService.insert(obj);
        //created espera um objeto do tipo URI, por que o padrão http quando você vai retornar um 201, e esperado que a resposta contenha um cabeçalho
        //chamado location contendo o endereço do novo recurso que você inseriu
        //no springboot temos uma forma padrão de gerar esse endereço
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri(); //toUri converte para um objeto do tipo Uri
        return ResponseEntity.created(uri).body(obj);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Long id){

        userService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
