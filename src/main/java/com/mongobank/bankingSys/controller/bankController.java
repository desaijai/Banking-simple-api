package com.mongobank.bankingSys.controller;

import com.mongobank.bankingSys.model.Bank;
import com.mongobank.bankingSys.repository.bankRepo;
import com.mongobank.bankingSys.service.bankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
public class bankController {

    @Autowired
    bankService service;

    @Autowired
    bankRepo repo;

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<Bank> InsertBank(@RequestBody Bank bank) {
        return new ResponseEntity<>(service.saveBank(bank), HttpStatus.CREATED);
    }

    @GetMapping(produces = {"application/json"})
    public List<Bank> getAllBank() {
        return service.getAllBank();
    }

    @GetMapping(value = "{bid}", produces = {"application/json"})
    public Bank getBankById(@PathVariable("bid") int bid) {
        return service.getBankById(bid);
    }

    @DeleteMapping("{bid}")
    public ResponseEntity<String> deleteBank(@PathVariable("bid") int bid) {
        service.deleteBank(bid);
        return new ResponseEntity<>("item delete successfully!", HttpStatus.OK);
    }

    @PutMapping("{bid}")
    public ResponseEntity<Bank> updateBank(@PathVariable("bid") int bid, @RequestBody Bank bank) {
        return new ResponseEntity<>(service.updateBank(bid, bank), HttpStatus.OK);
    }

    @GetMapping("/p1")
    public List<Bank> getPageOne() {
        Pageable paging = PageRequest.of(0, 4, Sort.by("bid").ascending());
        Page<Bank> page = repo.findAll(paging);
        return page.getContent();
    }

    @GetMapping("/p2")
    public List<Bank> getPagetwo() {
        Pageable paging = PageRequest.of(1, 4, Sort.by("bid").ascending());
        Page<Bank> page = repo.findAll(paging);
        return page.getContent();
    }

    @GetMapping("/p3")
    public List<Bank> getPagethree() {
        Pageable paging = PageRequest.of(2, 4, Sort.by("bid").ascending());
        Page<Bank> page = repo.findAll(paging);
        return page.getContent();
    }

    @GetMapping("/p4")
    public List<Bank> getPagefour() {
        Pageable paging = PageRequest.of(3, 4, Sort.by("bid").ascending());
        Page<Bank> page = repo.findAll(paging);
        return page.getContent();
    }

    @GetMapping("/p5")
    public List<Bank> getPagefive() {
        Pageable paging = PageRequest.of(4, 4, Sort.by("bid").ascending());
        Page<Bank> page = repo.findAll(paging);
        return page.getContent();
    }

    @GetMapping("page/{pageNo}")
    public List<Bank> display(@PathVariable("pageNo") int pageNo){
        int pageSize=5;
        Page<Bank> page=service.findByPagination(pageNo,pageSize);
        return page.getContent();
    }

}
