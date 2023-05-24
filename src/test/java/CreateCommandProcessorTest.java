import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateCommandProcessorTest {
	Bank bank;
	CreateCommandProcessor createCommandProcessor;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		createCommandProcessor = new CreateCommandProcessor(bank);

	}

	@Test
	public void create_checking_account() {
		boolean actual = createCommandProcessor.executeCommand("Create Checking 12345678 5.6");
		assertTrue(actual);

	}

	@Test
	public void create_saving_account() {
		boolean actual = createCommandProcessor.executeCommand("Create Savings 12312345 4.6");
		assertTrue(actual);
	}

	@Test
	public void create_cd_account() {
		boolean actual = createCommandProcessor.executeCommand("Create CD 12345123 4.1 1000");
		assertTrue(actual);
	}

}
