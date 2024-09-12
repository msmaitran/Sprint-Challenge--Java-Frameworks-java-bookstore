package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.usermodel.logging.Loggable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "book")
@ApiModel(value = "Book",
          description = "Book Entity")
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ApiModelProperty(name = "booktitle",
                      value = "The title of the book",
                      required = true,
                      example = "Android")
    @Column(nullable = false)
    private String title;

    @ApiModelProperty(name = "ISBN",
                      value = "The ISBN number of the book",
                      example = "123456789")
    @Column(nullable = false,
            unique = true)
    private String isbn;

    @ApiModelProperty(name = "copy",
                      value = "The year the book was published (copyright date)",
                      example = "2011")
    private int copy;

    @ApiModelProperty(name = "bookauthors",
                      value = "List of book authors")
    @OneToMany(mappedBy = "book",
               cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<Wrote> wrote = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    public Book() {
    }

    public Book(String title, String isbn, List<Wrote> wrote) {
        this.title = title;
        this.isbn = isbn;

        for (Wrote w : wrote) {
            w.setBook(this);
        }
        this.wrote = wrote;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<Wrote> getWrote() {
        return wrote;
    }

    public void setWrote(List<Wrote> wrote) {
        this.wrote = wrote;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
