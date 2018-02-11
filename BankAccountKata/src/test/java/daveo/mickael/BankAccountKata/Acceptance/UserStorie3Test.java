package daveo.mickael.BankAccountKata.Acceptance;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import daveo.mickael.BankAccountKata.Account;
import daveo.mickael.BankAccountKata.Amount;
import daveo.mickael.BankAccountKata.History;
import daveo.mickael.BankAccountKata.Printer;
import formater.DateFormater;

public class UserStorie3Test {

    
    /**
        US 3:
        In order to check my operations
        As a bank client
        I want to see the history (operation, date, amount, balance)  of my operations
     */
    @Test
    public void should_print_in_order() throws ParseException {


        Printer printer = Mockito.mock(Printer.class);
        InOrder inOrder = Mockito.inOrder(printer);
        Date today = new Date();
        String todayString = DateFormater.formatDate(today);

        History histo = new History(printer);

        Account account = new Account(Amount.oFZeroVal(), histo);

        account.deposit(Amount.ofVal(new BigDecimal(1000)));
        account.withDrawal(Amount.ofVal(BigDecimal.ONE));
        account.deposit(Amount.ofVal(BigDecimal.TEN));
        account.deposit(Amount.ofVal(BigDecimal.ONE));
        account.withDrawal(Amount.ofVal(new BigDecimal(42)));

        histo.printAllStatementsSystemOut();

        inOrder.verify(printer).print(todayString+"| 1000 DEPOSIT | Balance = 1000");
        inOrder.verify(printer).print(todayString+"| 1 WITHDRAWAL | Balance = 999");
        inOrder.verify(printer).print(todayString+"| 10 DEPOSIT | Balance = 1009");
        inOrder.verify(printer).print(todayString+"| 1 DEPOSIT | Balance = 1010");
        inOrder.verify(printer).print(todayString+"| 42 WITHDRAWAL | Balance = 968");

    }
}
