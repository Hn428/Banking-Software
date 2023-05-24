import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateAccountValidatorTest {
	CreateAccountValidator createAccountValidator;
	Bank bank;

	@BeforeEach
	public void setUp() {

		bank = new Bank();
		createAccountValidator = new CreateAccountValidator(bank);
	}

	@Test
	public void valid_command_for_account_creation() {
		boolean actual = createAccountValidator.validate("Create Checking 12345678 0.6");
		assertTrue(actual);
	}

	@Test
	public void account_created_with_invalid_id() {
		boolean actual = createAccountValidator.validate("Create Savings 12345adv 0.6");
		assertFalse(actual);
	}

	@Test
	public void account_created_with_less_than_eight_digit_id() {
		boolean actual = createAccountValidator.validate("Create Savings 1234567 5");
		assertFalse(actual);

	}

	@Test
	public void account_created_with_more_than_eight_digits() {
		boolean actual = createAccountValidator.validate("Create CD 1234566674 4 3.45");
		assertFalse(actual);
	}

	@Test
	public void account_created_with_negative_account_id() {
		boolean actual = createAccountValidator.validate("Create Savings -12343567 4.3");
		assertFalse(actual);
	}

	@Test
	public void account_created_with_no_id() {
		boolean actual = createAccountValidator.validate("Create Checking  3");
		assertFalse(actual);
	}

	@Test
	public void checking_account_created_with_duplicate_id() {
		bank.createChecking(12345678, 4.5);
		boolean actual = createAccountValidator.validate("Create Checking 12345678 4.3");
		assertFalse(actual);
	}

	@Test
	public void second_checking_account_created_unique_id() {
		bank.createChecking(11235233, 5.3);
		boolean actual = createAccountValidator.validate("Create Checking 51232123 6.8");
		assertTrue(actual);
	}

	@Test
	public void account_created_with_correct_apr() {
		boolean actual = createAccountValidator.validate("Create Checking 12312345 5.3");
		assertTrue(actual);
	}

	@Test
	public void account_created_with_out_of_bounds_apr() {
		boolean actual = createAccountValidator.validate("Create Savings 32324567 12.4");
		assertFalse(actual);
	}

	@Test
	public void account_created_with_negative_apr() {
		boolean actual = createAccountValidator.validate("Create CD 12341234 -8.4 1000");
		assertFalse(actual);
	}

	@Test
	public void account_created_with_typo_apr() {
		boolean actual = createAccountValidator.validate("Create Checking 12312345 4q");
		assertFalse(actual);
	}

	@Test
	public void account_created_with_0_apr() {
		boolean actual = createAccountValidator.validate("Create Checking 12345678 0");
		assertTrue(actual);
	}

	@Test
	public void account_created_with_misspelled_type() {
		boolean actual = createAccountValidator.validate("Create Checing 12345678 5.6");
		assertFalse(actual);

	}

}
