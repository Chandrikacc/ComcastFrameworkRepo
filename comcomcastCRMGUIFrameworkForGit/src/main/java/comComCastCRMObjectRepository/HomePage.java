package comComCastCRMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	public WebElement getContactLink() {
		return contactLink;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutIcon;

	public WebElement getLogoutIcon() {
		return logoutIcon;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public void logoutFromApplication() {
		logoutIcon.click();
		signoutLink.click();
	}

}
