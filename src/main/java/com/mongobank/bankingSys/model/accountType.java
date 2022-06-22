package com.mongobank.bankingSys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "account_Type")
public class accountType {

    @Persistent
    public static final String GENERATEKEY="ACCTYPEGENARATEID";

    @Id
    private int accTypeId;
    private String accType;
    private double balance;
    private double interestRate;

}
