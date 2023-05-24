public class DepositValidate extends CommandValidator {

	public DepositValidate(Bank bank) {
		super(bank);
	}

	@Override
	public boolean validate(String command) {
		try {

			String[] parsed_command = command.split(" ");
			int id = Integer.parseInt(parsed_command[1]);
			Account account = bank.getAccountByID(id);
			double depositAmount = Double.parseDouble(parsed_command[2]);
			return (validateID(id) && ifAccountExists(id) && account.isDepositValid(depositAmount));
		} catch (NumberFormatException n) {
			return false;
		} catch (ArrayIndexOutOfBoundsException n) {
			return false;
		}

	}

	public boolean ifAccountExists(int id) {
		return bank.getAccounts().containsKey(id);
	}

}
