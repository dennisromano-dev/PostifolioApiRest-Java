package com.apiprojeto.portifolioapirest.controller;

import com.apiprojeto.portifolioapirest.model.Usuario;
import com.apiprojeto.portifolioapirest.repository.Usuariorepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class UsuarioController {
    @Autowired
    private Usuariorepository repository;
    private Integer id;

    @GetMapping("/Users")
    public List<Usuario> getUsers() {
        return repository.findAll();

    }

    @GetMapping("/user/{username}")
    public Usuario getOne(@PathVariable("username") String username) {
        return repository.findByUsername(username);

    }

    @DeleteMapping("/{id}")
    public void delete(Integer Id) {
        id = Id;
        repository.deleteById(id);

    }

    @PostMapping()
    public void postUser(@RequestBody Usuario usuario) {
        repository.save(usuario);

    }
}
