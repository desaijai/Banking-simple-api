package com.mongobank.bankingSys.service.serviceImplements;

import com.mongobank.bankingSys.exception.resourceNotFound;
import com.mongobank.bankingSys.helper.idGenerator;
import com.mongobank.bankingSys.model.Bank;
import com.mongobank.bankingSys.model.accountHolder;
import com.mongobank.bankingSys.model.accountType;
import com.mongobank.bankingSys.repository.accounttRepo;
import com.mongobank.bankingSys.repository.bankRepo;
import com.mongobank.bankingSys.service.bankService;
import com.mongobank.bankingSys.service.seq_generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class bankServiceImpl implements bankService {

    @Autowired
    private seq_generator seqService;

    @Autowired
    private bankRepo repo;

    @Autowired
    private accounttRepo atrepo;

    @Override
    public Bank saveBank(Bank bank) {
        bank.setBid(idGenerator.next());
        bank.getAHolder().setUid(seqService.generator(accountHolder.ACCOUNTGENERATEID));
        bank.getAHolder().setUAccountNumber(generateAccountNumber.generatorANumber(bank.getBankName(), 1, bank.getAHolder().getUid()));

        bank.getAHolder().getAccountTypes().
                forEach((e) -> {
                    e.setAccTypeId(seqService.generator(accountType.GENERATEKEY));
                });
        return repo.save(bank);
    }

    @Override
    public List<Bank> getAllBank() {
        return repo.findAll();
    }

    @Override
    public Bank getBankById(int bid) {
        return repo.findById(bid).orElseThrow(() -> new resourceNotFound("bank", "bid", bid));
    }

    @Override
    public void deleteBank(int bid) {
        Bank bank = repo.findById(bid).orElseThrow(() -> new resourceNotFound("bank", "bid", bid));
        repo.delete(bank);
    }

    @Override
    public Bank updateBank(int bid, Bank bank) {
        Bank getBank = repo.findById(bid).orElseThrow(() -> new resourceNotFound("bank", "bid", bid));
        getBank.setBankName(bank.getBankName());
        getBank.setBranchName(bank.getBranchName());
        getBank.setAHolder(bank.getAHolder());
        repo.save(getBank);
        return getBank;
    }

    @Override
    public Page<Bank> findByPagination(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo - 1, size);
        return repo.findAll(pageable);
    }

    @Override
    public List<Bank> saveBulkBank(List<Bank> banks) {

        banks.forEach((element)->{
            element.setBid(idGenerator.next());
            element.getAHolder().setUid(seqService.generator(accountHolder.ACCOUNTGENERATEID));
            element.getAHolder().setUAccountNumber(generateAccountNumber.generatorANumber(element.getBankName(), 1, element.getAHolder().getUid()));

            element.getAHolder().getAccountTypes().
                    forEach((e) -> {
                        e.setAccTypeId(seqService.generator(accountType.GENERATEKEY));
                    });
        });

        return repo.saveAll(banks);
    }
}
