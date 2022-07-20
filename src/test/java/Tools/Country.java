package Tools;

public class Country {
	
	public int countryNumber;
	public String countryName;
	public String countryLanguage;
	public String tripsTranslated;
	
	public Country() {
		this.countryNumber = 49;
		this.countryName = "Israel";
		this.countryLanguage = "Hebrew";
		this.tripsTranslated = "טיולים";
	}
	
	public Country(int countryNumber, String countryName, String countryLanguage, String tripsTranslated) {
		this.countryNumber = countryNumber;
		this.countryName = countryName;
		this.countryLanguage = countryLanguage;
		this.tripsTranslated = tripsTranslated;
	}
	
	public void printCountry() {
		System.out.println("CountryNumber " + this.countryNumber + ", " + this.countryName + ", " + this.countryLanguage + ", " + this.tripsTranslated);
	}
}
