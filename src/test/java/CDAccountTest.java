import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CDAccountTest {
	CDAccount cdAccount;

	@Test
	public void cd_accounts_can_only_be_created_with_a_specified_balance() {
		cdAccount = new CDAccount(10000002, 10, 500);
		double actual = cdAccount.getAmount();
		assertEquals(500, actual);

	}
}
