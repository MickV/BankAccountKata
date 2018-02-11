package daveo.mickael.BankAccountKata;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        History histo = new History(new Printer());

        Account neyMarAccount = new Account(Amount.ofVal(new BigDecimal(1000)), histo);

        neyMarAccount.withDrawal(Amount.ofVal(new BigDecimal(500)));
        neyMarAccount.deposit(Amount.ofVal(new BigDecimal(8)));
        neyMarAccount.withDrawal(Amount.ofVal(new BigDecimal(500)));
        neyMarAccount.deposit(Amount.ofVal(new BigDecimal(8)));
        neyMarAccount.withDrawal(Amount.ofVal(new BigDecimal(5)));
        neyMarAccount.withDrawal(Amount.ofVal(new BigDecimal(5)));
        neyMarAccount.printHistory();
    }
}
