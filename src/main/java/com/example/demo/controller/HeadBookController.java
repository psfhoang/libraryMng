package com.example.demo.controller;

import com.example.demo.entity.HeadBook;
import com.example.demo.entityResponse.EntityResponse;
import com.example.demo.service.HeadBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class HeadBookController {
    @Autowired
    HeadBookService headBookService;
    @RequestMapping(value = "/head-book/add", method = RequestMethod.POST)
    public EntityResponse addBook(@RequestBody HeadBook headBook) {
        return new EntityResponse(HttpStatus.OK,new Timestamp(System.currentTimeMillis()),"Add Success", headBookService.addHeadBook(headBook));
    }
    @RequestMapping(value = "/head-book/get-all",method = RequestMethod.GET)
    public EntityResponse getAll(){
        return new EntityResponse(HttpStatus.OK,new Timestamp(System.currentTimeMillis()),"Success",headBookService.getAllHeadBook());
    }
    @RequestMapping(value = "/head-book/find-by-id/{id}",method = RequestMethod.GET)
    public EntityResponse getById(@PathVariable(name = "id") Long id){
        return new EntityResponse(HttpStatus.OK,new Timestamp(System.currentTimeMillis()),"Success",headBookService.findHeadBookById(id));
    }
    @RequestMapping(value = "/head-book/find-by-name/{name}",method = RequestMethod.GET)
    public EntityResponse getByName(@PathVariable(name = "name") String name){
        return new EntityResponse(HttpStatus.OK,new Timestamp(System.currentTimeMillis()),"Success",headBookService.findByName(name));
    }
    @RequestMapping(value = "/head-book/update", method = RequestMethod.PUT)
    public EntityResponse updateBook(@RequestBody HeadBook headBook) {
        return new EntityResponse(HttpStatus.OK,new Timestamp(System.currentTimeMillis()),"Update Success", headBookService.updateHeadBook(headBook));
    }
    @RequestMapping(value = "/head-book/delete/{id}",method = RequestMethod.DELETE)
    public EntityResponse deleteById(@PathVariable(name = "id") Long id){
        return new EntityResponse(HttpStatus.OK,new Timestamp(System.currentTimeMillis()),"Delete Success",headBookService.deleteHeadBookById(id));
    }
}


