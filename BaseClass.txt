package Assert.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	private static final Object ParentHandle = null;
	public static WebDriver d ;
	public static Alert a ;
	public static Actions ac ;
	public static Robot r ;
	public static JavascriptExecutor js ;
	public static Select s ;
	public static Alert alert;
		
	
// ----------------------------------------------------------------------------------------------------

	
	
	// Driver - ChromeDriver
	public static void chromeBrowser() {

		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
	}
	
	//Driver - EdgeDriver 
	public static void edgeDriver() {

		WebDriverManager.edgedriver().setup();
		d = new EdgeDriver();
	}
	
	
	public static WebDriver launchBrowser(String browsername) {	
	
		if (browsername.equalsIgnoreCase("edge")) {
				
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
	}

		else if (browsername.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		}
		
		else if (browsername.equalsIgnoreCase("firefox")) {
				
		WebDriverManager.firefoxdriver().setup();
		d = new FirefoxDriver();
	}	

		d.manage().window().maximize();

		return d;
	}
//	--------------------
	
//	LaunchUrl
	public static void launchUrl(String url) {

		d.get(url);
	}
	
//  --------------------
	
//	Maximize Window.
	public static void maxWindow() {

		d.manage().window().maximize();
	}
	
// Minimize	
	public static void miniWindow() {

		d.manage().window().maximize();
	}
	
//	--------------------
	
	//GetTitle
	public static void getTitle() {
		
		String title = d.getTitle();
		System.out.println(title);
	
	}

//	--------------------
	
	//GetCurrentUrl
	public static void getCurrenUrl() {

		String currentUrl = d.getCurrentUrl();
		System.out.println(currentUrl);
	}
	
//	--------------------
	
//	GetPagesource
	public static void getPagesource() {

		String pageSource = d.getPageSource();
		System.out.println(pageSource);
	}
	
//	--------------------
	
	
//											Navigate
	
//	Back
	public static void navgateBack(WebElement element) {

		d.navigate().back();
	}
	
//	Forward
	public static void forwardNavigate(WebElement element) {

		d.navigate().forward();
	}
	
//	Refresh
	public static void refreshNavigate(WebElement element) { 

		d.navigate().refresh();
	}
	
//	To
	public static void toNavigate(String url) {

		d.navigate().to(url);
	}
	
	
//	--------------------
	
	//
	
	//SenKeys
	public static void textBox(WebElement element,String value) {

		element.sendKeys(value);
	}
	
//	--------------------
	
//	ButtonClick
	public static void buttonClick(WebElement element) {

		element.click();		
	}
	
	
//	----------------------------------------------------------------------------------------------------
	
	
//										ScreenShot
	
	public static void screenShot(String location) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(location);
		FileUtils.copyFile(src, des);
		
	}
	
	
//	----------------------------------------------------------------------------------------------------

	
//										Alert Class
	
//	Accept
	public static void acceptButton() {

		d.switchTo().alert().accept();
	}
	
//	Dismiss
	public static void dismissButton() {

		d.switchTo().alert().dismiss();
	}
	
////	SendKeys
	public static void alertSendkeys(WebElement element, String Value) {

		Alert alert = d.switchTo().alert();
		
			
		alert.sendKeys(Value);
//		alert.accept(); 
	}

//	GetText

	
	public static void getText(WebElement element) {

		String text = element.getText();
		System.out.println(text);
	}
	

//	----------------------------------------------------------------------------------------------------

	 
//								  		Actions
	
	// 1. MovetoElement

	public static void movetoElement(WebElement element) {

		ac = new Actions(d);	
		ac.moveToElement(element);
		ac.build().perform();		
	}
	
	//2. Drag&Drop
	
	public static void dragAndDrop(WebElement src, WebElement des) {

		ac = new Actions(d);
		ac.dragAndDrop(src,des);
		ac.build().perform();
	}
	
	//3. ContextClick
	
	public static void contextClick(WebElement element) {

		ac = new Actions(d);
		ac.contextClick(element);
		ac.build().perform();
	}
	
	//4. DoubleClick 
	
	public static void doubleClick(WebElement element) {

		ac = new Actions(d);
		ac.doubleClick(element);
		ac.build().perform();
	}
	
	
