package com.mongobank.bankingSys.service;

import com.mongobank.bankingSys.model.Bank;
import com.mongobank.bankingSys.model.accountType;
import org.springframework.data.domain.Page;

import java.util.List;

public interface bankService {

    //insert bank
    public Bank saveBank(Bank bank);


    //get all bank
    public List<Bank> getAllBank();

    public Bank getBankById(int bid);

    //delete bank by id
    public void deleteBank(int bid);

    public Bank updateBank(int bid,Bank bank);

    public Page<Bank> findByPagination(int pageNo,int size);

    public List<Bank> saveBulkBank(List<Bank> banks);

}
