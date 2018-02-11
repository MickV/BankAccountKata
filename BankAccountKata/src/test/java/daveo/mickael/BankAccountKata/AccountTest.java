package daveo.mickael.BankAccountKata;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class AccountTest {

    History histo = new History(new Printer());
    
    @Test
    public void should_be_3_after_deposit_3() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        Amount expectedVal = Amount.ofVal(new BigDecimal(3));
        account.deposit(expectedVal);

        assertEquals(expectedVal, account.getCurrentBalance().getAmount());
    }

    @Test
    public void should_be_0_when_withDrawal_more_than_total() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        Amount valToWithDraw = Amount.ofVal(BigDecimal.TEN);
        account.withDrawal(valToWithDraw);

        Amount expectedVal = Amount.ofVal(new BigDecimal(0));
        assertEquals(expectedVal, account.getCurrentBalance().getAmount());
    }

    @Test
    public void should_deposit_1000_and_withdraw_397() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        Amount valToDeposit = Amount.ofVal(new BigDecimal(1000));
        account.deposit(valToDeposit);
        Amount valToWithDraw = Amount.ofVal(new BigDecimal(397));
        account.withDrawal(valToWithDraw);

        Amount expectedVal = Amount.ofVal(new BigDecimal(603));
        assertEquals(expectedVal, account.getCurrentBalance().getAmount());
    }

    @Test
    public void should_save_statement_when_deposited() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        account.deposit(Amount.ofVal(BigDecimal.TEN));
        account.deposit(Amount.ofVal(BigDecimal.TEN));

        assertEquals(2, account.getHistory().getStatements().size());
    }

    @Test
    public void should_save_statment_when_withDrawed() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        Amount amount1 = Amount.ofVal(BigDecimal.ONE);
        Amount amount2 = Amount.ofVal(BigDecimal.TEN);
        Amount amount3 = Amount.ofVal(BigDecimal.ONE);

        account.withDrawal(amount1);
        account.withDrawal(amount2);
        account.withDrawal(amount3);

        assertEquals(3, account.getHistory().getStatements().size());
    }

    @Test
    public void should_save_statments_when_deposits_and_withDraws() {
        Account account = new Account(Amount.oFZeroVal(), histo);

        account.deposit(Amount.ofVal(BigDecimal.TEN));
        account.deposit(Amount.ofVal(BigDecimal.ONE));
        account.withDrawal(Amount.ofVal(new BigDecimal(1000)));
        account.withDrawal(Amount.ofVal(BigDecimal.ONE));
        account.withDrawal(Amount.ofVal(BigDecimal.ONE));

        List<Statement> statementsWithDraw = account.getHistory().getStatements().stream()
                                                    .filter(statement -> statement.getOperation() == OperationType.WITHDRAWAL).collect(Collectors.toList());

        List<Statement> statementsDeposit = account.getHistory().getStatements().stream()
                                                   .filter(statement -> statement.getOperation() == OperationType.DEPOSIT).collect(Collectors.toList());

        assertEquals(5, account.getHistory().getStatements().size());
        assertEquals(3, statementsWithDraw.size());
        assertEquals(2, statementsDeposit.size());

    }
    
    

}