// ----------------------------------------------------------------------------------------------------
	
	
//									Robot Class  (No: 200 - 812)
	
	// MainKeys
	
	//1. Enter 
	public static void enterButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	//2. BackSpace
	public static void backSpaceButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		
	}
	
	
	//Control
	public static void controlButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	//Shift 
	public static void shiftButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	
	//Delete
	public static void deleteBu() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
	}
	
	
	//Escape
	public static void escapeButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	
	//Tab
	public static void tabButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}
	
	
	//Windows
	public static void windowsButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_WINDOWS);
	}
	
	
	//CapsLock
	public static void capslockButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_CAPS_LOCK);
		r.keyRelease(KeyEvent.VK_CAPS_LOCK);
	}
	
	
	//Space
	public static void spaceButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
	}
	
	
//	-------------------- Arrow Key - Up Down Left Right

	//Up
	public static void upButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	
	
	//Down
	public static void downButton() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	
	
	//Left
	public static void leftButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
	}
	
	//Right
	public static  void rightButton() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
	}
	
//	-------------------- Numbers (0 to 9)
	
	//1
	public static void number1() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_1);
		r.keyRelease(KeyEvent.VK_1);	

	}

	
	//2
	public static void number2() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_2);
		r.keyRelease(KeyEvent.VK_2);	

	}
	
	
	//3
	public static void number3() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_3);
		r.keyRelease(KeyEvent.VK_3);	

	}
	
	
	//4
	public static void number4() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_4);
		r.keyRelease(KeyEvent.VK_4);	

	}
	
	
	//5
	public static void number5() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_5);
		r.keyRelease(KeyEvent.VK_5);	

	}
	
	
	//6
	public static void number6() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_6);
		r.keyRelease(KeyEvent.VK_6);	

	}
	
	
	//7
	public static void number7() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_7);
		r.keyRelease(KeyEvent.VK_7);	

	}
	
	
	//8
	public static void number8() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_8);
		r.keyRelease(KeyEvent.VK_8);	

	}
	
	
	//9
	public static void number9() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_9);
		r.keyRelease(KeyEvent.VK_9);	

	}

//	-------------------- Alphabet
	
	
	public static void a() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);	

	}
	
	
	public static void b() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);	

	}
	
	
	public static void c() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);	

	}
	
	
	public static void d() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);	

	}
	
	public static void e() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_E);	

	}
	
	
	public static void f() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_F);
		r.keyRelease(KeyEvent.VK_F);	

	}
	
	
	public static void g() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_G);
		r.keyRelease(KeyEvent.VK_G);	

	}
	
	
	public static void h() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);	

	}
	
	
	public static void i() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);	

	}
	
	
	public static void j() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_J);
		r.keyRelease(KeyEvent.VK_J);	

	}
	
	
	public static void k() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_K);
		r.keyRelease(KeyEvent.VK_K);	

	}
	
	
	public static void l() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_L);
		r.keyRelease(KeyEvent.VK_L);	

	}
	
	
	public static void m() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);	

	}
	
	
	
	public static void n() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);	

	}
	
	
	public static void o() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);	

	}
	
	
	public static void p() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);	

	}
	
	
	public static void q() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_Q);
		r.keyRelease(KeyEvent.VK_Q);	

	}
	
	
	public static void r() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_R);
		r.keyRelease(KeyEvent.VK_R);	

	}
	
	
	public static void s() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);	

	}
	
	
	public static void t() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);	

	}
	
	public static void u() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_U);
		r.keyRelease(KeyEvent.VK_U);	

	}
	
	
	public static void v() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);	

	}
	
	
	public static void w() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);	

	}
	

	public static void x() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);	

	}
	

	public static void y() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_Y);
		r.keyRelease(KeyEvent.VK_Y);	

	}
	
	public static void z() throws AWTException {
		
		r = new Robot();
		r.keyPress(KeyEvent.VK_Z);
		r.keyRelease(KeyEvent.VK_Z);	

	}
	
	
