import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {

	Account checking;

	@BeforeEach
	public void setUp() {
		checking = new Checking(10000000, 10);
	}

	@Test
	public void account_can_be_created_with_specific_APR_value() {

		double actual = checking.getAPR();

		assertEquals(10, actual);
	}

	@Test
	public void money_can_be_deposited_in_account() {
		checking.addDeposit(30);
		double actual = checking.getAmount();

		assertEquals(30, actual);
	}

	@Test
	public void money_can_be_withdrawn_from_account() {
		checking.addDeposit(30);
		checking.withdrawAmount(20);
		double actual = checking.getAmount();

		assertEquals(10, actual);
	}

	@Test
	public void balance_cannot_go_below_zero() {
		checking.addDeposit(30);
		checking.withdrawAmount(40);
		double actual = checking.getAmount();

		assertEquals(0, actual);
	}

	@Test
	public void amount_can_be_deposited_twice() {
		checking.addDeposit(30);
		checking.addDeposit(40);
		double actual = checking.getAmount();

		assertEquals(70, actual);
	}

	@Test
	public void amount_can_withdrawn_twice() {
		checking.addDeposit(100);
		checking.withdrawAmount(30);
		checking.withdrawAmount(40);
		double actual = checking.getAmount();

		assertEquals(30, actual);
	}

	@Test
	public void get_id() {

		assertEquals(10000000, checking.getID());
	}
}
