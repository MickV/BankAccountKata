package daveo.mickael.BankAccountKata;

import static junit.framework.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import formater.DateFormater;

public class HistoryTest {

    private History history;

    @Before
    public void init() throws ParseException {
        history = new History(new Printer());
    }

    @Test
    public void should_save_one_deposit() throws ParseException {
        Statement statement = new Statement(DateFormater.toDate("02-08-2008"), Amount.ofVal(BigDecimal.TEN), new Balance(Amount.oFZeroVal()), OperationType.DEPOSIT);
        history.saveStatement(statement);

        assertEquals(1, history.getStatements().size());
    }

    @Test
    public void should_print_one_deposit() throws ParseException {

        Printer printer = Mockito.mock(Printer.class);

        Statement statement = new Statement(DateFormater.toDate("02-02-08"), Amount.ofVal(BigDecimal.TEN), new Balance(Amount.oFZeroVal()), OperationType.DEPOSIT);
        History histo = new History(printer);

        histo.saveStatement(statement);
        histo.printAllStatementsSystemOut();

        Mockito.verify(printer).print("02-02-08| 10 DEPOSIT | Balance = 0");
    }

    @Test
    public void should_print_one_withDrawal() throws ParseException {

        Printer printer = Mockito.mock(Printer.class);

        Date date = DateFormater.toDate("08-02-18");
        
        Statement statement = new Statement(date, Amount.ofVal(new BigDecimal(4)), new Balance(Amount.oFZeroVal()), OperationType.WITHDRAWAL);
        History histo = new History(printer);

        histo.saveStatement(statement);
        histo.printAllStatementsSystemOut();

        Mockito.verify(printer).print("08-02-18| 4 WITHDRAWAL | Balance = 0");
    }

    @Test
    public void should_print_in_order() throws ParseException {

        Printer printer = Mockito.mock(Printer.class);
        InOrder inOrder = Mockito.inOrder(printer);

        Statement statement1 = new Statement(DateFormater.toDate("02-08-18"), Amount.ofVal(BigDecimal.TEN), new Balance(Amount.oFZeroVal()), OperationType.DEPOSIT);
        Statement statement2 = new Statement(DateFormater.toDate("03-08-18"), Amount.ofVal(BigDecimal.ONE), new Balance(Amount.oFZeroVal()), OperationType.DEPOSIT);
        Statement statement3 = new Statement(DateFormater.toDate("04-08-18"), Amount.ofVal(new BigDecimal(4)), new Balance(Amount.oFZeroVal()), OperationType.WITHDRAWAL);
        Statement statement4 = new Statement(DateFormater.toDate("05-08-18"), Amount.ofVal(new BigDecimal(8)), new Balance(Amount.oFZeroVal()), OperationType.WITHDRAWAL);

        History histo = new History(printer);

        histo.saveStatement(statement1);
        histo.saveStatement(statement2);
        histo.saveStatement(statement3);
        histo.saveStatement(statement4);

        //should run all printer.print()
        histo.printAllStatementsSystemOut();

        inOrder.verify(printer).print("02-08-18| 10 DEPOSIT | Balance = 0");
        inOrder.verify(printer).print("03-08-18| 1 DEPOSIT | Balance = 0");
         inOrder.verify(printer).print("04-08-18| 4 WITHDRAWAL | Balance = 0");
         inOrder.verify(printer).print("05-08-18| 8 WITHDRAWAL | Balance = 0");

    }
}
