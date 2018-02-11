package daveo.mickael.BankAccountKata;

import java.math.BigDecimal;

public class Amount {

	private BigDecimal val;

	public static Amount oFZeroVal(){
	    return new Amount(BigDecimal.ZERO);
	}
	
	public static Amount ofVal(BigDecimal val){
	    return new Amount(val);
	}
	
	private Amount(BigDecimal val) {
		this.val = val;
	}

	public BigDecimal getVal() {
		return val;
	}

	public void setVal(BigDecimal val) {
		this.val = val;
	}

	public void add(BigDecimal val) {
		this.val = this.val.add(val);
	}

	public void substract(BigDecimal val) {
		this.val = this.val.subtract(val);
	}

	@Override
	public String toString() {
		return "Amount [val=" + val + "]";
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((val == null) ? 0 : val.hashCode());
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
        Amount other = (Amount) obj;
        if (val == null) {
            if (other.val != null)
                return false;
        } else if (!val.equals(other.val))
            return false;
        return true;
    }

	


}
