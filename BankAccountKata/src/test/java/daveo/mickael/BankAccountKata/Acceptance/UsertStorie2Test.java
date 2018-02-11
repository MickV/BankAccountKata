package daveo.mickael.BankAccountKata.Acceptance;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import daveo.mickael.BankAccountKata.Account;
import daveo.mickael.BankAccountKata.Amount;
import daveo.mickael.BankAccountKata.History;
import daveo.mickael.BankAccountKata.Printer;

public class UsertStorie2Test {

    History histo = new History(new Printer());
    
    /**
     * US 2:
     * In order to retrieve some or all of my savings
     * As a bank client
     * I want to make a withdrawal from my account
     */
    @Test
    public void should_be_6_after_withdrawal_4() {
        Account account = new Account(Amount.ofVal(BigDecimal.TEN) , histo);

        Amount valToWithDraw = Amount.ofVal(new BigDecimal(4));
        account.withDrawal(valToWithDraw);

        Amount expectedVal = Amount.ofVal(new BigDecimal(6));
        assertEquals(expectedVal, account.getCurrentBalance().getAmount());
    }
    
    @Test
    public void should_be_0_after_withdrawal_more_than_total() {
        Account account = new Account(Amount.ofVal(BigDecimal.TEN), histo);

        Amount valToWithDraw = Amount.ofVal(new BigDecimal(11));
        account.withDrawal(valToWithDraw);

        Amount expectedVal = Amount.ofVal(new BigDecimal(0));
        assertEquals(expectedVal, account.getCurrentBalance().getAmount());
    }
}
