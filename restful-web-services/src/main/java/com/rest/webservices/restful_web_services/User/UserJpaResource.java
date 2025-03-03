package com.rest.webservices.restful_web_services.User;

import com.rest.webservices.restful_web_services.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {


    private UserRepository repository;

    public UserJpaResource(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<Optional<User>> retrieveUser(@PathVariable int id){
        Optional<User> user =  repository.findById(id);
        if(user == null){
            throw new UserNotFoundException("id - " + id);
        }
        EntityModel<Optional<User>> resource = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
         repository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid  @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
