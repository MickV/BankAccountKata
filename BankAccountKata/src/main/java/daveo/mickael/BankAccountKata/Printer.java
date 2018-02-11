package daveo.mickael.BankAccountKata;

import java.io.PrintStream;

public class Printer {

    public void print(String dataStatement) {
        PrintStream printStream = new PrintStream(System.out);
        printStream.println(dataStatement);
    }
}
