package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @RequestMapping(value = "/books/show-all",method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getAllBooks(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Show all books");
        List<Book> books = bookService.getAllBook();
        return new ResponseEntity<List<Book>>(books,httpHeaders, HttpStatus.OK);
    }
    @RequestMapping(value = "/books/add",method = RequestMethod.POST)
    public ResponseEntity<Void> addBook(@RequestBody Book book){
        bookService.addBook(book);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Add books");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }


//    {
//        "name":"Giải Tích",
//            "publisher":"NXB Việt Nam",
//            "author":"Hoàng",
//            "numberOfPages":200,
//            "price":1200
//
//
//    }
//{
//    "headBookId":1,
//        "timestamp":"",
//        "note":"a",
//        "status":"còn"
//
//
//
//}

}
