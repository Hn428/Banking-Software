import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandProcessorTest {
	Bank bank;
	CommandProcessor commandProcessor;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		commandProcessor = new CommandProcessor(bank);
	}

	@Test
	public void command_for_account_creation() {
		boolean actual = commandProcessor.executeCommand("Create Checking 12345678 4.5");
		assertTrue(actual);
	}

	@Test
	public void command_for_account_deposit() {
		boolean actual = commandProcessor.executeCommand("Deposit 12345678 500");
		assertTrue(actual);
	}

}
