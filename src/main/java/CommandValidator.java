public class CommandValidator {
	protected Bank bank;
	protected CreateAccountValidator createAccountValidator;
	protected DepositValidate depositValidate;

	public CommandValidator(Bank bank) {
		this.bank = bank;

	}

	/*
	 * public AccountValidator(Bank bank) { this.bank = bank; }
	 */

	public boolean validate(String command) {
		String[] parsed_command = command.split(" ");
		String check_command = parsed_command[0];

		if (check_command.equalsIgnoreCase("create")) {
			createAccountValidator = new CreateAccountValidator(bank);
			return createAccountValidator.validate(command);

		} else if (check_command.equalsIgnoreCase("deposit")) {
			depositValidate = new DepositValidate(bank);
			return depositValidate.validate(command);
		}
		return false;
	}

	public boolean validateID(int id) {

		if (id < 0) {
			return false;
		}
		String id_string = String.valueOf(id);

		if (id_string.length() == 8) {
			return true;

		} else {
			return false;
		}
	}

	public boolean validateAccountByString(String command) {
		String account_creation = command.toLowerCase();
		return true;
	}

}
