package com.marvel.Spring5WebApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ISBN;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Authors> authors  = new HashSet<>();

    public Books() {
        //JPA requires empty constructor
    }

    public Books(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Set<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Authors> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        return id == books.id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPublished='" + ISBN + '\'' +
                ", authors=" + authors +
                '}';
    }
}
