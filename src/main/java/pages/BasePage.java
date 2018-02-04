package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class BasePage  {

    protected Actions actions = new Actions(BaseSteps.getDriver());

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }

    public boolean isElementPresent(By element) {
        try{
            BaseSteps.getDriver().findElement(element);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public void waitAndClick(WebElement element){
        WebDriverWait wait1 = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait1.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /*
    public void swapToNextPage(){
        String currentWindow = BaseSteps.getDriver().getWindowHandle();
        for (String window : BaseSteps.getDriver().getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                BaseSteps.getDriver().switchTo().window(window);
            }
        }
    }
    */

}
