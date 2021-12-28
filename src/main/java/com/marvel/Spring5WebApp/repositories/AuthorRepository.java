package com.marvel.Spring5WebApp.repositories;

import com.marvel.Spring5WebApp.model.Authors;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Authors, Long> {
}
