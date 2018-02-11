package daveo.mickael.BankAccountKata;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class BalanceTest {

	@Test
	public void should_deposit_amount() {
		Balance balance = new Balance(Amount.oFZeroVal());
		
		Amount expectedVal = Amount.ofVal(BigDecimal.TEN);
        balance.deposit(expectedVal);
		
		assertEquals(expectedVal, balance.getAmount());
	}
	
	@Test
	public void should_withDrawal_amount() {
		Balance balance = new Balance(Amount.oFZeroVal());

		
        balance.withDrawal(Amount.ofVal(BigDecimal.TEN));
		
        Amount expectedVal = Amount.ofVal(new BigDecimal(-10));
		assertEquals(expectedVal, balance.getAmount());
	}
}
