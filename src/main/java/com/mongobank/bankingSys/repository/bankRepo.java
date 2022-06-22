package com.mongobank.bankingSys.repository;

import com.mongobank.bankingSys.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface bankRepo extends MongoRepository<Bank,Integer> {

}