//	-------------------- Symbols
	
	//Slash
	public static void forwardSlash() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_SLASH);
		r.keyRelease(KeyEvent.VK_SLASH);			
	}
	
	
	//BackSlash
	public static void backSlash() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_BACK_SLASH);
		r.keyRelease(KeyEvent.VK_BACK_SLASH);			
	}
	
	
	//Colon
	public static void colen() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_COLON);
		r.keyRelease(KeyEvent.VK_COLON);			
	}
	
	//SemiColon
	public static void semiColen() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SEMICOLON);			
	}
	
	
	//Quotes
	public static void quotes() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_QUOTE);
		r.keyRelease(KeyEvent.VK_QUOTE);			
	}

	
	//DoubleQuotes
	public static void doubleQuotes() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_QUOTEDBL);
		r.keyRelease(KeyEvent.VK_QUOTEDBL);			
	}
	
	
	//LessThan
		public static void lessThan() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_LESS);
			r.keyRelease(KeyEvent.VK_LESS);			
		}
	
		
	//GreaterThan
	public static void greaterThan() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_GREATER);
			r.keyRelease(KeyEvent.VK_GREATER);			
		}
	
	
	//Exclamation !
	public static void exclamationSymbol() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_EXCLAMATION_MARK);
			r.keyRelease(KeyEvent.VK_EXCLAMATION_MARK);			
		}
		
		
	//At @
	public static void atSymbol() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_AT);
			r.keyRelease(KeyEvent.VK_AT);			
		}	
	 
	
	//Hash #
	public static void hashSymbol() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_NUMBER_SIGN);
			r.keyRelease(KeyEvent.VK_NUMBER_SIGN);			
		}
	
	
	//DollerSymbol $
	public static void dollerSymbol() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_DOLLAR);
			r.keyRelease(KeyEvent.VK_DOLLAR);			
		}
	
	
	//And &
	public static void andSymbol() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_AMPERSAND);
			r.keyRelease(KeyEvent.VK_AMPERSAND);			
		}
	
	
	//Star *
	public static void starSymbol() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_ASTERISK);
			r.keyRelease(KeyEvent.VK_ASTERISK);			
		}
	
	
	//Brackets - Left
	public static void leftBracket() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_BRACELEFT);
			r.keyRelease(KeyEvent.VK_BRACELEFT);			
		}
	
	
	//Brackets - Right
	public static void rightBracket() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_BRACERIGHT);
			r.keyRelease(KeyEvent.VK_BRACERIGHT);			
		}
	
	
	//ParenThisis - Left
	public static void parenthesisLeft() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_LEFT_PARENTHESIS);
			r.keyRelease(KeyEvent.VK_LEFT_PARENTHESIS);			
		}
	
	
	//ParenThisis - Right
	public static void parenthesisRight() throws AWTException {

			r = new Robot();
			r.keyPress(KeyEvent.VK_RIGHT_PARENTHESIS);
			r.keyRelease(KeyEvent.VK_RIGHT_PARENTHESIS);			
		}
	
//	-------------------- Copy - Cut - Paste - SelectAll 
	
//	1. - SelectAll 
	public static void selectAllText() throws AWTException {

		r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}
	
//	2. - CopyText 
	public static void copyText() throws AWTException {

		r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}
	
	
//	3. - CutText 
	public static void cutText() throws AWTException {

		r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}
	
	
