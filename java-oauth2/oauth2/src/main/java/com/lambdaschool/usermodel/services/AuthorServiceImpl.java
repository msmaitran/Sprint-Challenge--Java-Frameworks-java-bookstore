package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Author;
import com.lambdaschool.usermodel.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Transactional
@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Author> findAll() {
        List<Author> list = new ArrayList<>();
        authorrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Author findAuthorById(long id) {
        return authorrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }
}
