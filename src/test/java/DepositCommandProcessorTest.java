import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositCommandProcessorTest {
	Bank bank;
	DepositCommandProcessor depositCommandProcessor;

	@BeforeEach
	void setUp() {
		bank = new Bank();
		depositCommandProcessor = new DepositCommandProcessor(bank);
	}

	@Test
	public void deposit_money_in_checking_account() {
		bank.createChecking(10000000, 2.3);
		depositCommandProcessor.executeCommand("Deposit 10000000 340");
		double actual = bank.getAccounts().get(10000000).getAmount();
		assertEquals(340, actual);

	}

	@Test
	public void deposit_money_in_saving_account() {
		bank.createSavings(12345678, 6.3);
		depositCommandProcessor.executeCommand("Deposit 12345678 500");
		double amount = bank.getAccounts().get(12345678).getAmount();

		assertEquals(500, amount);
	}
}
