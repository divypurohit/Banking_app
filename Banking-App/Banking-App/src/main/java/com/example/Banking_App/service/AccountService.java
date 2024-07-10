package com.example.Banking_App.service;

import com.example.Banking_App.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountdto);
    AccountDto getAccountById(Long id);
    AccountDto deopsite(Long id , double amount);
    AccountDto withdraw(Long id , double amount);
    List<AccountDto> getAllAccount();

    void deleteAccount(Long id);


}
