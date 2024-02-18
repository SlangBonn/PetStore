package test;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class PetStoreAutomation {

	public static void main(String[] args) throws InterruptedException{
		
		// Use chromedriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	  
		/* Webseiten öffnen*/
		driver.get("https://petstore.octoperf.com");
		
		// Click the link "Enter the Store"
		WebElement initialLink = driver.findElement(By.linkText("Enter the Store"));
		initialLink.click();
		
		//Click the link "Sign In"		
		WebElement signInLink = driver.findElement(By.linkText("Sign In"));
		signInLink.click();
		
		//Type username in field username
		WebElement textBoxUsername = driver.findElement(By.name("username"));
		textBoxUsername.sendKeys("j2ee");
		
		//Type password in field password and press enter-key
		WebElement textBoxPassword = driver.findElement(By.name("password"));
		textBoxPassword.clear();
		textBoxPassword.sendKeys("j2ee", Keys.ENTER);
		
		//Click on the image "Dogs"
		WebElement imageDogs = driver.findElement(By.xpath("//img[@src='../images/dogs_icon.gif']"));
		imageDogs.click();
			
		//Click on the article ID of Golden Retriever
		WebElement arcticlelID = driver.findElement(By.linkText("K9-RT-01"));
		arcticlelID.click();
		
		//Click on the "add to cart" button		
		WebElement addToChart = driver.findElement(By.xpath("//td[a[contains(@class, 'Button')]]"));
		addToChart.click();
		
		//Insert 2 in the field "quantity"
		WebElement quantity = driver.findElement(By.name("EST-28"));
		quantity.clear();
		quantity.sendKeys("2");
		
		//Click the button "Update cart"
		WebElement ButtonUpdateCart = driver.findElement(By.name("updateCartQuantities"));
		ButtonUpdateCart.click();
		
		
		//Check if the amount for two Golden Retrivers is correct
		float pricePerGoldenRetriver = 155.29f;
		float priceForTwoGoldenRetriverShould = pricePerGoldenRetriver*2;
		
		String stringpriceForTwoGoldenRetriverShould = String.format(Locale.US, "$%.2f", priceForTwoGoldenRetriverShould);
		String stringpriceForTwoGoldenRetrieverActual = driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[7]")).getText();
		
        if (stringpriceForTwoGoldenRetriverShould.equals(stringpriceForTwoGoldenRetrieverActual)) {
            System.out.println("The price for two Golden Retrievers (" + stringpriceForTwoGoldenRetrieverActual + ") is correct.");
        } else {
            System.out.println("The price for two Golden Retrievers (" + stringpriceForTwoGoldenRetrieverActual + ") is not correct.");
        }
	
        
        /*
        //Check if the amount for two Golden Retrivers is correct (easier way)
        WebElement priceForTwoGoldenRetrieverActual2 = driver.findElement(By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[7]"));
        String priceForTwoGoldenRetrieverActual2Text = priceForTwoGoldenRetrieverActual2.getText();
        if ("$310.58".equals(priceForTwoGoldenRetrieverActual2Text)) {
            System.out.println("The price for two Golden Retrievers (" + priceForTwoGoldenRetrieverActual2Text + ") is correct.");
        } else {
            System.out.println("The price for two Golden Retrievers (" + priceForTwoGoldenRetrieverActual2Text + ") is not correct.");
        }
        */
        
        //Click button "Proceed to checkout"
        WebElement buttonProceedToCheckout = driver.findElement(By.linkText("Proceed to Checkout"));
        buttonProceedToCheckout.click();
        
        //Choose "Master Card" from the dropdown
        WebElement dropdownCardType = driver.findElement(By.name("order.cardType"));
        Select select = new Select(dropdownCardType);
        select.selectByValue("MasterCard");
        
        //Enter Credit Card
        WebElement textfieldCreditCart = driver.findElement(By.name("order.creditCard"));
        textfieldCreditCart.clear();
        textfieldCreditCart.sendKeys("1234 5678 9012 3456");
        
        //Enter Expriry Date
        WebElement textfieldExpiryDate = driver.findElement(By.name("order.expiryDate"));
        textfieldExpiryDate.clear();
        textfieldExpiryDate.sendKeys("08/26");

        //Enter First Name
        WebElement textfieldFirstName = driver.findElement(By.name("order.billToFirstName"));
        textfieldFirstName.clear();
        textfieldFirstName.sendKeys("Some");
        
        //Enter Last name
        WebElement textfieldLastName = driver.findElement(By.name("order.billToLastName"));
        textfieldLastName.clear();
        textfieldLastName.sendKeys("One");
        
        //Enter "Adress1"
        WebElement textfieldBillAdress1 = driver.findElement(By.name("order.billAddress1"));
        textfieldBillAdress1.clear();
        textfieldBillAdress1.sendKeys("123 Test Street");
        
        //Enter "Adress2"
        WebElement textfieldBillAdress2 = driver.findElement(By.name("order.billAddress2"));
        textfieldBillAdress2.clear();
        textfieldBillAdress2.sendKeys("MS UCUP12-123");
        
        //Enter City
        WebElement textfieldCity= driver.findElement(By.name("order.billCity"));
        textfieldCity.clear();
        textfieldCity.sendKeys("Test City");
        
        //Enter State
        WebElement textfieldState= driver.findElement(By.name("order.billState"));
        textfieldState.clear();
        textfieldState.sendKeys("TS");
        
        //Enter zip-code
        WebElement textfieldZipCode= driver.findElement(By.name("order.billZip"));
        textfieldZipCode.clear();
        textfieldZipCode.sendKeys("12345");
        
        //Enter country
        WebElement textfieldCountry= driver.findElement(By.name("order.billCountry"));
        textfieldCountry.clear();
        textfieldCountry.sendKeys("USA");
        
        //Click button "Continue"
        WebElement ButtonContinue = driver.findElement(By.name("newOrder"));
        ButtonContinue.click();
        
        // Validate if first name is correct

        WebElement tdElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[3]/td[2]"));
        if (tdElement.getText().equals("Some")) {
            System.out.println("The first name is correct");
        } else {
            System.out.println("The first name is not correct");
        }
        
        //Click the button "Confirm"
        WebElement buttonConfirm = driver.findElement(By.linkText("Confirm"));
        buttonConfirm.click();
        
        //String searchTerm = "Thank you, your order has been submitted.";
        
        try {
            // Finde das Element mit dem Text
            WebElement searchTerm = driver.findElement(By.xpath("//*[contains(text(), 'Thank you, your order has been submitted.')]"));

            // Überprüfe, ob das Element gefunden wurde
            if (searchTerm != null) {
                System.out.println("Text 'Thank you, your order has been submitted.' has been found.");
            } else {
                System.out.println("Text 'Thank you, your order has been submitted.' has not been found.");
            }

        } catch (Exception e) {
            System.err.println("Ein Fehler ist aufgetreten: " + e.getMessage());
        } finally {
            // Schließe den WebDriver
            driver.quit();
        
	}
	
}
}
