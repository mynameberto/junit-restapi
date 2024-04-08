package br.com.bertasso.junitrestapi.controller;


import br.com.bertasso.junitrestapi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping(value="/id")
    public ResponseEntity<User> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(new User(1, "Valdir", "pedro@pedro.com", "12"));
    }
}
