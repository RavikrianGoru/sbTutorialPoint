package com.rk.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rk.springboot.model.Account;
import com.rk.springboot.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/add/account", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public Account createAccount(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("amount") Double amount) {
		Account obj = accountService.add(id, name, amount);
		return obj;
	}

	@RequestMapping(value = "/delete/account", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public Account deleteAccount(@RequestParam("id") Integer id) {
		Account obj = accountService.delete(id);
		return obj;
	}

	@RequestMapping(value = "/checkbalance/account", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public Double checkBalance(@RequestParam("id") Integer id) {
		Double balance = accountService.getBalance(id);
		return balance;
	}
	@RequestMapping(value = "/count/account", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public Integer checkBalance() {
		Integer count = accountService.getNumberOfRecods();
		return count;
	}
}
