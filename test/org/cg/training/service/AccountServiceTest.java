package org.cg.training.service;

import org.cg.training.exception.InsufficientBalanceException;
import org.cg.training.exception.InvalidAccountNumberException;
import org.cg.training.exception.InvalidAmountException;
import org.cg.training.vo.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * JUnit tests class for AccountService
 * 
 * @author njasani
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@InjectMocks AccountServiceImpl accountService = null;
	
	@Before
	public void setUp() throws Exception {
		Assert.assertNotNull(this.accountService);
	}
	
	@Test(expected = InvalidAmountException.class)
	public void checkInvalidAmountException() throws InvalidAmountException {
		Account account = new Account();
		account.setOwner("Nikhil Jasani");
		Long accountNo = this.accountService.openNewAccount(account, -9);
		Assert.assertNotEquals(0, accountNo.longValue());
	}
	
	@Test
	public void openNewAccount() throws InvalidAmountException{
		Account account = new Account();
		account.setOwner("Nikhil Jasani");
		Long accountNo = this.accountService.openNewAccount(account, 500);
		Assert.assertNotEquals(0, accountNo.longValue());
	}
	
	@Test(expected = InvalidAccountNumberException.class)
	public void checkInvalidAccountNumberException() throws InvalidAmountException, InvalidAccountNumberException{
		Account account = new Account();
		Long accountNo = this.accountService.openNewAccount(account, 500);
		Assert.assertNotEquals(0, accountNo.longValue());
		double balance = this.accountService.deposit(accountNo+1, 1000);
		Assert.assertNotEquals(1500, balance);
	}
	
	@Test
	public void depositAmount() throws InvalidAmountException, InvalidAccountNumberException{
		Account account = new Account();
		account.setOwner("Nikhil Jasani");
		Long accountNo = this.accountService.openNewAccount(account, 500);
		Assert.assertNotEquals(0, accountNo.longValue());
		double balance = this.accountService.deposit(accountNo, 1000);
		Assert.assertNotEquals(1500, balance);
	}
	
	@Test(expected=InsufficientBalanceException.class)
	public void checkInsufficientBalanceException() throws InvalidAmountException, InvalidAccountNumberException, InsufficientBalanceException{
		Account account = new Account();
		account.setOwner("Nikhil Jasani");
		Long accountNo = this.accountService.openNewAccount(account, 500);
		Assert.assertNotEquals(0, accountNo.longValue());
		double balance = this.accountService.withdraw(accountNo, 1000);
		Assert.assertNotEquals(400, balance);
	}
	
	@Test
	public void withdrawAmount() throws InvalidAmountException, InvalidAccountNumberException, InsufficientBalanceException{
		Account account = new Account();
		account.setOwner("Nikhil Jasani");
		Long accountNo = this.accountService.openNewAccount(account, 500);
		Assert.assertNotEquals(0, accountNo.longValue());
		double balance = this.accountService.withdraw(accountNo, 100);
		Assert.assertNotEquals(400, balance);
	}
}
