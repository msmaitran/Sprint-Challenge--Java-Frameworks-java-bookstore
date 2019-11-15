package com.lambdaschool.usermodel.controllers;

import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.models.ErrorDetail;
import com.lambdaschool.usermodel.repository.AuthorRepository;
import com.lambdaschool.usermodel.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Loggable
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private AuthorRepository authorrepos;

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Update an existing book",
                  response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Successfully Updated", response = void.class),
            @ApiResponse(code = 404, message = "Book Not Found", response = ErrorDetail.class)
    })
    @PutMapping(value = "/books/{bookid}")
    public ResponseEntity<?> updateBook(@RequestBody Book updateBook,
                                        @PathVariable long bookid) {
        bookService.update(updateBook, bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Assign a book to an author",
                  response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Successfully Assigned", response = void.class),
            @ApiResponse(code = 404, message = "Book or Author Not Found", response = ErrorDetail.class)
    })
    @PostMapping(value = "/books/{bookid}/authors/{authorid}",
                 produces = {"application/json"})
    public ResponseEntity<?> assignBookToAuthor(@PathVariable long bookid,
                                                @PathVariable long authorid) {
        authorrepos.insertIntoBookAuthors(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an existing book",
                  response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Successfully Deleted", response = void.class),
            @ApiResponse(code = 404, message = "Book Not Found", response = ErrorDetail.class)
    })
    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<?> deleteBookById(@PathVariable long bookid) {
        bookService.delete(bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
