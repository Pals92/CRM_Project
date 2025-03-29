package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//=========================================Implicitly Wait======================================================== 
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	//============================================Explicit Wait================================================= 
		public void waitForELemntPresent(WebDriver driver, WebElement element) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void waitForELemntToBeClickAble(WebDriver driver, WebElement element) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public void waitForElementSelected(WebDriver driver, WebElement element)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}
		
		public void waitForElementPresent(WebDriver driver, WebElement element, String text)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}
		
		public void waitForURLloaded(WebDriver driver, String url)
		{
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.urlContains(url));
		}
		
		//=============================Switch to Window==============================================================
		//Switch to Child Window by Partial Url
		public void switchtoChildWindowWithPartialURL(WebDriver driver, String partialUrl) {
			Set<String> wids = driver.getWindowHandles();
			for (String id : wids) {
				driver.switchTo().window(id);
				if(driver.getCurrentUrl().contains(partialUrl)) {
					break;
				}
			}
		}

		//switch to window by partial title
		public void switchToTabOnTitle(WebDriver driver, String partialTitle)
		{
			Set<String> childWindow = driver.getWindowHandles();
			for (String child : childWindow) {
				driver.switchTo().window(child);
				String actURL = driver.getTitle();
				if(actURL.contains(partialTitle))
				{
					break;
				}
			}
		}
		
		//=========================Switching to Frames=============================
		//switch to frame by Index
		public void switchtoFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);			
		}
		
		public void switchtoFrame(WebDriver driver, String name) {
			driver.switchTo().frame(name);			
		}
		//switch to frame by webelement
		public void switchToFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/*==============================ALERT POP-UPS======================================== */
		
		//switch to alert pop up for accept
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		//switch to alert pop up for dismiss
		public void switchToAlertAndDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/*==============================DROP DOWN======================================== */
		
		public void select(WebElement element, String text)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
		//drop down element by index
		public void select(WebElement element, int index)
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		//drop down using value
		public void selectByValue(WebElement element,String text )
		{
			Select sel = new Select(element);
			sel.selectByValue(text);
		}
		
		/*==============================MOUSEHOVER ACTIONS======================================== */
		
		//mouse hover by webelement
		public void mousemoveOnElement(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		//double click by webelement
		public void doubleClick(WebDriver driver,WebElement element)
		{
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		//right click on webpage
		public void rightClick(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.contextClick().perform();
		}
			
		//right click on webelement
		public void rightClik(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.contextClick(element).click().perform();
		}
		
		/*==============================NAVIGATE METHODS======================================== */
		
		//maximizing windows
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		/*==============================DRAG AND DROP======================================== */
		
		//drag and drop
		public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(source, target).perform();
		}
		
		/*==============================SEND KEYS BY ACTION CLASS======================================== */
		
		//sendkeys using action class
		public void sendKeysByAction(WebDriver driver, WebElement element, String key)
		{
			Actions act = new Actions(driver);
			act.sendKeys(element, key).perform();
		}
		
		/*==============================SCROLL DOWN======================================== */
		
		//scroll by action class
		public void scrollDown(WebDriver driver, int x)
		{
			Actions act = new Actions(driver);
			act.scrollByAmount(0, x);
		}
		
		public void scrollHorizontally(WebDriver driver, int y)
		{
			Actions act = new Actions(driver);
			act.scrollByAmount(y, 0);
		}
		
		public void scrollDown(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.scrollToElement(element);
		}
		
		/*==============================SCROLL DOWN BY JS======================================== */
		
		//scroll by js
		public void scrollDownJs(WebDriver driver, int x, int y)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			for(int i=0;i<5;i++)
			{
				js.executeScript("windows.scollBy("+x+","+y+")");
			}
		}
		
		//scroll until element
		public void scrollDownJs(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("arguments[0].scrollIntoView(true);",element);
			
		}
		
		public void scrollDownJs(WebDriver driver)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			js.executeScript("window.scrollTo(0,document.body.scrollheight");
		}

}
