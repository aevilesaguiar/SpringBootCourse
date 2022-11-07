package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.service.CategoryService;
import com.educandoweb.course.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);

    }

    //para que o Spring considere o path "/{id}" é necessário incluir a anotação @PathVariable
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product>  findById(@PathVariable Long id){

        Product obj = productService.findById(id);
        // retorno um ResponseEntity.ok() para indicar que teve sucesso
        //e no corpo da requisição que é o .body(obj) eu coloco o obj.
                return ResponseEntity.ok().body(obj);
    }





}
