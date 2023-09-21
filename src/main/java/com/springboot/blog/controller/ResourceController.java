package com.springboot.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/resource")
public class ResourceController {

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> checkResource(){
        return ResponseEntity.status(HttpStatus.OK).body("Auth with token is working");
    }
}
