import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingTest {

	@Test
	public void saving_account_has_amount_0_by_default() {
		Savings savings = new Savings(10, 10000001);
		double actual = savings.getAmount();

		assertEquals(0, actual);
	}
}
