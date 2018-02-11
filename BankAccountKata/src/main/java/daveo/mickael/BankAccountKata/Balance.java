package daveo.mickael.BankAccountKata;

public class Balance {

	private Amount currentAmount;

	public Balance(Amount amount) {
		this.currentAmount = amount;
	}

	public Amount getAmount() {
		return currentAmount;
	}

	public void setAmount(Amount amount) {
		this.currentAmount = amount;
	}

	public void deposit(Amount amount) {
		this.currentAmount.add(amount.getVal());
	}

	public void withDrawal(Amount amount) {
		this.currentAmount.substract(amount.getVal());
	}

	@Override
	public String toString() {
		return "Balance = " + currentAmount.getVal();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentAmount == null) ? 0 : currentAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balance other = (Balance) obj;
		if (currentAmount == null) {
			if (other.currentAmount != null)
				return false;
		} else if (!currentAmount.equals(other.currentAmount))
			return false;
		return true;
	}

}
