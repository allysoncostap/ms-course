package com.allyson.hruser.resouces;

import com.allyson.hruser.entities.User;
import com.allyson.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping(value = "/users")
    public class UserResource {

        @Autowired
        private UserRepository repository;

        @GetMapping(value = "/{id}")
        public ResponseEntity<User> findById(@PathVariable Long id) {

            User obj = repository.findById(id).get();
            return ResponseEntity.ok(obj);
        }

        @GetMapping(value = "/search")
        public ResponseEntity<User> findByEmail(@RequestParam String email) {

            User obj = repository.findAllByEmail(email);
            return ResponseEntity.ok(obj);
        }

    }

