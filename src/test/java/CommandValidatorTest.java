import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandValidatorTest {

	Bank bank;
	CommandValidator commandValidator;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		commandValidator = new CommandValidator(bank);
	}

	@Test
	public void valid_command_for_account_creation() {
		boolean actual = commandValidator.validate("create Checking 12345678 0.6");
		assertTrue(actual);

	}

	@Test
	public void typo_command_for_account_creation() {
		boolean actual = commandValidator.validate("crea Checking 12345678 3.5");
		assertFalse(actual);
	}

	@Test
	public void creation_command_with_all_uppercase() {
		boolean actual = commandValidator.validate("CREATE Checking 12345678 3.5");
		assertTrue(actual);
	}

	@Test
	public void valid_command_for_account_deposit() {
		bank.createSavings(12345678, 5.4);
		boolean actual = commandValidator.validate("Deposit 12345678 400");
		assertTrue(actual);
	}

	@Test
	public void valid_command_for_account_deposit_uppercase() {
		bank.createChecking(12345678, 3.5);
		boolean actual = commandValidator.validate("DEPOSIT 12345678 423");
		assertTrue(actual);
	}

	@Test
	public void invalid_deposit_command() {
		bank.createChecking(12345678, 6.4);
		boolean actual = commandValidator.validate("des 12345678 233");
		assertFalse(actual);
	}

}
