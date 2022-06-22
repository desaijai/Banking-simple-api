package com.mongobank.bankingSys.repository;

import com.mongobank.bankingSys.model.accountHolder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface accountholderRepo extends MongoRepository<accountHolder,Integer> {

}
