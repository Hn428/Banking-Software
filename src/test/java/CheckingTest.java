import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingTest {
	Checking checking;

	@BeforeEach
	public void setUp() {
		checking = new Checking(10, 10000000);
	}

	@Test
	public void checking_account_has_amount_0_by_default() {
		checking = new Checking(10, 10000000);
		double actual = checking.getAmount();

		assertEquals(0, actual);
	}

}
