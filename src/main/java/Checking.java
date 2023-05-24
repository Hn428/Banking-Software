public class Checking extends Account {

	public Checking(int id, double APR) {
		this.APR = APR;
		this.id = id;

	}

	public boolean isDepositValid(double depositAmount) {
		if (depositAmount >= 0 && depositAmount <= 2500) {
			return true;
		}
		return false;
	}

}
