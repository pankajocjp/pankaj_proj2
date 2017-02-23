package org.cg.training.service;

import org.cg.training.exception.InsufficientBalanceException;
import org.cg.training.exception.InvalidAccountNumberException;
import org.cg.training.exception.InvalidAmountException;
import org.cg.training.vo.Account;

/**
 * Service provider for Account operations
 * 
 * @author njasani
 *
 */
public interface AccountService {

	Long openNewAccount(Account account, double initialDeposit) throws InvalidAmountException;
	
	double deposit(long accountNo, double amount) throws InvalidAccountNumberException, InvalidAmountException;
	
	double withdraw(long accountNo, double amount) throws InvalidAccountNumberException, InvalidAmountException, InsufficientBalanceException;
}
