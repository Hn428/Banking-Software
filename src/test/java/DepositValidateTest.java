import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositValidateTest {

	DepositValidate depositValidate;
	Bank bank;

	@BeforeEach
	public void setUp() {
		bank = new Bank();
		depositValidate = new DepositValidate(bank);
	}

	@Test
	public void deposit_command_without_an_account_created() {
		boolean actual = depositValidate.validate("Deposit 123456789 1000");
		assertFalse(actual);
	}

	@Test
	public void check_if_account_exists_with_the_id() {
		bank.createChecking(12345678, 4.5);

		boolean actual = depositValidate.validate("Deposit 12345678 1000");
		assertTrue(actual);

	}

	@Test
	public void deposit_more_than_allowed_amount_in_checking() {
		bank.createChecking(11231532, 4.6);
		boolean actual = depositValidate.validate("Deposit 11231532 3000");
		assertFalse(actual);
	}

	@Test
	public void deposit_more_than_allowed_amount_in_savings() {
		bank.createSavings(14423563, 3.6);
		boolean actual = depositValidate.validate("Deposit 14423563 3456.6");
		assertFalse(actual);
	}

	@Test
	public void deposit_0_in_account() {
		bank.createChecking(12345612, 4.5);
		boolean actual = depositValidate.validate("Deposit 12345612 0");
		assertTrue(actual);

	}

	@Test
	public void money_cannot_be_deposited_in_CD_account() {
		bank.createCDaccount(12345678, 4.6, 1000);
		boolean actual = depositValidate.validate("Deposit 12345678 1000");
		assertFalse(actual);
	}

	@Test
	public void negative_amount_cannot_be_deposited() {
		bank.createSavings(12345678, 3.5);
		boolean actual = depositValidate.validate("Deposit 12345678 -847");
		assertFalse(actual);
	}

	@Test
	public void deposit_amount_with_invalid_id() {
		bank.createChecking(12345612, 4.5);
		boolean actual = depositValidate.validate("Deposit 123456db 456");
		assertFalse(actual);

	}

	@Test
	public void deposit_amount_with_invalid_amount_value() {
		bank.createSavings(12341234, 4.5);
		boolean actual = depositValidate.validate("Deposit 12341234 3a");
		assertFalse(actual);
	}

	@Test
	public void deposit_amount_with_typo() {
		bank.createChecking(12341234, 5.5);
		boolean actual = depositValidate.validate("erjeikj");
		assertFalse(actual);
	}

}
