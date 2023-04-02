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
import com.xfactor.openlibrary.domain.Book;
import com.xfactor.openlibrary.repository.BookRepository;

@RestController
@RequestMapping("books")
public class BookController {
    
    private BookRepository bookRepository;
    
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/getBookById/{id}")
    public Book findById(@PathVariable Long id){
        Optional<Book> optionalOfBook = bookRepository.findById(id);
        if (optionalOfBook.isPresent()){
            return optionalOfBook.get();
        }
        return null;
    }

    @GetMapping("/getBookByTitleAndIsbn/{title}/{isbn}")
    public List<Book> findByTitleAndIsbn(@PathVariable String title, @PathVariable String isbn){
        List<Book> listOfBooksByTitleAndIsbn = bookRepository.findByTitleAndIsbn(title, isbn);
        return listOfBooksByTitleAndIsbn;
    }

    @GetMapping("/getBookByTitle/{title}")
    public List<Book> findByTitle(@PathVariable String title){
        List<Book> listOfBooksByTitle = bookRepository.findByTitle(title);
        return listOfBooksByTitle;
    }

    @GetMapping("/getBookByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable String author){
        List<Book> listOfBooksByAuthor = bookRepository.findByAuthor(author);
        return listOfBooksByAuthor;
    }

    @GetMapping("/getBookByIsbn/{isbn}")
    public List<Book> findByIsbn(@PathVariable String isbn){
        List<Book> listOfBooksByIsbn = bookRepository.findByIsbn(isbn);
        return listOfBooksByIsbn;
    }

    @GetMapping("/getBookByPublicationDate/{publicationDate}")
    public List<Book> findByPublicationDate(@PathVariable String publicationDate){
        List<Book> listOfBooksByPublicationDate = bookRepository.findByPublicationDate(publicationDate);
        return listOfBooksByPublicationDate;
    }

    @GetMapping("/getBookByPublisher/{publisher}")
    public List<Book> findByPublisher(@PathVariable String publisher){
        List<Book> listOfBooksByPublisher = bookRepository.findByPublisher(publisher);
        return listOfBooksByPublisher;
    }

    @GetMapping("/getBookByCopies/{copies}")
    public List<Book> findByCopies(@PathVariable int copies){
        List<Book> listOfBooksByCopies = bookRepository.findByCopies(copies);
        return listOfBooksByCopies;
    }

    @GetMapping("/getBookByCategory/{category}")
    public List<Book> findByCategory(@PathVariable String category){
        List<Book> listOfBooksByCategory = bookRepository.findByCategory(category);
        return listOfBooksByCategory;
    }

    @GetMapping("/getBookByGenre/{genre}")
    public List<Book> findByGenre(@PathVariable String genre){
        List<Book> listOfBooksByGenre = bookRepository.findByGenre(genre);
        return listOfBooksByGenre;
    }

    @GetMapping("/getBookBySubgenre/{subgenre}")
    public List<Book> findBySubgenre(@PathVariable String subgenre){
        List<Book> listOfBooksBySubgenre = bookRepository.findBySubgenre(subgenre);
        return listOfBooksBySubgenre;
    }

    @PutMapping("/updateBook")
    public Book updateBook (@RequestBody Book book){
        if (book.getId()!=0L){
            Book updatedbook = bookRepository.save(book);
            return updatedbook;
        }        
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook (@PathVariable long id){
        bookRepository.deleteById(id);
    }
    
}
