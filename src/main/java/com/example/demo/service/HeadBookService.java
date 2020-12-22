package com.example.demo.service;

import com.example.demo.entity.HeadBook;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HeadBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadBookService {
    private final HeadBookRepository headBookRepository;
    @Autowired
    public HeadBookService(HeadBookRepository headBookRepository) {
        this.headBookRepository = headBookRepository;
    }

    public List<HeadBook> getAllHeadBook() {
        List<HeadBook> headBooks = headBookRepository.findAll();
        if(headBooks.isEmpty()){
            throw new ResourceNotFoundException("HeadBook is null");
        }
        return headBookRepository.findAll();
    }

    public HeadBook findHeadBookById(Long id) {
        return headBookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public List<HeadBook> findByName(String name){
        List<HeadBook> headBooks = headBookRepository.findByNameContains(name);
        if(headBooks.isEmpty()){
            throw new ResourceNotFoundException("Cannot find");
        }
        return headBookRepository.findByNameContains(name);
    }
    public List<HeadBook> findByAuthor(String name){
        List<HeadBook> headBooks = headBookRepository.findByAuthorContains(name);
        if(headBooks.isEmpty()){
            throw new ResourceNotFoundException("Cannot find");
        }
        return headBookRepository.findByAuthorContains(name);
    }
    public List<HeadBook> findByPublish(String name){
        List<HeadBook> headBooks = headBookRepository.findByPublisherContains(name);
        if(headBooks.isEmpty()){
            throw new ResourceNotFoundException("Cannot find");
        }
        return headBookRepository.findByPublisherContains(name);
    }
    public HeadBook addHeadBook(HeadBook headBook) {
        return headBookRepository.save(headBook);
    }

    public HeadBook updateHeadBook(HeadBook headBook) {
        HeadBook headBook1 =this.findHeadBookById(headBook.getId());
        headBook1.setHeadBook(headBook);
       return headBookRepository.save(headBook1);
    }
    public HeadBook deleteHeadBookById(Long id) {
        HeadBook headBook = this.findHeadBookById(id);
        headBookRepository.deleteById(id);
        return headBook;
    }

    public boolean isExist(Long id){
        return headBookRepository.findById(id).isPresent();
    }
}
