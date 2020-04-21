package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DemoUtils;

public class FlipkartPage {
	
	public WebDriver pdriver;
	
	public FlipkartPage(WebDriver driver)
	{
		this.pdriver= driver;
	}

	
	@FindBy(xpath="//a[@class='_3Ep39l']")
	public WebElement btnlnkLogin;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	public WebElement btnclose;
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	public WebElement txtUserName;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	public WebElement btnLogin;
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	public WebElement txtSearch;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	public WebElement btnSearch;
	
	@FindBy(css = "div._3ybBIU div._1tz-RS div._3pNZKl:nth-child(2) div._1jA3uo:nth-child(3) div.dHGf8H div._1jcwFN._3dmQRh div:nth-child(1) > div._2aUbKa")
	public WebElement lblUserId;
	
	@FindBy(xpath="//span[@class='_2yAnYN']")
	public WebElement lblsrchResults;
	
	public void loginApp(String uname, String pass)
	{
		txtUserName.sendKeys(uname);
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
	public void search(String productName)
	{
		txtSearch.sendKeys(productName);
		btnSearch.click();
	}
	public Boolean validateSearchText(String ExpectedText)
	{
		Boolean strTextflag=false;
		String actual=lblsrchResults.getText().trim().replaceAll("\\s", "");
		String Expected=ExpectedText.replaceAll("\\s", "");
		if(actual.contains(Expected))
		{
			strTextflag=true;
		}
		return strTextflag;
	}
}