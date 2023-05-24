public class CDAccount extends Account {
	double amount;

	public CDAccount(int id, double APR, double depositedAmount) {
		this.amount = depositedAmount;
		this.APR = APR;
		this.id = id;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public boolean isDepositValid(double depositAmount) {

		return false;
	}

}
