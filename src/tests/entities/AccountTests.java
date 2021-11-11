package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		double amount = 200.0;
		double expectValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
	}
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectValue = 100.00;
		Account acc = AccountFactory.createAccount(expectValue);
		double amount = -200.00;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectValue, acc.getBalance());
	}
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		double expectValue = 0.0;
		double initialBalance = 800.00;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
	
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.00);
		
		Assertions.assertEquals(300, acc.getBalance());
	}
	@Test
	public void withdrawShouldThrowExceptionsWhenInsufficientBalance() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			
			acc.withdraw(801.0);
		});
	}
}
