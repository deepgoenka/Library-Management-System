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
import com.xfactor.openlibrary.domain.Publisher;
import com.xfactor.openlibrary.repository.PublisherRepository;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    // ArrayList <Publisher> publish = new ArrayList<>();

    private PublisherRepository publisherRepository;
    
    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PostMapping("/savePublisher")
    public Publisher savePublisher(@RequestBody Publisher pub) {
        publisherRepository.save(pub);
        return pub;
    }

    @GetMapping("/getAllPublisher")
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @GetMapping("/getPublisherById/{id}")
    public Publisher findById(@PathVariable Long id) {
        Optional<Publisher> optionalOfPublisher = publisherRepository.findById(id);
        if (optionalOfPublisher.isPresent()){
            return optionalOfPublisher.get();
        }
        return null;
    }

    @GetMapping("/getPublisherByName/{name}")
    public List<Publisher> findByName(@PathVariable String name) {
        List<Publisher> listOfPublisherByName = publisherRepository.findAll();
        return listOfPublisherByName;
    }

    @GetMapping("/getPublisherByAddress/{address}")
    public List<Publisher> findByAddress(@PathVariable String address) {
        List<Publisher> listOfPublisherByAddress = publisherRepository.findByAddress(address);
        return listOfPublisherByAddress;
    }

    @GetMapping("/getPublisherByPhone/{phone}")
    public List<Publisher> findByPhone(@PathVariable String phone) {
        List<Publisher> listOfPublisherByPhone = publisherRepository.findByPhone(phone);
        return listOfPublisherByPhone;
    }

    @GetMapping("/getPublisherByEmail/{email}")
    public List<Publisher> findByEmail(@PathVariable String email) {
        List<Publisher> listOfPublisherByEmail = publisherRepository.findByEmail(email);
        return listOfPublisherByEmail;
    }

    @PutMapping("/updatePublisher")
    public Publisher updatePublisher (@RequestBody Publisher publisher) {
        if (publisher.getId() != null){
            Publisher updatedPublisher = publisherRepository.save(publisher);
            return updatedPublisher;
        }
        return null;
    }

    @DeleteMapping("deletePublisher/{id}")
    public void deletePublisher (@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }

}
