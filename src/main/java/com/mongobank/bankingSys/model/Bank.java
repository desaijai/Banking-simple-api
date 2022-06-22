package com.mongobank.bankingSys.model;

import com.mongobank.bankingSys.helper.idGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "bank")
public class Bank {

    @Persistent
    public static final String BANKGENERATEKEY="sequence_bank";

    @Id
    private String bid;
    private String bankName;
    private String branchName;
    private accountHolder aHolder;


}
