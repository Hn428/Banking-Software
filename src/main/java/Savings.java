public class Savings extends Account {
	public Savings(int id, double APR) {
		this.APR = APR;
		this.id = id;

	}

	@Override
	public boolean isDepositValid(double depositAmount) {
		if (depositAmount >= 0 && depositAmount <= 1000) {
			return true;
		}
		return false;
	}

}
