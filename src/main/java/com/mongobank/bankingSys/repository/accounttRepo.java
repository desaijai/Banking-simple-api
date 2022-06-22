package com.mongobank.bankingSys.repository;

import com.mongobank.bankingSys.model.Bank;
import com.mongobank.bankingSys.model.accountType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface accounttRepo extends MongoRepository<accountType, Integer> {

}
