package Tools;

public class Currency {
	
	public int currencyNumber;
	public String currencyName;
	public String currencySign;
	
	public Currency() {
		this.currencyNumber = 1;
		this.currencyName = "US-Dollar";
		this.currencySign = "$";
	}
	
	public Currency(int currencyNumber, String currencyName, String currencySign) {
		this.currencyNumber = currencyNumber;
		this.currencyName = currencyName;
		this.currencySign = currencySign;
	}
	
	public void printCurrency() {
		System.out.println("CurrencyNumber " + this.currencyNumber + ", " + this.currencyName + ", " + this.currencySign);
	}
}
