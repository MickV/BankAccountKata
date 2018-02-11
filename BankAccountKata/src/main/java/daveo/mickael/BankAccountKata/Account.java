package daveo.mickael.BankAccountKata;

import java.util.Date;

public class Account {

	private Balance currentBalance;
	private History history;

	public Account(Amount amount, History histo) {
		this.currentBalance = new Balance(amount);
		this.history =histo;
	}

	public void deposit(Amount amount) {
		this.currentBalance.deposit(amount);
		this.history.saveStatement(new Statement(new Date(), amount, currentBalance, OperationType.DEPOSIT));
	}

	public void withDrawal(Amount amount) {
	    if(amount.getVal().compareTo(this.currentBalance.getAmount().getVal())==1){
	        this.currentBalance.setAmount(Amount.oFZeroVal());
	    }else{
	        this.currentBalance.withDrawal(amount);
	    }
		this.history.saveStatement(new Statement(new Date(), amount, currentBalance, OperationType.WITHDRAWAL));
	}

	public void printHistory() {
		this.history.printAllStatementsSystemOut();
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public Balance getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Balance currentBalance) {
		this.currentBalance = currentBalance;
	}

}
