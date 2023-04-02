package com.xfactor.openlibrary.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.domain.Author;
import com.xfactor.openlibrary.repository.AuthorRepository;

@RestController
@RequestMapping("authors")
public class AuthorController {
    // ArrayList <Author> aauthor = new ArrayList<>();

    private AuthorRepository authorRepository;
    
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @PostMapping("/saveAuthor")
    public Author saveAuthor(@RequestBody Author author) {
        authorRepository.save(author);
        return author;
    }

    @GetMapping("/getAllAuthors")
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/getAuthorById/{id}")
    public Author findById (@PathVariable Long id) {
        Optional<Author> optionalOfAuthor = authorRepository.findById(id);
        if (optionalOfAuthor.isPresent()){
            return optionalOfAuthor.get();
        }
        return null;
    }

    @GetMapping("/getAuthorByName/{name}")
    public List<Author> findByName (@PathVariable String name) {
        List<Author> listOfAuthorByName = authorRepository.findByName(name);
        return listOfAuthorByName;
    }

    @GetMapping("/getAuthorByBirthDate/{birthDate}")
    public List<Author> findByBirthDate (@PathVariable String birthDate) {
        List<Author> listOfAuthorByBirthDate = authorRepository.findByBirthDate(birthDate);
        return listOfAuthorByBirthDate;
    }

    @GetMapping("/getAuthorByNationality/{nationality}")
    public List<Author> findByNationality (@PathVariable String nationality) {
        List<Author> listOfAuthorByNationality = authorRepository.findByNationality(nationality);
        return listOfAuthorByNationality;
    }

    @PutMapping("/updateAuthor")
    public Author updateAuthor (@RequestBody Author author) {
        if (author.getId() != null){
            Author updatedAuthor = authorRepository.save(author);
            return updatedAuthor;
        }
        return null;
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor (@PathVariable Long id) {
        authorRepository.deleteById(id);
    }

}
