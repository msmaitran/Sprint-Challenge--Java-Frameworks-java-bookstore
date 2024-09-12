package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.services.AuthorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Loggable
@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @ApiOperation(value = "returns all Authors",
                  response = Author.class,
                  responseContainer = "List")
    @GetMapping(value = "/authors",
                produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors() {
        List<Author> myAuthors = authorService.findAll();
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }
}
