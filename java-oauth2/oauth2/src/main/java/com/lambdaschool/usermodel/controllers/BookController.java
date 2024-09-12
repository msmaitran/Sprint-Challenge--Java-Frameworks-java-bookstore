package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.services.BookService;
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
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "returns all Books",
                  response = Book.class,
                  responseContainer = "List")
    @GetMapping(value = "/books",
                produces = {"application/json"})
    public ResponseEntity<?> listAllBooks() {
        List<Book> myBooks = bookService.findAll();
        return new ResponseEntity<>(myBooks, HttpStatus.OK);
    }
}
