package org.cg.training.repository;

import org.cg.training.exception.InsufficientBalanceException;
import org.cg.training.exception.InvalidAccountNumberException;
import org.cg.training.vo.Account;

/**
 * Provides repository operations for Account
 * 
 * @author njasani
 *
 */
public interface AccountRepository {

	Long openNewAccount(Account account);
	
	double depositAmount(Long accountNo, double amount) throws InvalidAccountNumberException;
	
	double withdrawAmount(Long accountNo, double amount) throws InvalidAccountNumberException, InsufficientBalanceException;
}
