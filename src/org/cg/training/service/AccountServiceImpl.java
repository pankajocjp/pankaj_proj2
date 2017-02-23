package org.cg.training.service;

import org.cg.training.exception.InsufficientBalanceException;
import org.cg.training.exception.InvalidAccountNumberException;
import org.cg.training.exception.InvalidAmountException;
import org.cg.training.repository.AccountRepository;
import org.cg.training.repository.AccountRepositoryImpl;
import org.cg.training.vo.Account;

/**
 * Implementation of AccountService
 * 
 * @author njasani
 *
 */
public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository = null;
	
	public AccountServiceImpl(){
		this.accountRepository = new AccountRepositoryImpl();
	}
	
	@Override
	public double deposit(long accountNo, double amount) throws InvalidAccountNumberException, InvalidAmountException {
		if(amount < 0){
			throw new InvalidAmountException();
		}
		return this.accountRepository.depositAmount(accountNo, amount);
	}

	@Override
	public double withdraw(long accountNo, double amount) throws InvalidAccountNumberException, InvalidAmountException, InsufficientBalanceException {
		if(amount < 0){
			throw new InvalidAmountException();
		}
		return this.accountRepository.withdrawAmount(accountNo, amount);
	}

	@Override
	public Long openNewAccount(Account account, double initialDeposit)
			throws InvalidAmountException{
		Long accountNo = this.accountRepository.openNewAccount(account);
		if(initialDeposit < 0){
			throw new InvalidAmountException("Invalid initial deposit amount. Account is open with 0 balance");
		}
		try {
			this.accountRepository.depositAmount(accountNo, initialDeposit);
		} catch (InvalidAccountNumberException e) {
			// Unlikely scenario
			e.printStackTrace();
		}
		return accountNo;
	}
}
