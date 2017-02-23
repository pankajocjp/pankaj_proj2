package org.cg.training.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.cg.training.exception.InsufficientBalanceException;
import org.cg.training.exception.InvalidAccountNumberException;
import org.cg.training.vo.Account;

/**
 * Account repository implementation
 * 
 * @author njasani
 *
 */
public class AccountRepositoryImpl implements AccountRepository {

	private static Map<Long, Account> accounts = new HashMap<Long, Account>();
	 
	private static AtomicLong accountNoCounter = new AtomicLong();
	
	/**
	 * Register a new account with given account details
	 * 
	 * @return account no
	 */
	@Override
	public Long openNewAccount(Account account){
		account.setAccountNo(accountNoCounter.incrementAndGet());
		accounts.put(account.getAccountNo(), account);
		return account.getAccountNo();
	}

	/**
	 * Deposit amount to account with given account no
	 * 
	 * @throws InvalidAccountNumberException if no account found with matching account no
	 * 
	 * @return new balance
	 */
	@Override
	public double depositAmount(Long accountNo, double amount) throws InvalidAccountNumberException {
		if(!accounts.containsKey(accountNo)){
			throw new InvalidAccountNumberException();
		}
		Account account = accounts.get(accountNo);
		double balance = account.getBalance() + amount;
		account.setBalance(balance);
		return balance;
	}

	/**
	 * Withdraw amount from Account with given account no
	 * 
	 * @throws InvalidAccountNumberException if no account found with matching account no
	 * @throws InsufficientBalanceException if account balance is not enough to withdraw given amount
	 * 
	 * @return new balance
	 */
	@Override
	public double withdrawAmount(Long accountNo, double amount) throws InvalidAccountNumberException, InsufficientBalanceException {
		if(!accounts.containsKey(accountNo)){
			throw new InvalidAccountNumberException();
		}
		Account account = accounts.get(accountNo);
		double balance = account.getBalance() - amount;
		if(balance < 0){
			throw new InsufficientBalanceException();
		}
		account.setBalance(balance);
		return balance;
	}
}