//	4. - PasteText 
	public static void pasteText() throws AWTException {

		r = new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	
// ----------------------------------------------------------------------------------------------------

//																JavaScript Executor (SendKeys, Click, Scroll Up, Scroll Down).
	
//	1. SendKeys
	
	 public static void javaScriptSendkeys(String value,WebElement element) {

		  JavascriptExecutor js = (JavascriptExecutor)d ;
		 
		  js.executeScript("arguments[0].setAttribute('value')"+value,element);
		 
	}
	 
	 
//	 2. Click
	 
	 public static void JavaScriptClick(WebElement element) {

		 js = (JavascriptExecutor)d;
		 
		 js.executeScript("arguments[0].click()", element);
	}
	 
	 
//	 3.ScrollDown
	 public static void scrollDown(WebElement element) {

		 js = (JavascriptExecutor)d;
		 
		 js.executeScript("arguments[0].scrollIntoView(false);", element);
	}
	 
//	 4.ScrollUp
	 public static void scrollUp(WebElement element) {

		 js = (JavascriptExecutor)d;
		 
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	 
	
//---------------------------------------------------------------------------------------------------------------------------------------------------------
		
	 
//	 											Select Class
	 
//	 1. SelectByValues
	 public static void selectByValue(WebElement element,String Values) {

		 s = new Select(element);
		 
		 s.selectByValue(Values);
	}
	 
	 
//	 2. SelectByIndex
	 public static void selectByIndex(WebElement element,int number) {

		  s = new Select(element);
		  s.selectByIndex(number);
	}

	 
//	 3. SelectByVisisbleText
	 public static void selectByVisibleText(WebElement element, String Values ) {

		s = new Select(element);
		s.selectByVisibleText(Values);
	}
	 
	 
//	 4. DeSelectByValues
	 public static void deSelectByValue(WebElement element, String Value) {

		 s = new Select(element);
		 s.deselectByValue(Value);
	}
	 
	 
//	 5. DeSelectByIndex
	 public static void deSelectByIndex(WebElement element,int number) {

		  s = new Select(element);
		  s.deselectByIndex(number);
	}

	 
//	 6. DeSelectByVisisbleText
	 public static void deSelectByVisibleText(WebElement element, String Values ) {

		s = new Select(element);
		s.deselectByVisibleText(Values);
	}
	 
	 
//	7. GetFristSelectedOption
	 public static void getFristSelectedOption(WebElement element) {

		 s = new Select(element);
		 WebElement firstSelectedOption = s.getFirstSelectedOption();
		
		 System.out.println(firstSelectedOption.getText());
		 
	}
	 
	 
//	 8. GetAllSelectedOptions
	 public static void getAllSelectedOptions(WebElement element) {

		 s = new Select(element);
		 List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		 for (WebElement webElement : allSelectedOptions) {
			
			 System.out.println(webElement.getText());
		 }
	}
	 
	 
//	 9. GetOptions
	 public static void getOptions(WebElement element) {

		 s = new Select(element);
		 List<WebElement> options = s.getOptions();
		 for (WebElement webElement : options) {
			 System.out.println(webElement.getText());
		}
		 
	 }
	 
//	10. IsMulitiple
	 public static void isMulitple(WebElement element) {

		 s = new Select(element);
		 s.isMultiple();
	}
	 
//	11. DeSelectAll
	 public static void deSelectAll(WebElement element) {

		 s = new Select(element);
		 s.deselectAll();
	}
	 
	 
//---------------------------------------------------------------------------------------------------------------------------------------------------------
	 			
	 
//	 																Frame
	 
//	 1. FrameInteger
	 public static void intFrame(int number) {

		 d.switchTo().frame(number);
	 }
	 
	 
//	 2. String(Name & Id)
	 public static void stringFrame(WebElement element) {
		 
		 d.switchTo().frame(element);
	 }
	 
	 
//	 3. WebElement Frame
	 public static void webelementFrame(WebElement element) {
		 
		 d.switchTo().frame(element);
	 }
	
	 
	 
//---------------------------------------------------------------------------------------------------------------------------------------------------------
	 
	 		
//	 															WindowHandling (GetWindowHandle & GetWindowHandles)
	 
	 
//	 1. GetWindowHandle
	 public static void getWindowHandle() {

		 String ParentHandle = d.getWindowHandle();
		 
		 System.out.println("Id Of the CurrentWindow:"+ParentHandle);
	}
	 
	 
	 
//	 2.GetWindowHandles 
	 public static void getWindowHandles() {

		 Set<String> ChildHandles = d.getWindowHandles();
			
			for (String Handle : ChildHandles) {
				
				System.out.println("Id of the All Open Window :" +Handle);
				
				if (!Handle.equals(ParentHandle)) {
					
					d.switchTo().window(Handle);	
			}
	  }
				
		} 
	 
//	 3.SwitchParentWindow

	 
//---------------------------------------------------------------------------------------------------------------------------------------------------------


//	 												WaitConscept (Implicit, Explicit, Fluent)
	 
//	 1. ImplicitWait
	 public static void implicitWait(int sec) {

		 d.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	 
	 
	 
	 
//---------------------------------------------------------------------------------------------------------------------------------------------------------	 
	 
	 
//																Close and Quit
	 
//	 CloseBrowser
	 public static void closeBrowser() {

		 d.close();
	}
	 
//	 QuitBrowswer
	 public static void quitBrowser() {

		 d.quit();
	}
	 
	 
//---------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		
}
