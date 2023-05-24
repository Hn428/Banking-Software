public class CreateAccountValidator extends CommandValidator {

	public CreateAccountValidator(Bank bank) {
		super(bank);
	}

	@Override
	public boolean validate(String command) {
		try {
			String[] parsed_command = command.split(" ");

			String accountType = parsed_command[1];
			int id = Integer.parseInt(parsed_command[2]);
			double apr = Double.parseDouble(parsed_command[3]);
			if (validateID(id) == true && doesDuplicateIdExists(id) == false && validateAPR(apr) == true
					&& validateAccountType(accountType) == true) {
				return true;
			}
			return false;
		}

		catch (NumberFormatException n) {
			return false;
		}

	}

	/*
	 * public boolean validateID(int id) {
	 * 
	 * 
	 * if (id < 0) { return false; } String id_string = String.valueOf(id);
	 * 
	 * if (id_string.length() == 8) { if (doesDuplicateIdExists(id) == false) {
	 * return true; } return false;
	 * 
	 * } else { return false; } }
	 */

	public boolean doesDuplicateIdExists(int id) {
		int new_id = id;
		if (bank.getAccounts().containsKey(new_id)) {
			return true;

		} else {
			return false;
		}

	}

	public boolean validateAPR(double apr) {
		if (apr >= 0 && apr <= 10) {
			return true;
		}
		return false;
	}

	public boolean validateAccountType(String accountType) {

		if (accountType.toLowerCase().equals("checking") || accountType.toLowerCase().equals("savings")
				|| accountType.toLowerCase().equals("cd")) {
			return true;
		}
		return false;
	}
}