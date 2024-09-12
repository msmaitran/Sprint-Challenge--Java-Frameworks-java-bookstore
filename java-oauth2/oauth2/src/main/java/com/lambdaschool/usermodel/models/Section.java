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
@Table(name = "section")
@ApiModel(value = "Section", description = "Section Entity")
public class Section extends Auditable {

    @ApiModelProperty(name = "sectionid",
                      value = "Primary key for section",
                      required = true,
                      example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @ApiModelProperty(name = "sectionname",
                      value = "Name of section",
                      required = true,
                      example = "Fiction")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("sections")
    private List<Book> book = new ArrayList<>();

    public Section() {
    }

    public Section(String name, List<Book> book) {
        this.name = name;
        this.book = book;
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Section(" + "ID: " + sectionid + ", Name: " + name + ", Book: " + book + ")";
    }
}
