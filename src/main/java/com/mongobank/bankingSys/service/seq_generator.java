package com.mongobank.bankingSys.service;

import com.mongobank.bankingSys.model.dbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class seq_generator {

    @Autowired
    MongoOperations mongoOperations;

    public int generator(String seqName){

        Query query=new Query(Criteria.where("id").is(seqName));

        Update update=new Update().inc("seqValue",1);

        dbSequence counter=mongoOperations.findAndModify(query,update,options().returnNew(true).upsert(true),dbSequence.class);

        return !Objects.isNull(counter)?counter.getSeqValue():1;
    }

}
