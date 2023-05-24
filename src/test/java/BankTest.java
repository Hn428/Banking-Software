import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {
	static private int checkingID = 10000000;
	static private int savingsID = 10000001;

	Bank bank;
	Account account;

	@BeforeEach
	public void setUp() {
		bank = new Bank();
	}

	@Test
	public void bank_has_no_accounts() {
		double actual = bank.getTotalAccounts();
		assertEquals(0, actual);
	}

	@Test
	public void when_1_account_is_added_the_bank_has_1_account() {
		account = new Checking(10000000, 10);
		bank.addAccount(account);
		assertEquals(1, bank.getTotalAccounts());
	}

	@Test
	public void when_2_accounts_are_added_bank_has_2_accounts() {
		Account account1 = new Savings(10000001, 10);
		Account account2 = new CDAccount(10000003, 10, 1000);
		bank.addAccount(account1);
		bank.addAccount(account2);
		assertEquals(2, bank.getTotalAccounts());
	}

	@Test
	public void retrieve_checking_account_type_by_account_id() {
		account = new Checking(checkingID, 10);
		int accountId = account.getID();
		bank.addAccount(account);

		assertEquals(account, bank.getAccountByID(accountId));
	}

	@Test
	public void deposit_money_into_account_by_id() {
		account = new Checking(checkingID, 10);
		bank.addAccount(account);
		bank.depositById(checkingID, 500);
		assertEquals(500, account.getAmount());
	}

	@Test
	public void withdraw_money_from_account_by_id() {
		account = new Savings(savingsID, 10);
		bank.addAccount(account);
		bank.depositById(savingsID, 1000);
		bank.withdrawById(savingsID, 500);
		assertEquals(500, account.getAmount());
	}

	@Test
	public void deposit_money_twice_into_acount() {
		account = new Checking(checkingID, 10);
		bank.addAccount(account);
		bank.depositById(checkingID, 500);
		bank.depositById(checkingID, 400);
		assertEquals(900, account.getAmount());
	}

	@Test
	public void withdrawing_money_twice_from_account() {
		account = new Checking(checkingID, 10);
		bank.addAccount(account);
		bank.depositById(checkingID, 1000);
		bank.withdrawById(checkingID, 300);
		bank.withdrawById(checkingID, 200);
		assertEquals(500, account.getAmount());
	}

}
