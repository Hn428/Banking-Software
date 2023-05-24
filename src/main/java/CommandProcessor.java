public class CommandProcessor {
	protected CreateCommandProcessor createCommandProcessor;
	protected DepositCommandProcessor depositCommandProcessor;
	private Bank bank;

	public CommandProcessor(Bank bank) {
		this.bank = bank;
	}

	public boolean executeCommand(String command) {
		String[] parsedCommand = command.split(" ");
		if (parsedCommand[0].equalsIgnoreCase("create")) {
			createCommandProcessor = new CreateCommandProcessor(bank);
			return createCommandProcessor.executeCommand(command);
		} else if (parsedCommand[0].equalsIgnoreCase("deposit")) {
			depositCommandProcessor = new DepositCommandProcessor(bank);
			depositCommandProcessor.executeCommand(command);
			return true;

		}
		return false;
	}
}
