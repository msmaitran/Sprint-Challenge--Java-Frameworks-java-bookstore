package com.lambdaschool.usermodel.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lname;
    private String fname;

    @OneToMany(mappedBy = "author",
               cascade = CascadeType.ALL)
    @JsonIgnoreProperties("author")
    private List<Wrote> wrote = new ArrayList<>();

    public Author() {
    }

    public Author(String lname, String fname) {
        this.lname = lname;
        this.fname = fname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public List<Wrote> getWrote() {
        return wrote;
    }

    public void setWrote(List<Wrote> wrote) {
        this.wrote = wrote;
    }
}
