public class CreateCommandProcessor {
	private Bank bank;

	public CreateCommandProcessor(Bank bank) {
		this.bank = bank;

	}

	public boolean executeCommand(String command) {
		String[] creationCommand = command.split(" ");
		int id = Integer.parseInt(creationCommand[2]);
		double apr = Double.parseDouble(creationCommand[3]);

		if (creationCommand[1].equalsIgnoreCase("checking")) {
			bank.createChecking(id, apr);
			return true;
		} else if (creationCommand[1].equalsIgnoreCase("savings")) {
			bank.createSavings(id, apr);
			return true;

		} else if (creationCommand[1].equalsIgnoreCase("cd")) {
			double depositAmount = Double.parseDouble(creationCommand[4]);
			bank.createCDaccount(id, apr, depositAmount);
			return true;
		}
		return false;
	}
}
