public class DepositCommandProcessor {
	private Bank bank;

	public DepositCommandProcessor(Bank bank) {
		this.bank = bank;
	}

	public void executeCommand(String command) {
		String[] depositCommand = command.split(" ");
		int id = Integer.parseInt(depositCommand[1]);
		double amountToDeposit = Double.parseDouble(depositCommand[2]);
		bank.depositById(id, amountToDeposit);

	}
}
