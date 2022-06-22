package com.mongobank.bankingSys.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "accountHolder")
public class accountHolder {

    @Persistent
    public static final String ACCOUNTGENERATEID="ACCOUNT_HOLDER";

    @Id
    private int uid;
    private String uname;
    private String uAccountNumber;

    private List<accountType> accountTypes;

}
