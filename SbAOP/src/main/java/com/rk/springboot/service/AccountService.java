package com.rk.springboot.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.rk.springboot.model.Account;

@Service
public class AccountService {

	static HashMap<Integer, Account> accountsRepo = new HashMap<>();

	public Account add(Integer id, String name, Double balance) {
		Account a = new Account();
		a.setId(id);
		a.setName(name);
		a.setBalance(balance);
		accountsRepo.put(id, a);
		System.out.println("Created:" + accountsRepo.get(id));
		return accountsRepo.get(id);
	}

	public Account delete(Integer id) {
		Account a = accountsRepo.remove(id);
		if(Objects.nonNull(a))
			System.out.println("Deleted" + a.getId());
		return a;

	}

	public Integer getNumberOfRecods() {
		return accountsRepo.size();
	}

	public Double getBalance(Integer id) {
		Account obj = accountsRepo.get(id);
		if (Objects.nonNull(obj)) {
			System.out.println(id + "Account's balance is " + obj.getBalance());
			return obj.getBalance();
		} else {
			System.out.println("Account number is invalid.");
			return -1.0;
		}
	}
}
