package com.marvel.Spring5WebApp.repositories;

import com.marvel.Spring5WebApp.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {
    //What crud repository do is it provides implementation of basic usual queries such as save, put,
    // deleteById, deleteListOfId, deleteAll which eases the work of developer and reduces the boilerplate
    // code.
}
