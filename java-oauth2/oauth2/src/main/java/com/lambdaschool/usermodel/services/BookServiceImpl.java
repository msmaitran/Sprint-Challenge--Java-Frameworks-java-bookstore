package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Book;
import com.lambdaschool.usermodel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookrepos;

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findBookById(long id) {
        return bookrepos.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public void delete(long id) {
        if (bookrepos.findById(id).isPresent()) {
            bookrepos.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Book update(Book book, long id) {
        Book currentBook = bookrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));

        if (book.getTitle() != null) {
            currentBook.setTitle(book.getTitle());
        }
        if (book.getIsbn() != null) {
            currentBook.setIsbn(book.getIsbn());
        }
        if (book.getCopy() != 0) {
            currentBook.setCopy(book.getCopy());
        }
        return bookrepos.save(currentBook);
    }
}
