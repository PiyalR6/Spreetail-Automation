package pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchPage extends BasePageObject {

    WebDriverWait wait = new WebDriverWait(driver, 15);

    By searchBox = By.id("search-input");
    By suggestionDropBox = By.cssSelector(".Search__SuggesterContent-sc-20lott-4.epbhVG");
    By showingResultsFor = By.xpath("//h1[@class='Typography__H1Text-rz6iur-0 product-list-title Typography__LH1Text-rz6iur-7 iesNIc']");
    By noResultWarning = By.xpath("//div[@class='column is-10-desktop no-results']");


    public SearchPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void searchProductOnSearchPage(String product) throws IOException {
        sendkeys(searchBox, product+Keys.ENTER);
//        click(By.xpath("//form[@class='search-form ng-untouched ng-pristine ng-valid']//button[2]"));

    }

    public boolean verifyProductsList() throws IOException {
        //return isDisplayed(By.xpath("//h4[@class='category text-muted']"));

        if (isDisplayed(By.xpath("//h4[@class='category text-muted']"))) {
            return true;

        } else {
            return false;


        }

    }


    public void sendInputToSearchBox(String inputText) {
        sendkeys(searchBox, inputText);
        Assert.assertEquals(inputText, getAttributeValue(searchBox), "Input entered does not match with the what is in input box");
    }

    public void verifyDropDownList() throws IOException {
        String keySent = getAttributeValue(searchBox);
        if (keySent.length() >= 4) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionDropBox));
            Assert.assertTrue(isDisplayed(suggestionDropBox));
        } else {
            Assert.assertFalse(isDisplayed(suggestionDropBox));
        }
    }

    public void verifyWhenRandomlyOneElementIsClickedResultsMatchWithSelectedDropdown() throws IOException, InterruptedException {
        String keySent = getAttributeValue(searchBox);

        if (keySent.length() >= 4) {
            List<WebElement> dropdownList = driver.findElements(By.cssSelector(".Search__SuggesterContent-sc-20lott-4.epbhVG div"));
            Random random = new Random();
            int randomIndex = random.nextInt(dropdownList.size());
            keySent = dropdownList.get(randomIndex).getText();
            dropdownList.get(randomIndex).click();
        } else {
            sendkeys(searchBox, "" + Keys.ENTER);
        }

        List<WebElement> noResultFound = driver.findElements(By.xpath("//div[@class='column is-10-desktop no-results']"));
        Assert.assertEquals(noResultFound.size(), 0, "No Results Found!");
        List<WebElement> error = driver.findElements(By.cssSelector(".ErrorHandler__ErrorWrapper-sc-1iwj97q-0.dqbCJl"));
        Assert.assertEquals(error.size(), 0, "404 Error appeared");

        String[] keySentSplit = keySent.split(" ");

        Assert.assertTrue(getText(showingResultsFor).toLowerCase().contains(keySent.toLowerCase()), "You searched for " + keySent + " but " + getText(showingResultsFor) + " text is displayed");
        List<WebElement> productTitles = driver.findElements(By.xpath("//span[@class='LinesEllipsis  ']"));

        String keyword = null;
        for (WebElement title : productTitles) {
            boolean doesResultContainInputKeyword = false;

            for (String s : keySentSplit) {
                keyword = s;
                if (title.getText().toLowerCase().contains(s.toLowerCase())) {
                    doesResultContainInputKeyword = true;
                    break;
                }

            }
            Assert.assertTrue(doesResultContainInputKeyword, title.getText() + " DOES NOT CONTAIN " + keyword);
        }

    }


    public void whenUserSearchForItemResultMustMatchWithUsersInput(String searchText) throws IOException, InterruptedException {

        sendkeys(searchBox, searchText + Keys.ENTER);
        String keySent = searchText;


        List<WebElement> noResultFound = driver.findElements(By.xpath("//div[@class='column is-10-desktop no-results']"));
        Assert.assertEquals(noResultFound.size(), 0, "No Results Found!");

        List<WebElement> error = driver.findElements(By.cssSelector(".ErrorHandler__ErrorWrapper-sc-1iwj97q-0.dqbCJl"));
        Assert.assertEquals(error.size(), 0, "404 Error appeared");

        String[] keySentSplit = keySent.split(" ");

        Assert.assertTrue(getText(showingResultsFor).toLowerCase().contains(keySent.toLowerCase()), "You searched for " + keySent + " but " + getText(showingResultsFor) + " text is displayed");
        List<WebElement> productTitles = driver.findElements(By.xpath("//span[@class='LinesEllipsis  ']"));

        String keyword = null;
        for (WebElement title : productTitles) {
            boolean doesResultContainInputKeyword = false;

            for (String s : keySentSplit) {
                keyword = s;
                if (title.getText().toLowerCase().contains(s.toLowerCase())) {
                    doesResultContainInputKeyword = true;
                    break;
                }

            }
            Assert.assertTrue(doesResultContainInputKeyword, title.getText() + " DOES NOT CONTAIN " + keyword);
        }
    }


    public void noResultsError() throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultWarning));

        Assert.assertTrue(isDisplayed(noResultWarning),"No Result Warning did not show up");
    }
}

