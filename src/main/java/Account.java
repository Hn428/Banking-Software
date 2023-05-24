public abstract class Account {

	protected double amount;
	protected double APR;
	protected int id;

	public Account() {
	}

	public int getID() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public double getAPR() {
		return APR;
	}

	public void addDeposit(double amountToDeposit) {

		amount += amountToDeposit;
	}

	public void withdrawAmount(double amountToWithdraw) {
		if (amountToWithdraw > amount) {

			amount = 0;
		} else {

			amount -= amountToWithdraw;
		}

	}

	public abstract boolean isDepositValid(double depositAmount);

}
