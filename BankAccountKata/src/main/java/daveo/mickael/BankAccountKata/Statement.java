package daveo.mickael.BankAccountKata;

import java.util.Date;

import formater.DateFormater;

public class Statement {

	private Date dateOperation;
	private Amount amountOperation;
	private Balance balanceOperation;
	private OperationType operation;

	public Statement(Date date, Amount amountOperation, Balance balanceOperation, OperationType operation) {
		this.dateOperation = date;
		this.amountOperation = amountOperation;
		this.balanceOperation = new Balance(Amount.ofVal(balanceOperation.getAmount().getVal()));
		this.operation = operation;
	}

	public String toString() {
		return DateFormater.formatDate(dateOperation) + "| " + amountOperation.getVal() + " " + operation + " | "
				+ balanceOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public Amount getAmountOperation() {
		return amountOperation;
	}

	public void setAmountOperation(Amount amountOperation) {
		this.amountOperation = amountOperation;
	}

	public Balance getBalanceOperation() {
		return balanceOperation;
	}

	public void setBalanceOperation(Balance balanceOperation) {
		this.balanceOperation = balanceOperation;
	}

	public OperationType getOperation() {
		return operation;
	}

	public void setOperation(OperationType operation) {
		this.operation = operation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountOperation == null) ? 0 : amountOperation.hashCode());
		result = prime * result + ((balanceOperation == null) ? 0 : balanceOperation.hashCode());
		result = prime * result + ((dateOperation == null) ? 0 : dateOperation.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
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
		Statement other = (Statement) obj;
		if (amountOperation == null) {
			if (other.amountOperation != null)
				return false;
		} else if (!amountOperation.equals(other.amountOperation))
			return false;
		if (balanceOperation == null) {
			if (other.balanceOperation != null)
				return false;
		} else if (!balanceOperation.equals(other.balanceOperation))
			return false;
		if (dateOperation == null) {
			if (other.dateOperation != null)
				return false;
		} else if (!dateOperation.equals(other.dateOperation))
			return false;
		if (operation != other.operation)
			return false;
		return true;
	}

}
