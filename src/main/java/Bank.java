import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<Integer, Account> accounts;

	public Bank() {
		accounts = new HashMap<>();
	}

	public Map<Integer, Account> getAccounts() {
		return accounts;
	}

	public int getTotalAccounts() {
		return accounts.size();
	}

	public void addAccount(Account account) {
		accounts.put(account.getID(), account);
	}

	public Account getAccountByID(int accountId) {

		return accounts.get(accountId);

	}

	public void depositById(int accountID, double amountToDeposit) {
		Account account = accounts.get(accountID);
		if (account != null) {
			account.addDeposit(amountToDeposit);
		}
	}

	public void withdrawById(int accountID, double amountToWithdraw) {
		Account account = accounts.get(accountID);
		account.withdrawAmount(amountToWithdraw);
	}

	public void createChecking(int id, double apr) {
		Account account = new Checking(id, apr);
		addAccount(account);
	}

	public void createSavings(int id, double apr) {
		Account account = new Savings(id, apr);
		addAccount(account);
	}

	public void createCDaccount(int id, double apr, double depositedAmount) {
		Account account = new CDAccount(id, apr, depositedAmount);
		addAccount(account);
	}

	public boolean checkAccountExists(int id) {
		return getAccounts().containsKey(id);
	}
}
