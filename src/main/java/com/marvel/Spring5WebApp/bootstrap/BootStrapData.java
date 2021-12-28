package com.marvel.Spring5WebApp.bootstrap;

import com.marvel.Spring5WebApp.model.Authors;
import com.marvel.Spring5WebApp.model.Books;
import com.marvel.Spring5WebApp.repositories.AuthorRepository;
import com.marvel.Spring5WebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started BootStrap data");
        Authors JKRowling = new Authors("JK Rowlling" , "123");
        Books secreteOdChamber = new Books("Harry Potter and Secrete of Chamber", "789");
        JKRowling.getBooks().add(secreteOdChamber);
        secreteOdChamber.getAuthors().add(JKRowling);

        authorRepository.save(JKRowling);
        bookRepository.save(secreteOdChamber);

        System.out.println("Authors added "+authorRepository.count());
        System.out.println("Books added "+ bookRepository.count());

    }
}
