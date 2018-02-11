package daveo.mickael.BankAccountKata;

import java.util.ArrayList;
import java.util.List;

public class History implements PrinterStatement {

    List<Statement> statements;
    Printer printer;

    public History(Printer printer) {
        this.statements = new ArrayList<Statement>();
        this.printer = printer;
    }

    public void saveStatement(Statement statement) {
        this.statements.add(statement);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public void printAllStatementsSystemOut() {
        this.statements.forEach(statement -> this.print(statement));
    }

    @Override
    public void print(Statement statement) {
        this.printer.print(statement.toString());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((statements == null) ? 0 : statements.hashCode());
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
        History other = (History) obj;
        if (statements == null) {
            if (other.statements != null)
                return false;
        } else if (!statements.equals(other.statements))
            return false;
        return true;
    }

}
