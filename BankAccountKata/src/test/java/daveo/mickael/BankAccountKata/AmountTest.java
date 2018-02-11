package daveo.mickael.BankAccountKata;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AmountTest {

    @Test
    public void should_be_0_when_init() {
        Amount amount = Amount.oFZeroVal();
        assertEquals(BigDecimal.ZERO, amount.getVal());
    }

    @Test
    public void should_add_10() {
        Amount amount = Amount.oFZeroVal();
        
        amount.add(BigDecimal.TEN);
        
        assertEquals(BigDecimal.TEN, amount.getVal());
    }

    @Test
    public void should_substract_10() {
        Amount amount = Amount.oFZeroVal();
        
        amount.substract(BigDecimal.TEN);
        
        BigDecimal expectedVal = new BigDecimal(-10);
        assertEquals(expectedVal, amount.getVal());
    }
}
