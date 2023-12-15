package com.pragma.cuddlylamp.infrastructure.input.rest;

import com.pragma.cuddlylamp.application.dto.req.UserRequest;
import com.pragma.cuddlylamp.application.dto.res.UserResponse;
import com.pragma.cuddlylamp.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @PostMapping("/")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userHandler.saveUser(userRequest), ResponseEntity.ok().build().getStatusCode());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userHandler.getUserById(id), ResponseEntity.ok().build().getStatusCode());
    }
}
