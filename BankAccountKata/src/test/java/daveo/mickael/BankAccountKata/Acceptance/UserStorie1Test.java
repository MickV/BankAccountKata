package daveo.mickael.BankAccountKata.Acceptance;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import daveo.mickael.BankAccountKata.Account;
import daveo.mickael.BankAccountKata.Amount;
import daveo.mickael.BankAccountKata.History;
import daveo.mickael.BankAccountKata.Printer;

public class UserStorie1Test {

    /**
        US 1:
        In order to save money
        As a bank client
        I want to make a deposit in my account
     */
    
    History histo = new History(new Printer());

    @Test
    public void should_be_3_after_deposit_3() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        Amount expectedVal = Amount.ofVal(new BigDecimal(3));
        account.deposit(expectedVal);

        assertEquals(expectedVal, account.getCurrentBalance().getAmount());
    }
}
