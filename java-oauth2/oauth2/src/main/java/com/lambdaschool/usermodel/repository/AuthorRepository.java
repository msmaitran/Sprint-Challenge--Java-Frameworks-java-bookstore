package com.lambdaschool.usermodel.repository;

import com.lambdaschool.usermodel.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote (bookid, authorid) VALUES (:bookid, :authorid)",
           nativeQuery = true)
    void insertIntoBookAuthors(long bookid, long authorid);
}
